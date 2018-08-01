package com.freeter.modules.area.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import java.lang.reflect.InvocationTargetException;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import org.apache.commons.beanutils.BeanUtils;

/**
 * 省份表
 * 数据库通用操作实体类（普通增删改查）
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-07-30 11:56:26
 */
@TableName("province")
@ApiModel(value = "Province")
public class ProvinceEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ProvinceEntity() {
		
	}
	
	public ProvinceEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 省份id
	 */
	
	@TableId 					
	@ApiModelProperty(value = "",hidden = true)
	private Integer provinceId;
	
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
	 * 区域编码
	 */
						
	@ApiModelProperty(value = "")
	private Integer provinceCode;
	
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
	 * 设置：区域编码
	 */
	public void setProvinceCode(Integer provinceCode) {
		this.provinceCode = provinceCode;
	}
	/**
	 * 获取：区域编码
	 */
	public Integer getProvinceCode() {
		return provinceCode;
	}
}
