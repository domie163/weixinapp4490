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

import com.entity.ZhuanyeEntity;
import com.entity.view.ZhuanyeView;

import com.service.ZhuanyeService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 专业
 * 后端接口
 * @author 
 * @email 
 * @date 2023-05-15 14:23:36
 */
@RestController
@RequestMapping("/zhuanye")
public class ZhuanyeController {
    @Autowired
    private ZhuanyeService zhuanyeService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZhuanyeEntity zhuanye,
		HttpServletRequest request){
        EntityWrapper<ZhuanyeEntity> ew = new EntityWrapper<ZhuanyeEntity>();

		PageUtils page = zhuanyeService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhuanye), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZhuanyeEntity zhuanye, 
		HttpServletRequest request){
        EntityWrapper<ZhuanyeEntity> ew = new EntityWrapper<ZhuanyeEntity>();

		PageUtils page = zhuanyeService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhuanye), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZhuanyeEntity zhuanye){
       	EntityWrapper<ZhuanyeEntity> ew = new EntityWrapper<ZhuanyeEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zhuanye, "zhuanye")); 
        return R.ok().put("data", zhuanyeService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZhuanyeEntity zhuanye){
        EntityWrapper< ZhuanyeEntity> ew = new EntityWrapper< ZhuanyeEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zhuanye, "zhuanye")); 
		ZhuanyeView zhuanyeView =  zhuanyeService.selectView(ew);
		return R.ok("查询专业成功").put("data", zhuanyeView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZhuanyeEntity zhuanye = zhuanyeService.selectById(id);
        return R.ok().put("data", zhuanye);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZhuanyeEntity zhuanye = zhuanyeService.selectById(id);
        return R.ok().put("data", zhuanye);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZhuanyeEntity zhuanye, HttpServletRequest request){
    	zhuanye.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zhuanye);
        zhuanyeService.insert(zhuanye);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZhuanyeEntity zhuanye, HttpServletRequest request){
    	zhuanye.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zhuanye);
        zhuanyeService.insert(zhuanye);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZhuanyeEntity zhuanye, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zhuanye);
        zhuanyeService.updateById(zhuanye);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zhuanyeService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
