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

import com.entity.JingsaileibieEntity;
import com.entity.view.JingsaileibieView;

import com.service.JingsaileibieService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 竞赛类别
 * 后端接口
 * @author 
 * @email 
 * @date 2023-05-15 14:23:37
 */
@RestController
@RequestMapping("/jingsaileibie")
public class JingsaileibieController {
    @Autowired
    private JingsaileibieService jingsaileibieService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JingsaileibieEntity jingsaileibie,
		HttpServletRequest request){
        EntityWrapper<JingsaileibieEntity> ew = new EntityWrapper<JingsaileibieEntity>();

		PageUtils page = jingsaileibieService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jingsaileibie), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JingsaileibieEntity jingsaileibie, 
		HttpServletRequest request){
        EntityWrapper<JingsaileibieEntity> ew = new EntityWrapper<JingsaileibieEntity>();

		PageUtils page = jingsaileibieService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jingsaileibie), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JingsaileibieEntity jingsaileibie){
       	EntityWrapper<JingsaileibieEntity> ew = new EntityWrapper<JingsaileibieEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jingsaileibie, "jingsaileibie")); 
        return R.ok().put("data", jingsaileibieService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JingsaileibieEntity jingsaileibie){
        EntityWrapper< JingsaileibieEntity> ew = new EntityWrapper< JingsaileibieEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jingsaileibie, "jingsaileibie")); 
		JingsaileibieView jingsaileibieView =  jingsaileibieService.selectView(ew);
		return R.ok("查询竞赛类别成功").put("data", jingsaileibieView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JingsaileibieEntity jingsaileibie = jingsaileibieService.selectById(id);
        return R.ok().put("data", jingsaileibie);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JingsaileibieEntity jingsaileibie = jingsaileibieService.selectById(id);
        return R.ok().put("data", jingsaileibie);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JingsaileibieEntity jingsaileibie, HttpServletRequest request){
    	jingsaileibie.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jingsaileibie);
        jingsaileibieService.insert(jingsaileibie);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JingsaileibieEntity jingsaileibie, HttpServletRequest request){
    	jingsaileibie.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jingsaileibie);
        jingsaileibieService.insert(jingsaileibie);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JingsaileibieEntity jingsaileibie, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jingsaileibie);
        jingsaileibieService.updateById(jingsaileibie);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jingsaileibieService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
