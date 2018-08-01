package com.freeter.modules.pc.entity.view;

import com.freeter.modules.pc.entity.CategoryEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 分类表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-07-28 16:51:05
 */
@TableName("cn_category")
@ApiModel(value = "Category")
public class CategoryView  extends CategoryEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public CategoryView(){
	}
 
 	public CategoryView(CategoryEntity categoryEntity){
 	try {
			BeanUtils.copyProperties(this, categoryEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
