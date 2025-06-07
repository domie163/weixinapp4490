package com.entity.view;

import com.entity.ChengguoxiangqingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 成果详情
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-05-15 14:23:37
 */
@TableName("chengguoxiangqing")
public class ChengguoxiangqingView  extends ChengguoxiangqingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ChengguoxiangqingView(){
	}
 
 	public ChengguoxiangqingView(ChengguoxiangqingEntity chengguoxiangqingEntity){
 	try {
			BeanUtils.copyProperties(this, chengguoxiangqingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
