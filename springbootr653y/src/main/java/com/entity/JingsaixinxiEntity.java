package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 竞赛信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-05-15 14:23:37
 */
@TableName("jingsaixinxi")
public class JingsaixinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public JingsaixinxiEntity() {
		
	}
	
	public JingsaixinxiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 竞赛编号
	 */
					
	private String jingsaibianhao;
	
	/**
	 * 竞赛名称
	 */
					
	private String jingsaimingcheng;
	
	/**
	 * 竞赛类别
	 */
					
	private String jingsaileibie;
	
	/**
	 * 图片
	 */
					
	private String tupian;
	
	/**
	 * 报名开始时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date baomingkaishishijian;
	
	/**
	 * 报名截止时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date baomingjiezhishijian;
	
	/**
	 * 报名条件
	 */
					
	private String baomingtiaojian;
	
	/**
	 * 发布时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date fabushijian;
	
	/**
	 * 负责人账号
	 */
					
	private String fuzerenzhanghao;
	
	/**
	 * 负责人姓名
	 */
					
	private String fuzerenxingming;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：竞赛编号
	 */
	public void setJingsaibianhao(String jingsaibianhao) {
		this.jingsaibianhao = jingsaibianhao;
	}
	/**
	 * 获取：竞赛编号
	 */
	public String getJingsaibianhao() {
		return jingsaibianhao;
	}
	/**
	 * 设置：竞赛名称
	 */
	public void setJingsaimingcheng(String jingsaimingcheng) {
		this.jingsaimingcheng = jingsaimingcheng;
	}
	/**
	 * 获取：竞赛名称
	 */
	public String getJingsaimingcheng() {
		return jingsaimingcheng;
	}
	/**
	 * 设置：竞赛类别
	 */
	public void setJingsaileibie(String jingsaileibie) {
		this.jingsaileibie = jingsaileibie;
	}
	/**
	 * 获取：竞赛类别
	 */
	public String getJingsaileibie() {
		return jingsaileibie;
	}
	/**
	 * 设置：图片
	 */
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}
	/**
	 * 设置：报名开始时间
	 */
	public void setBaomingkaishishijian(Date baomingkaishishijian) {
		this.baomingkaishishijian = baomingkaishishijian;
	}
	/**
	 * 获取：报名开始时间
	 */
	public Date getBaomingkaishishijian() {
		return baomingkaishishijian;
	}
	/**
	 * 设置：报名截止时间
	 */
	public void setBaomingjiezhishijian(Date baomingjiezhishijian) {
		this.baomingjiezhishijian = baomingjiezhishijian;
	}
	/**
	 * 获取：报名截止时间
	 */
	public Date getBaomingjiezhishijian() {
		return baomingjiezhishijian;
	}
	/**
	 * 设置：报名条件
	 */
	public void setBaomingtiaojian(String baomingtiaojian) {
		this.baomingtiaojian = baomingtiaojian;
	}
	/**
	 * 获取：报名条件
	 */
	public String getBaomingtiaojian() {
		return baomingtiaojian;
	}
	/**
	 * 设置：发布时间
	 */
	public void setFabushijian(Date fabushijian) {
		this.fabushijian = fabushijian;
	}
	/**
	 * 获取：发布时间
	 */
	public Date getFabushijian() {
		return fabushijian;
	}
	/**
	 * 设置：负责人账号
	 */
	public void setFuzerenzhanghao(String fuzerenzhanghao) {
		this.fuzerenzhanghao = fuzerenzhanghao;
	}
	/**
	 * 获取：负责人账号
	 */
	public String getFuzerenzhanghao() {
		return fuzerenzhanghao;
	}
	/**
	 * 设置：负责人姓名
	 */
	public void setFuzerenxingming(String fuzerenxingming) {
		this.fuzerenxingming = fuzerenxingming;
	}
	/**
	 * 获取：负责人姓名
	 */
	public String getFuzerenxingming() {
		return fuzerenxingming;
	}

}
