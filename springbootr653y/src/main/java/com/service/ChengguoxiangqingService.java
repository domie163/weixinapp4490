package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ChengguoxiangqingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ChengguoxiangqingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ChengguoxiangqingView;


/**
 * 成果详情
 *
 * @author 
 * @email 
 * @date 2023-05-15 14:23:37
 */
public interface ChengguoxiangqingService extends IService<ChengguoxiangqingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ChengguoxiangqingVO> selectListVO(Wrapper<ChengguoxiangqingEntity> wrapper);
   	
   	ChengguoxiangqingVO selectVO(@Param("ew") Wrapper<ChengguoxiangqingEntity> wrapper);
   	
   	List<ChengguoxiangqingView> selectListView(Wrapper<ChengguoxiangqingEntity> wrapper);
   	
   	ChengguoxiangqingView selectView(@Param("ew") Wrapper<ChengguoxiangqingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ChengguoxiangqingEntity> wrapper);
   	

}

