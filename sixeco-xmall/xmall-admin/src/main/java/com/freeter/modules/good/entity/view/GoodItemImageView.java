package com.freeter.modules.good.entity.view;

import com.freeter.modules.good.entity.GoodItemImageEntity;
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
 * @date 2018-07-31 15:38:04
 */
@TableName("cn_good_item_image")
@ApiModel(value = "GoodItemImage")
public class GoodItemImageView extends GoodItemImageEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public GoodItemImageView(){
	}
 
 	public GoodItemImageView(GoodItemImageEntity goodItemImageEntity){
 	try {
			BeanUtils.copyProperties(this, goodItemImageEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
