package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.JingsaibaomingEntity;
import com.entity.view.JingsaibaomingView;

import com.service.JingsaibaomingService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 竞赛报名
 * 后端接口
 * @author 
 * @email 
 * @date 2023-05-15 14:23:37
 */
@RestController
@RequestMapping("/jingsaibaoming")
public class JingsaibaomingController {
    @Autowired
    private JingsaibaomingService jingsaibaomingService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JingsaibaomingEntity jingsaibaoming,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("fuzeren")) {
			jingsaibaoming.setFuzerenzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("xuesheng")) {
			jingsaibaoming.setXueshengxuehao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<JingsaibaomingEntity> ew = new EntityWrapper<JingsaibaomingEntity>();

		PageUtils page = jingsaibaomingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jingsaibaoming), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JingsaibaomingEntity jingsaibaoming, 
		HttpServletRequest request){
        EntityWrapper<JingsaibaomingEntity> ew = new EntityWrapper<JingsaibaomingEntity>();

		PageUtils page = jingsaibaomingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jingsaibaoming), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JingsaibaomingEntity jingsaibaoming){
       	EntityWrapper<JingsaibaomingEntity> ew = new EntityWrapper<JingsaibaomingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jingsaibaoming, "jingsaibaoming")); 
        return R.ok().put("data", jingsaibaomingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JingsaibaomingEntity jingsaibaoming){
        EntityWrapper< JingsaibaomingEntity> ew = new EntityWrapper< JingsaibaomingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jingsaibaoming, "jingsaibaoming")); 
		JingsaibaomingView jingsaibaomingView =  jingsaibaomingService.selectView(ew);
		return R.ok("查询竞赛报名成功").put("data", jingsaibaomingView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JingsaibaomingEntity jingsaibaoming = jingsaibaomingService.selectById(id);
        return R.ok().put("data", jingsaibaoming);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JingsaibaomingEntity jingsaibaoming = jingsaibaomingService.selectById(id);
        return R.ok().put("data", jingsaibaoming);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JingsaibaomingEntity jingsaibaoming, HttpServletRequest request){
    	jingsaibaoming.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jingsaibaoming);
        jingsaibaomingService.insert(jingsaibaoming);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JingsaibaomingEntity jingsaibaoming, HttpServletRequest request){
    	jingsaibaoming.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jingsaibaoming);
        jingsaibaomingService.insert(jingsaibaoming);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JingsaibaomingEntity jingsaibaoming, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jingsaibaoming);
        jingsaibaomingService.updateById(jingsaibaoming);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<JingsaibaomingEntity> list = new ArrayList<JingsaibaomingEntity>();
        for(Long id : ids) {
            JingsaibaomingEntity jingsaibaoming = jingsaibaomingService.selectById(id);
            jingsaibaoming.setSfsh(sfsh);
            jingsaibaoming.setShhf(shhf);
            list.add(jingsaibaoming);
        }
        jingsaibaomingService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jingsaibaomingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
