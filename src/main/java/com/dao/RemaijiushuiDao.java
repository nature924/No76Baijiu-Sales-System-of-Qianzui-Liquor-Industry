package com.dao;

import com.entity.RemaijiushuiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.RemaijiushuiVO;
import com.entity.view.RemaijiushuiView;


/**
 * 热卖酒水
 * 
 * @author 
 * @email 
 * @date 2023-04-16 16:33:34
 */
public interface RemaijiushuiDao extends BaseMapper<RemaijiushuiEntity> {
	
	List<RemaijiushuiVO> selectListVO(@Param("ew") Wrapper<RemaijiushuiEntity> wrapper);
	
	RemaijiushuiVO selectVO(@Param("ew") Wrapper<RemaijiushuiEntity> wrapper);
	
	List<RemaijiushuiView> selectListView(@Param("ew") Wrapper<RemaijiushuiEntity> wrapper);

	List<RemaijiushuiView> selectListView(Pagination page,@Param("ew") Wrapper<RemaijiushuiEntity> wrapper);
	
	RemaijiushuiView selectView(@Param("ew") Wrapper<RemaijiushuiEntity> wrapper);
	

}
