package com.freeter.modules.good.entity.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotations.TableName;
import com.freeter.modules.good.entity.GoodImageEntity;

import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 商品图片表
 * 
 * @author SIXECO
 * @email yqq@sixeco.com
 * @date 2018-05-24 11:54:40
 */
@TableName("cn_good_image")
@ApiModel(value = "GoodImage")
public class GoodImageView  extends GoodImageEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public GoodImageView(){
	}
 
 	public GoodImageView(GoodImageEntity goodImageEntity){
 	try {
			BeanUtils.copyProperties(this, goodImageEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
