package com.entity.view;

import com.entity.LeixingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 类型
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-04-16 16:33:34
 */
@TableName("leixing")
public class LeixingView  extends LeixingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public LeixingView(){
	}
 
 	public LeixingView(LeixingEntity leixingEntity){
 	try {
			BeanUtils.copyProperties(this, leixingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
