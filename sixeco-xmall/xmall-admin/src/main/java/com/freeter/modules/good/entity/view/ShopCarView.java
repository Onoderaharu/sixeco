package com.freeter.modules.good.entity.view;

import com.freeter.modules.good.entity.ShopCarEntity;

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
 * @date 2018-07-30 14:41:04
 */
@TableName("shop_car")
@ApiModel(value = "ShopCar")
public class ShopCarView  extends ShopCarEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ShopCarView(){
	}
 
 	public ShopCarView(ShopCarEntity shopCarEntity){
 	try {
			BeanUtils.copyProperties(this, shopCarEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
