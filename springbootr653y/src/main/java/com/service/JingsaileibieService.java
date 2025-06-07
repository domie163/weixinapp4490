package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JingsaileibieEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JingsaileibieVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JingsaileibieView;


/**
 * 竞赛类别
 *
 * @author 
 * @email 
 * @date 2023-05-15 14:23:37
 */
public interface JingsaileibieService extends IService<JingsaileibieEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JingsaileibieVO> selectListVO(Wrapper<JingsaileibieEntity> wrapper);
   	
   	JingsaileibieVO selectVO(@Param("ew") Wrapper<JingsaileibieEntity> wrapper);
   	
   	List<JingsaileibieView> selectListView(Wrapper<JingsaileibieEntity> wrapper);
   	
   	JingsaileibieView selectView(@Param("ew") Wrapper<JingsaileibieEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JingsaileibieEntity> wrapper);
   	

}

