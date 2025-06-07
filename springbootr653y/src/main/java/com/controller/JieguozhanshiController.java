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

import com.entity.JieguozhanshiEntity;
import com.entity.view.JieguozhanshiView;

import com.service.JieguozhanshiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 结果展示
 * 后端接口
 * @author 
 * @email 
 * @date 2023-05-15 14:23:37
 */
@RestController
@RequestMapping("/jieguozhanshi")
public class JieguozhanshiController {
    @Autowired
    private JieguozhanshiService jieguozhanshiService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JieguozhanshiEntity jieguozhanshi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("fuzeren")) {
			jieguozhanshi.setFuzerenzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("xuesheng")) {
			jieguozhanshi.setXueshengxuehao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("pingwei")) {
			jieguozhanshi.setPingweizhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<JieguozhanshiEntity> ew = new EntityWrapper<JieguozhanshiEntity>();

		PageUtils page = jieguozhanshiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jieguozhanshi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JieguozhanshiEntity jieguozhanshi, 
		HttpServletRequest request){
        EntityWrapper<JieguozhanshiEntity> ew = new EntityWrapper<JieguozhanshiEntity>();

		PageUtils page = jieguozhanshiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jieguozhanshi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JieguozhanshiEntity jieguozhanshi){
       	EntityWrapper<JieguozhanshiEntity> ew = new EntityWrapper<JieguozhanshiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jieguozhanshi, "jieguozhanshi")); 
        return R.ok().put("data", jieguozhanshiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JieguozhanshiEntity jieguozhanshi){
        EntityWrapper< JieguozhanshiEntity> ew = new EntityWrapper< JieguozhanshiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jieguozhanshi, "jieguozhanshi")); 
		JieguozhanshiView jieguozhanshiView =  jieguozhanshiService.selectView(ew);
		return R.ok("查询结果展示成功").put("data", jieguozhanshiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JieguozhanshiEntity jieguozhanshi = jieguozhanshiService.selectById(id);
        return R.ok().put("data", jieguozhanshi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JieguozhanshiEntity jieguozhanshi = jieguozhanshiService.selectById(id);
        return R.ok().put("data", jieguozhanshi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JieguozhanshiEntity jieguozhanshi, HttpServletRequest request){
    	jieguozhanshi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jieguozhanshi);
        jieguozhanshiService.insert(jieguozhanshi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JieguozhanshiEntity jieguozhanshi, HttpServletRequest request){
    	jieguozhanshi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jieguozhanshi);
        jieguozhanshiService.insert(jieguozhanshi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JieguozhanshiEntity jieguozhanshi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jieguozhanshi);
        jieguozhanshiService.updateById(jieguozhanshi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jieguozhanshiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
