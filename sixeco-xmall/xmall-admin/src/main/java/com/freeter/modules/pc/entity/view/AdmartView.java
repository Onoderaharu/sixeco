package com.freeter.modules.pc.entity.view;

import com.freeter.modules.pc.entity.AdmartEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 商户表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author SIXECO
 * @email yqq@sixeco.com
 * @date 2018-07-25 01:07:47
 */
@TableName("cn_admart")
@ApiModel(value = "Admart")
public class AdmartView  extends AdmartEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public AdmartView(){
	}
 
 	public AdmartView(AdmartEntity admartEntity){
 	try {
			BeanUtils.copyProperties(this, admartEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
