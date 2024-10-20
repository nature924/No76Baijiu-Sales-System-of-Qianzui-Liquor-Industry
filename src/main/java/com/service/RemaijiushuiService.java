package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.RemaijiushuiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.RemaijiushuiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.RemaijiushuiView;


/**
 * 热卖酒水
 *
 * @author 
 * @email 
 * @date 2023-04-16 16:33:34
 */
public interface RemaijiushuiService extends IService<RemaijiushuiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<RemaijiushuiVO> selectListVO(Wrapper<RemaijiushuiEntity> wrapper);
   	
   	RemaijiushuiVO selectVO(@Param("ew") Wrapper<RemaijiushuiEntity> wrapper);
   	
   	List<RemaijiushuiView> selectListView(Wrapper<RemaijiushuiEntity> wrapper);
   	
   	RemaijiushuiView selectView(@Param("ew") Wrapper<RemaijiushuiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<RemaijiushuiEntity> wrapper);
   	

}

