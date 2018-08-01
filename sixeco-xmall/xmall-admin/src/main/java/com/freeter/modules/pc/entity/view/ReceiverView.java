package com.freeter.modules.pc.entity.view;

import com.freeter.modules.pc.entity.ReceiverEntity;

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
 * @date 2018-08-01 09:37:48
 */
@TableName("receiver")
@ApiModel(value = "Receiver")
public class ReceiverView  extends ReceiverEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ReceiverView(){
	}
 
 	public ReceiverView(ReceiverEntity receiverEntity){
 	try {
			BeanUtils.copyProperties(this, receiverEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
