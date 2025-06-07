package com.entity.view;

import com.entity.JingsaileibieEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 竞赛类别
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-05-15 14:23:37
 */
@TableName("jingsaileibie")
public class JingsaileibieView  extends JingsaileibieEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public JingsaileibieView(){
	}
 
 	public JingsaileibieView(JingsaileibieEntity jingsaileibieEntity){
 	try {
			BeanUtils.copyProperties(this, jingsaileibieEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
