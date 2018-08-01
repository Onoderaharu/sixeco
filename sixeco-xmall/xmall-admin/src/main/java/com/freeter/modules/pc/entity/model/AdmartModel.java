package com.freeter.modules.pc.entity.model;

import com.freeter.modules.pc.entity.AdmartEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import java.math.BigDecimal;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 商户表
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-07-25 01:07:47
 */
@ApiModel(value = "AdmartModel")
public class AdmartModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 店铺关键字
	 */
	
	@ApiModelProperty(value = "店铺关键字") 
	private String keyword;
		
	/**
	 * 品牌log
	 */
	
	@ApiModelProperty(value = "品牌log") 
	private String log;
		
	/**
	 * 店铺名称
	 */
	
	@ApiModelProperty(value = "店铺名称") 
	private String martName;
		
	/**
	 * 是否自营 0：否 1：自营
	 */
	
	@ApiModelProperty(value = "是否自营 0：否 1：自营") 
	private Integer self;
						
	/**
	 * 用户id
	 */
	
	@ApiModelProperty(value = "用户id") 
	private Integer userId;
		
	/**
	 * 商户类型 1:个人商户 2：个体户，企业用户
	 */
	
	@ApiModelProperty(value = "商户类型 1:个人商户 2：个体户，企业用户") 
	private Integer type;
		
	/**
	 * 状态 0:审核中 1:审核通过 2:审核拒绝
	 */
	
	@ApiModelProperty(value = "状态 0:审核中 1:审核通过 2:审核拒绝") 
	private Integer status;
		
	/**
	 * 真实姓名
	 */
	
	@ApiModelProperty(value = "真实姓名") 
	private String realName;
		
	/**
	 * 身份证照片
	 */
	
	@ApiModelProperty(value = "身份证照片") 
	private String idCardImg;
		
	/**
	 * 营业执照号
	 */
	
	@ApiModelProperty(value = "营业执照号") 
	private String licenseNo;
		
	/**
	 * 营业执照图片
	 */
	
	@ApiModelProperty(value = "营业执照图片") 
	private String licenseImg;
		
	/**
	 * 联系方式
	 */
	
	@ApiModelProperty(value = "联系方式") 
	private String contact;
		
	/**
	 * 总资产
	 */
	
	@ApiModelProperty(value = "总资产") 
	private BigDecimal totalAssets;
				
	/**
	 * 省份ID
	 */
	
	@ApiModelProperty(value = "") 
	private Long provinceId;
		
	/**
	 * 城市ID
	 */
	
	@ApiModelProperty(value = "") 
	private Long cityId;
	
	/**
	 * 设置：店铺关键字
	 */
	 
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	/**
	 * 获取：店铺关键字
	 */
	public String getKeyword() {
		return keyword;
	}
				
	
	/**
	 * 设置：品牌log
	 */
	 
	public void setLog(String log) {
		this.log = log;
	}
	
	/**
	 * 获取：品牌log
	 */
	public String getLog() {
		return log;
	}
				
	
	/**
	 * 设置：店铺名称
	 */
	 
	public void setMartName(String martName) {
		this.martName = martName;
	}
	
	/**
	 * 获取：店铺名称
	 */
	public String getMartName() {
		return martName;
	}
				
	
	/**
	 * 设置：是否自营 0：否 1：自营
	 */
	 
	public void setSelf(Integer self) {
		this.self = self;
	}
	
	/**
	 * 获取：是否自营 0：否 1：自营
	 */
	public Integer getSelf() {
		return self;
	}
												
	
	/**
	 * 设置：用户id
	 */
	 
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	/**
	 * 获取：用户id
	 */
	public Integer getUserId() {
		return userId;
	}
				
	
	/**
	 * 设置：商户类型 1:个人商户 2：个体户，企业用户
	 */
	 
	public void setType(Integer type) {
		this.type = type;
	}
	
	/**
	 * 获取：商户类型 1:个人商户 2：个体户，企业用户
	 */
	public Integer getType() {
		return type;
	}
				
	
	/**
	 * 设置：状态 0:审核中 1:审核通过 2:审核拒绝
	 */
	 
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	/**
	 * 获取：状态 0:审核中 1:审核通过 2:审核拒绝
	 */
	public Integer getStatus() {
		return status;
	}
				
	
	/**
	 * 设置：真实姓名
	 */
	 
	public void setRealName(String realName) {
		this.realName = realName;
	}
	
	/**
	 * 获取：真实姓名
	 */
	public String getRealName() {
		return realName;
	}
				
	
	/**
	 * 设置：身份证照片
	 */
	 
	public void setIdCardImg(String idCardImg) {
		this.idCardImg = idCardImg;
	}
	
	/**
	 * 获取：身份证照片
	 */
	public String getIdCardImg() {
		return idCardImg;
	}
				
	
	/**
	 * 设置：营业执照号
	 */
	 
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
	
	/**
	 * 获取：营业执照号
	 */
	public String getLicenseNo() {
		return licenseNo;
	}
				
	
	/**
	 * 设置：营业执照图片
	 */
	 
	public void setLicenseImg(String licenseImg) {
		this.licenseImg = licenseImg;
	}
	
	/**
	 * 获取：营业执照图片
	 */
	public String getLicenseImg() {
		return licenseImg;
	}
				
	
	/**
	 * 设置：联系方式
	 */
	 
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	/**
	 * 获取：联系方式
	 */
	public String getContact() {
		return contact;
	}
				
	
	/**
	 * 设置：总资产
	 */
	 
	public void setTotalAssets(BigDecimal totalAssets) {
		this.totalAssets = totalAssets;
	}
	
	/**
	 * 获取：总资产
	 */
	public BigDecimal getTotalAssets() {
		return totalAssets;
	}
	
	/**
	 * 设置：省份ID
	 */
	public void setProvinceId(Long provinceId) {
		this.provinceId = provinceId;
	}
	/**
	 * 获取：省份ID
	 */
	public Long getProvinceId() {
		return provinceId;
	}
	/**
	 * 设置：城市ID
	 */
	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}
	/**
	 * 获取：城市ID
	 */
	public Long getCityId() {
		return cityId;
	}
}
