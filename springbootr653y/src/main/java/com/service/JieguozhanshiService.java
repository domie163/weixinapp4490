package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JieguozhanshiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JieguozhanshiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JieguozhanshiView;


/**
 * 结果展示
 *
 * @author 
 * @email 
 * @date 2023-05-15 14:23:37
 */
public interface JieguozhanshiService extends IService<JieguozhanshiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JieguozhanshiVO> selectListVO(Wrapper<JieguozhanshiEntity> wrapper);
   	
   	JieguozhanshiVO selectVO(@Param("ew") Wrapper<JieguozhanshiEntity> wrapper);
   	
   	List<JieguozhanshiView> selectListView(Wrapper<JieguozhanshiEntity> wrapper);
   	
   	JieguozhanshiView selectView(@Param("ew") Wrapper<JieguozhanshiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JieguozhanshiEntity> wrapper);
   	

}

