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

import com.entity.ChengguoxiangqingEntity;
import com.entity.view.ChengguoxiangqingView;

import com.service.ChengguoxiangqingService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 成果详情
 * 后端接口
 * @author 
 * @email 
 * @date 2023-05-15 14:23:37
 */
@RestController
@RequestMapping("/chengguoxiangqing")
public class ChengguoxiangqingController {
    @Autowired
    private ChengguoxiangqingService chengguoxiangqingService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ChengguoxiangqingEntity chengguoxiangqing,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("fuzeren")) {
			chengguoxiangqing.setFuzerenzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("xuesheng")) {
			chengguoxiangqing.setXueshengxuehao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ChengguoxiangqingEntity> ew = new EntityWrapper<ChengguoxiangqingEntity>();

		PageUtils page = chengguoxiangqingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chengguoxiangqing), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ChengguoxiangqingEntity chengguoxiangqing, 
		HttpServletRequest request){
        EntityWrapper<ChengguoxiangqingEntity> ew = new EntityWrapper<ChengguoxiangqingEntity>();

		PageUtils page = chengguoxiangqingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chengguoxiangqing), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ChengguoxiangqingEntity chengguoxiangqing){
       	EntityWrapper<ChengguoxiangqingEntity> ew = new EntityWrapper<ChengguoxiangqingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( chengguoxiangqing, "chengguoxiangqing")); 
        return R.ok().put("data", chengguoxiangqingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ChengguoxiangqingEntity chengguoxiangqing){
        EntityWrapper< ChengguoxiangqingEntity> ew = new EntityWrapper< ChengguoxiangqingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( chengguoxiangqing, "chengguoxiangqing")); 
		ChengguoxiangqingView chengguoxiangqingView =  chengguoxiangqingService.selectView(ew);
		return R.ok("查询成果详情成功").put("data", chengguoxiangqingView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ChengguoxiangqingEntity chengguoxiangqing = chengguoxiangqingService.selectById(id);
        return R.ok().put("data", chengguoxiangqing);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ChengguoxiangqingEntity chengguoxiangqing = chengguoxiangqingService.selectById(id);
        return R.ok().put("data", chengguoxiangqing);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ChengguoxiangqingEntity chengguoxiangqing, HttpServletRequest request){
    	chengguoxiangqing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(chengguoxiangqing);
        chengguoxiangqingService.insert(chengguoxiangqing);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ChengguoxiangqingEntity chengguoxiangqing, HttpServletRequest request){
    	chengguoxiangqing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(chengguoxiangqing);
        chengguoxiangqingService.insert(chengguoxiangqing);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ChengguoxiangqingEntity chengguoxiangqing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(chengguoxiangqing);
        chengguoxiangqingService.updateById(chengguoxiangqing);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<ChengguoxiangqingEntity> list = new ArrayList<ChengguoxiangqingEntity>();
        for(Long id : ids) {
            ChengguoxiangqingEntity chengguoxiangqing = chengguoxiangqingService.selectById(id);
            chengguoxiangqing.setSfsh(sfsh);
            chengguoxiangqing.setShhf(shhf);
            list.add(chengguoxiangqing);
        }
        chengguoxiangqingService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        chengguoxiangqingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
