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


import com.dao.DiscussremaijiushuiDao;
import com.entity.DiscussremaijiushuiEntity;
import com.service.DiscussremaijiushuiService;
import com.entity.vo.DiscussremaijiushuiVO;
import com.entity.view.DiscussremaijiushuiView;

@Service("discussremaijiushuiService")
public class DiscussremaijiushuiServiceImpl extends ServiceImpl<DiscussremaijiushuiDao, DiscussremaijiushuiEntity> implements DiscussremaijiushuiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussremaijiushuiEntity> page = this.selectPage(
                new Query<DiscussremaijiushuiEntity>(params).getPage(),
                new EntityWrapper<DiscussremaijiushuiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussremaijiushuiEntity> wrapper) {
		  Page<DiscussremaijiushuiView> page =new Query<DiscussremaijiushuiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussremaijiushuiVO> selectListVO(Wrapper<DiscussremaijiushuiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussremaijiushuiVO selectVO(Wrapper<DiscussremaijiushuiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussremaijiushuiView> selectListView(Wrapper<DiscussremaijiushuiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussremaijiushuiView selectView(Wrapper<DiscussremaijiushuiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
