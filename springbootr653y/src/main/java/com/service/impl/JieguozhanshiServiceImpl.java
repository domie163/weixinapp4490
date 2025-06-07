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


import com.dao.JieguozhanshiDao;
import com.entity.JieguozhanshiEntity;
import com.service.JieguozhanshiService;
import com.entity.vo.JieguozhanshiVO;
import com.entity.view.JieguozhanshiView;

@Service("jieguozhanshiService")
public class JieguozhanshiServiceImpl extends ServiceImpl<JieguozhanshiDao, JieguozhanshiEntity> implements JieguozhanshiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JieguozhanshiEntity> page = this.selectPage(
                new Query<JieguozhanshiEntity>(params).getPage(),
                new EntityWrapper<JieguozhanshiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JieguozhanshiEntity> wrapper) {
		  Page<JieguozhanshiView> page =new Query<JieguozhanshiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<JieguozhanshiVO> selectListVO(Wrapper<JieguozhanshiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JieguozhanshiVO selectVO(Wrapper<JieguozhanshiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JieguozhanshiView> selectListView(Wrapper<JieguozhanshiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JieguozhanshiView selectView(Wrapper<JieguozhanshiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
