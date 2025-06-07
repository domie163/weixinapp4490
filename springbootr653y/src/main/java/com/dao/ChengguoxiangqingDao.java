package com.dao;

import com.entity.ChengguoxiangqingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ChengguoxiangqingVO;
import com.entity.view.ChengguoxiangqingView;


/**
 * 成果详情
 * 
 * @author 
 * @email 
 * @date 2023-05-15 14:23:37
 */
public interface ChengguoxiangqingDao extends BaseMapper<ChengguoxiangqingEntity> {
	
	List<ChengguoxiangqingVO> selectListVO(@Param("ew") Wrapper<ChengguoxiangqingEntity> wrapper);
	
	ChengguoxiangqingVO selectVO(@Param("ew") Wrapper<ChengguoxiangqingEntity> wrapper);
	
	List<ChengguoxiangqingView> selectListView(@Param("ew") Wrapper<ChengguoxiangqingEntity> wrapper);

	List<ChengguoxiangqingView> selectListView(Pagination page,@Param("ew") Wrapper<ChengguoxiangqingEntity> wrapper);
	
	ChengguoxiangqingView selectView(@Param("ew") Wrapper<ChengguoxiangqingEntity> wrapper);
	

}
