package com.freeter.modules.area.entity.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
 
/**
 * 省份实体类
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-07-30 11:56:26
 */
@ApiModel(value = "ProvinceModel")
public class ProvinceModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 省份名称
	 */
	
	@ApiModelProperty(value = "") 
	private String provinceName;
		
	/**
	 * 区域名称
	 */
	
	@ApiModelProperty(value = "") 
	private String area;
		
	/**
	 * 省份编码
	 */
	
	@ApiModelProperty(value = "") 
	private Integer provinceCode;
				
	
	/**
	 * 设置：省份名称
	 */
	 
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	
	/**
	 * 获取：省份名称
	 */
	public String getProvinceName() {
		return provinceName;
	}
				
	
	/**
	 * 设置：区域名称
	 */
	 
	public void setArea(String area) {
		this.area = area;
	}
	
	/**
	 * 获取：区域名称
	 */
	public String getArea() {
		return area;
	}
				
	
	/**
	 * 设置：省份编码
	 */
	 
	public void setProvinceCode(Integer provinceCode) {
		this.provinceCode = provinceCode;
	}
	
	/**
	 * 获取：省份编码
	 */
	public Integer getProvinceCode() {
		return provinceCode;
	}
			
}
