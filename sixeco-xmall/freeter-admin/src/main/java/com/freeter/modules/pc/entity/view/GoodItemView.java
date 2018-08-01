package com.freeter.modules.pc.entity.view;

import com.freeter.modules.pc.entity.GoodItemEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-07-31 14:47:21
 */
@TableName("cn_good_item")
@ApiModel(value = "GoodItem")
public class GoodItemView  extends GoodItemEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public GoodItemView(){
	}
 
 	public GoodItemView(GoodItemEntity goodItemEntity){
 	try {
			BeanUtils.copyProperties(this, goodItemEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
