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


import com.dao.RemaijiushuiDao;
import com.entity.RemaijiushuiEntity;
import com.service.RemaijiushuiService;
import com.entity.vo.RemaijiushuiVO;
import com.entity.view.RemaijiushuiView;

@Service("remaijiushuiService")
public class RemaijiushuiServiceImpl extends ServiceImpl<RemaijiushuiDao, RemaijiushuiEntity> implements RemaijiushuiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<RemaijiushuiEntity> page = this.selectPage(
                new Query<RemaijiushuiEntity>(params).getPage(),
                new EntityWrapper<RemaijiushuiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<RemaijiushuiEntity> wrapper) {
		  Page<RemaijiushuiView> page =new Query<RemaijiushuiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<RemaijiushuiVO> selectListVO(Wrapper<RemaijiushuiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public RemaijiushuiVO selectVO(Wrapper<RemaijiushuiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<RemaijiushuiView> selectListView(Wrapper<RemaijiushuiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public RemaijiushuiView selectView(Wrapper<RemaijiushuiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
