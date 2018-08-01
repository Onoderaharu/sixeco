package com.freeter.modules.area.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotNull;
import java.lang.reflect.InvocationTargetException;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import org.apache.commons.beanutils.BeanUtils;

/**
 * 城市表
 * 数据库通用操作实体类（普通增删改查）
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-07-30 11:56:26
 */
@TableName("city")
@ApiModel(value = "City")
public class CityEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public CityEntity() {
		
	}
	
	public CityEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 城市id
	 */
	
	@TableId 					
	@ApiModelProperty(value = "城市id",hidden = true)
	private Integer cityId;
	
	/**
	 * 省份id
	 */
			
	@NotNull (message = "不能为空") 				
	@ApiModelProperty(value = "省份id")
	private Integer provinceId;
	
	/**
	 * 城市名称
	 */
						
	@ApiModelProperty(value = "城市名称")
	private String cityName;
	
	/**
	 * 邮政编码
	 */
						
	@ApiModelProperty(value = "邮政编码")
	private String zipCode;
	
	/**
	 * 设置：城市id
	 */
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	/**
	 * 获取：城市id
	 */
	public Integer getCityId() {
		return cityId;
	}
	/**
	 * 设置：省份id
	 */
	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}
	/**
	 * 获取：省份id
	 */
	public Integer getProvinceId() {
		return provinceId;
	}
	/**
	 * 设置：城市名称
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	/**
	 * 获取：城市名称
	 */
	public String getCityName() {
		return cityName;
	}
	/**
	 * 设置：邮政编码
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	/**
	 * 获取：邮政编码
	 */
	public String getZipCode() {
		return zipCode;
	}
}
