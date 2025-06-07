package com.entity.vo;

import com.entity.JieguozhanshiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 结果展示
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2023-05-15 14:23:37
 */
public class JieguozhanshiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
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
	 * 竞赛分数
	 */
	
	private Float jingsaifenshu;
		
	/**
	 * 评分备注
	 */
	
	private String pingfenbeizhu;
		
	/**
	 * 评分时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date pingfenshijian;
		
	/**
	 * 负责人账号
	 */
	
	private String fuzerenzhanghao;
		
	/**
	 * 负责人姓名
	 */
	
	private String fuzerenxingming;
		
	/**
	 * 学生学号
	 */
	
	private String xueshengxuehao;
		
	/**
	 * 学生姓名
	 */
	
	private String xueshengxingming;
		
	/**
	 * 专业
	 */
	
	private String zhuanye;
		
	/**
	 * 班级
	 */
	
	private String banji;
		
	/**
	 * 手机
	 */
	
	private String shouji;
		
	/**
	 * 评委账号
	 */
	
	private String pingweizhanghao;
		
	/**
	 * 评委姓名
	 */
	
	private String pingweixingming;
				
	
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
	 * 设置：竞赛分数
	 */
	 
	public void setJingsaifenshu(Float jingsaifenshu) {
		this.jingsaifenshu = jingsaifenshu;
	}
	
	/**
	 * 获取：竞赛分数
	 */
	public Float getJingsaifenshu() {
		return jingsaifenshu;
	}
				
	
	/**
	 * 设置：评分备注
	 */
	 
	public void setPingfenbeizhu(String pingfenbeizhu) {
		this.pingfenbeizhu = pingfenbeizhu;
	}
	
	/**
	 * 获取：评分备注
	 */
	public String getPingfenbeizhu() {
		return pingfenbeizhu;
	}
				
	
	/**
	 * 设置：评分时间
	 */
	 
	public void setPingfenshijian(Date pingfenshijian) {
		this.pingfenshijian = pingfenshijian;
	}
	
	/**
	 * 获取：评分时间
	 */
	public Date getPingfenshijian() {
		return pingfenshijian;
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
				
	
	/**
	 * 设置：学生学号
	 */
	 
	public void setXueshengxuehao(String xueshengxuehao) {
		this.xueshengxuehao = xueshengxuehao;
	}
	
	/**
	 * 获取：学生学号
	 */
	public String getXueshengxuehao() {
		return xueshengxuehao;
	}
				
	
	/**
	 * 设置：学生姓名
	 */
	 
	public void setXueshengxingming(String xueshengxingming) {
		this.xueshengxingming = xueshengxingming;
	}
	
	/**
	 * 获取：学生姓名
	 */
	public String getXueshengxingming() {
		return xueshengxingming;
	}
				
	
	/**
	 * 设置：专业
	 */
	 
	public void setZhuanye(String zhuanye) {
		this.zhuanye = zhuanye;
	}
	
	/**
	 * 获取：专业
	 */
	public String getZhuanye() {
		return zhuanye;
	}
				
	
	/**
	 * 设置：班级
	 */
	 
	public void setBanji(String banji) {
		this.banji = banji;
	}
	
	/**
	 * 获取：班级
	 */
	public String getBanji() {
		return banji;
	}
				
	
	/**
	 * 设置：手机
	 */
	 
	public void setShouji(String shouji) {
		this.shouji = shouji;
	}
	
	/**
	 * 获取：手机
	 */
	public String getShouji() {
		return shouji;
	}
				
	
	/**
	 * 设置：评委账号
	 */
	 
	public void setPingweizhanghao(String pingweizhanghao) {
		this.pingweizhanghao = pingweizhanghao;
	}
	
	/**
	 * 获取：评委账号
	 */
	public String getPingweizhanghao() {
		return pingweizhanghao;
	}
				
	
	/**
	 * 设置：评委姓名
	 */
	 
	public void setPingweixingming(String pingweixingming) {
		this.pingweixingming = pingweixingming;
	}
	
	/**
	 * 获取：评委姓名
	 */
	public String getPingweixingming() {
		return pingweixingming;
	}
			
}
