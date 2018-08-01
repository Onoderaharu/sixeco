package com.freeter.modules.area.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableId;

/**
 * 省份实体辅助类
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-07-30 11:56:26
 */
@ApiModel(value = "ProvinceVO")
public class ProvinceVO  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	
	@ApiModelProperty(value = "") 
	private String provinceName;
		
	/**
	 * 
	 */
	
	@ApiModelProperty(value = "") 
	private String area;
		
	/**
	 * 
	 */
	
	@ApiModelProperty(value = "") 
	private Integer provinceCode;
				
	
	/**
	 * 设置：
	 */
	 
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	
	/**
	 * 获取：
	 */
	public String getProvinceName() {
		return provinceName;
	}
				
	
	/**
	 * 设置：
	 */
	 
	public void setArea(String area) {
		this.area = area;
	}
	
	/**
	 * 获取：
	 */
	public String getArea() {
		return area;
	}
				
	
	/**
	 * 设置：
	 */
	 
	public void setProvinceCode(Integer provinceCode) {
		this.provinceCode = provinceCode;
	}
	
	/**
	 * 获取：
	 */
	public Integer getProvinceCode() {
		return provinceCode;
	}
			
}
