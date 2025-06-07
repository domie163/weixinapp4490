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

import com.entity.YoukeEntity;
import com.entity.view.YoukeView;

import com.service.YoukeService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 游客
 * 后端接口
 * @author 
 * @email 
 * @date 2023-05-15 14:23:36
 */
@RestController
@RequestMapping("/youke")
public class YoukeController {
    @Autowired
    private YoukeService youkeService;


    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		YoukeEntity u = youkeService.selectOne(new EntityWrapper<YoukeEntity>().eq("youkezhanghao", username));
		if(u==null || !u.getMima().equals(password)) {
			return R.error("账号或密码不正确");
		}
		
		String token = tokenService.generateToken(u.getId(), username,"youke",  "游客" );
		return R.ok().put("token", token);
	}

	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody YoukeEntity youke){
    	//ValidatorUtils.validateEntity(youke);
    	YoukeEntity u = youkeService.selectOne(new EntityWrapper<YoukeEntity>().eq("youkezhanghao", youke.getYoukezhanghao()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		youke.setId(uId);
        youkeService.insert(youke);
        return R.ok();
    }

	
	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        YoukeEntity u = youkeService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	YoukeEntity u = youkeService.selectOne(new EntityWrapper<YoukeEntity>().eq("youkezhanghao", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        u.setMima("123456");
        youkeService.updateById(u);
        return R.ok("密码已重置为：123456");
    }


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YoukeEntity youke,
		HttpServletRequest request){
        EntityWrapper<YoukeEntity> ew = new EntityWrapper<YoukeEntity>();

		PageUtils page = youkeService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, youke), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YoukeEntity youke, 
		HttpServletRequest request){
        EntityWrapper<YoukeEntity> ew = new EntityWrapper<YoukeEntity>();

		PageUtils page = youkeService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, youke), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YoukeEntity youke){
       	EntityWrapper<YoukeEntity> ew = new EntityWrapper<YoukeEntity>();
      	ew.allEq(MPUtil.allEQMapPre( youke, "youke")); 
        return R.ok().put("data", youkeService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YoukeEntity youke){
        EntityWrapper< YoukeEntity> ew = new EntityWrapper< YoukeEntity>();
 		ew.allEq(MPUtil.allEQMapPre( youke, "youke")); 
		YoukeView youkeView =  youkeService.selectView(ew);
		return R.ok("查询游客成功").put("data", youkeView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YoukeEntity youke = youkeService.selectById(id);
        return R.ok().put("data", youke);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YoukeEntity youke = youkeService.selectById(id);
        return R.ok().put("data", youke);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YoukeEntity youke, HttpServletRequest request){
    	youke.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(youke);
    	YoukeEntity u = youkeService.selectOne(new EntityWrapper<YoukeEntity>().eq("youkezhanghao", youke.getYoukezhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		youke.setId(new Date().getTime());
        youkeService.insert(youke);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YoukeEntity youke, HttpServletRequest request){
    	youke.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(youke);
    	YoukeEntity u = youkeService.selectOne(new EntityWrapper<YoukeEntity>().eq("youkezhanghao", youke.getYoukezhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		youke.setId(new Date().getTime());
        youkeService.insert(youke);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YoukeEntity youke, HttpServletRequest request){
        //ValidatorUtils.validateEntity(youke);
        youkeService.updateById(youke);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        youkeService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
