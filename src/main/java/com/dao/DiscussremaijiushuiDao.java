package com.dao;

import com.entity.DiscussremaijiushuiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussremaijiushuiVO;
import com.entity.view.DiscussremaijiushuiView;


/**
 * 热卖酒水评论表
 * 
 * @author 
 * @email 
 * @date 2023-04-16 16:33:34
 */
public interface DiscussremaijiushuiDao extends BaseMapper<DiscussremaijiushuiEntity> {
	
	List<DiscussremaijiushuiVO> selectListVO(@Param("ew") Wrapper<DiscussremaijiushuiEntity> wrapper);
	
	DiscussremaijiushuiVO selectVO(@Param("ew") Wrapper<DiscussremaijiushuiEntity> wrapper);
	
	List<DiscussremaijiushuiView> selectListView(@Param("ew") Wrapper<DiscussremaijiushuiEntity> wrapper);

	List<DiscussremaijiushuiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussremaijiushuiEntity> wrapper);
	
	DiscussremaijiushuiView selectView(@Param("ew") Wrapper<DiscussremaijiushuiEntity> wrapper);
	

}
