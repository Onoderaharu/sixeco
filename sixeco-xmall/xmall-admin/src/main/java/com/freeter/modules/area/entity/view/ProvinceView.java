package com.freeter.modules.area.entity.view;

import com.freeter.modules.area.entity.ProvinceEntity;
import io.swagger.annotations.ApiModel;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
 

/**
 * 省份类
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-07-30 11:56:26
 */
@TableName("province")
@ApiModel(value = "Province")
public class ProvinceView  extends ProvinceEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ProvinceView(){
	}
 
 	public ProvinceView(ProvinceEntity provinceEntity){
 	try {
			BeanUtils.copyProperties(this, provinceEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
