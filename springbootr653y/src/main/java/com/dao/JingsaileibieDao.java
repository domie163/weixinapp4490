package com.dao;

import com.entity.JingsaileibieEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JingsaileibieVO;
import com.entity.view.JingsaileibieView;


/**
 * 竞赛类别
 * 
 * @author 
 * @email 
 * @date 2023-05-15 14:23:37
 */
public interface JingsaileibieDao extends BaseMapper<JingsaileibieEntity> {
	
	List<JingsaileibieVO> selectListVO(@Param("ew") Wrapper<JingsaileibieEntity> wrapper);
	
	JingsaileibieVO selectVO(@Param("ew") Wrapper<JingsaileibieEntity> wrapper);
	
	List<JingsaileibieView> selectListView(@Param("ew") Wrapper<JingsaileibieEntity> wrapper);

	List<JingsaileibieView> selectListView(Pagination page,@Param("ew") Wrapper<JingsaileibieEntity> wrapper);
	
	JingsaileibieView selectView(@Param("ew") Wrapper<JingsaileibieEntity> wrapper);
	

}
