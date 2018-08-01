package com.freeter.modules.area.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableId;
 
/**
 *  城市表
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-07-30 11:56:26
 */
@ApiModel(value = "CityVO")
public class CityVO  implements Serializable {
	private static final long serialVersionUID = 1L;
	

	/**
	 * 城市id
	 */
	
	@TableId 					
	@ApiModelProperty(value = "城市id",hidden = true)
	private Integer cityId;
	 			
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

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
			
}
