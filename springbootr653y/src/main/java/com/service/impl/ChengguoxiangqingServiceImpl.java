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


import com.dao.ChengguoxiangqingDao;
import com.entity.ChengguoxiangqingEntity;
import com.service.ChengguoxiangqingService;
import com.entity.vo.ChengguoxiangqingVO;
import com.entity.view.ChengguoxiangqingView;

@Service("chengguoxiangqingService")
public class ChengguoxiangqingServiceImpl extends ServiceImpl<ChengguoxiangqingDao, ChengguoxiangqingEntity> implements ChengguoxiangqingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ChengguoxiangqingEntity> page = this.selectPage(
                new Query<ChengguoxiangqingEntity>(params).getPage(),
                new EntityWrapper<ChengguoxiangqingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ChengguoxiangqingEntity> wrapper) {
		  Page<ChengguoxiangqingView> page =new Query<ChengguoxiangqingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ChengguoxiangqingVO> selectListVO(Wrapper<ChengguoxiangqingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ChengguoxiangqingVO selectVO(Wrapper<ChengguoxiangqingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ChengguoxiangqingView> selectListView(Wrapper<ChengguoxiangqingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ChengguoxiangqingView selectView(Wrapper<ChengguoxiangqingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
