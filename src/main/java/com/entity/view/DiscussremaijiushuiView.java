package com.entity.view;

import com.entity.DiscussremaijiushuiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 热卖酒水评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-04-16 16:33:34
 */
@TableName("discussremaijiushui")
public class DiscussremaijiushuiView  extends DiscussremaijiushuiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussremaijiushuiView(){
	}
 
 	public DiscussremaijiushuiView(DiscussremaijiushuiEntity discussremaijiushuiEntity){
 	try {
			BeanUtils.copyProperties(this, discussremaijiushuiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
