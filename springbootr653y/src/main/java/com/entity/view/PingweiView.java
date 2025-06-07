package com.entity.view;

import com.entity.PingweiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 评委
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-05-15 14:23:36
 */
@TableName("pingwei")
public class PingweiView  extends PingweiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public PingweiView(){
	}
 
 	public PingweiView(PingweiEntity pingweiEntity){
 	try {
			BeanUtils.copyProperties(this, pingweiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
