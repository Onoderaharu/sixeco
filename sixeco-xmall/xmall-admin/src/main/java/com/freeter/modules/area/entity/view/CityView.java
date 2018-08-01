package com.freeter.modules.area.entity.view;

import com.freeter.modules.area.entity.CityEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 城市表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-07-30 11:56:26
 */
@TableName("city")
@ApiModel(value = "City")
public class CityView  extends CityEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public CityView(){
	}
 
 	public CityView(CityEntity cityEntity){
 	try {
			BeanUtils.copyProperties(this, cityEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
