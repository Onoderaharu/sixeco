package com.freeter.modules.area.entity.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;


/**
 * 城市表
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author jiangqianshu
 * @email 2635045337@qq.com
 * @date 2018-07-30 11:56:26
 */
@ApiModel(value = "CityModel")
public class CityModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 省份id
	 */
	
	@ApiModelProperty(value = "") 
	private Integer provinceId;
		
	/**
	 * 城市名称
	 */
	
	@ApiModelProperty(value = "") 
	private String cityName;
		
	/**
	 * 邮政编码
	 */
	
	@ApiModelProperty(value = "") 
	private String zipCode;
				
	
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
