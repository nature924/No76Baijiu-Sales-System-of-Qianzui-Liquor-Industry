package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussremaijiushuiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussremaijiushuiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussremaijiushuiView;


/**
 * 热卖酒水评论表
 *
 * @author 
 * @email 
 * @date 2023-04-16 16:33:34
 */
public interface DiscussremaijiushuiService extends IService<DiscussremaijiushuiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussremaijiushuiVO> selectListVO(Wrapper<DiscussremaijiushuiEntity> wrapper);
   	
   	DiscussremaijiushuiVO selectVO(@Param("ew") Wrapper<DiscussremaijiushuiEntity> wrapper);
   	
   	List<DiscussremaijiushuiView> selectListView(Wrapper<DiscussremaijiushuiEntity> wrapper);
   	
   	DiscussremaijiushuiView selectView(@Param("ew") Wrapper<DiscussremaijiushuiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussremaijiushuiEntity> wrapper);
   	

}

