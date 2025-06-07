package com.dao;

import com.entity.JieguozhanshiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JieguozhanshiVO;
import com.entity.view.JieguozhanshiView;


/**
 * 结果展示
 * 
 * @author 
 * @email 
 * @date 2023-05-15 14:23:37
 */
public interface JieguozhanshiDao extends BaseMapper<JieguozhanshiEntity> {
	
	List<JieguozhanshiVO> selectListVO(@Param("ew") Wrapper<JieguozhanshiEntity> wrapper);
	
	JieguozhanshiVO selectVO(@Param("ew") Wrapper<JieguozhanshiEntity> wrapper);
	
	List<JieguozhanshiView> selectListView(@Param("ew") Wrapper<JieguozhanshiEntity> wrapper);

	List<JieguozhanshiView> selectListView(Pagination page,@Param("ew") Wrapper<JieguozhanshiEntity> wrapper);
	
	JieguozhanshiView selectView(@Param("ew") Wrapper<JieguozhanshiEntity> wrapper);
	

}
