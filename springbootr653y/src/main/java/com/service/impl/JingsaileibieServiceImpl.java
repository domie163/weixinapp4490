package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.JingsaileibieDao;
import com.entity.JingsaileibieEntity;
import com.service.JingsaileibieService;
import com.entity.vo.JingsaileibieVO;
import com.entity.view.JingsaileibieView;

@Service("jingsaileibieService")
public class JingsaileibieServiceImpl extends ServiceImpl<JingsaileibieDao, JingsaileibieEntity> implements JingsaileibieService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JingsaileibieEntity> page = this.selectPage(
                new Query<JingsaileibieEntity>(params).getPage(),
                new EntityWrapper<JingsaileibieEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JingsaileibieEntity> wrapper) {
		  Page<JingsaileibieView> page =new Query<JingsaileibieView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<JingsaileibieVO> selectListVO(Wrapper<JingsaileibieEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JingsaileibieVO selectVO(Wrapper<JingsaileibieEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JingsaileibieView> selectListView(Wrapper<JingsaileibieEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JingsaileibieView selectView(Wrapper<JingsaileibieEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
