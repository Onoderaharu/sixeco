package com.freeter.modules.pc.entity.model;

import com.freeter.modules.pc.entity.ReceiverEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-08-01 09:37:48
 */
@ApiModel(value = "ReceiverModel")
public class ReceiverModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 
	 */
	
	@ApiModelProperty(value = "") 
	private Long userId;
		
	/**
	 * 省
	 */
	
	@ApiModelProperty(value = "省") 
	private String province;
		
	/**
	 * 市
	 */
	
	@ApiModelProperty(value = "市") 
	private String city;
		
	/**
	 * 收货地址
	 */
	
	@ApiModelProperty(value = "收货地址") 
	private String receiverAddress;
		
	/**
	 * 收货人
	 */
	
	@ApiModelProperty(value = "收货人") 
	private String receiverName;
		
	/**
	 * 收货人手机号
	 */
	
	@ApiModelProperty(value = "收货人手机号") 
	private String receiverPhone;
		
	/**
	 * 订单
	 */
	
	@ApiModelProperty(value = "订单") 
	private Integer ordersId;
				
	/**
	 * 
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	@ApiModelProperty(value = "") 
	private Date lastModifyTime;
		
	/**
	 * 是否默认 0 :默认  1: 非默认
	 */
	
	@ApiModelProperty(value = "是否默认 0 :默认  1: 非默认") 
	private String isDefault;
		
	/**
	 * 
	 */
	
	@ApiModelProperty(value = "") 
	private String lastModifyBy;
		
	/**
	 * 省id
	 */
	
	@ApiModelProperty(value = "省id") 
	private Integer provinceId;
		
	/**
	 * 城市id
	 */
	
	@ApiModelProperty(value = "城市id") 
	private Integer cityId;
				
	
	/**
	 * 设置：
	 */
	 
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	/**
	 * 获取：
	 */
	public Long getUserId() {
		return userId;
	}
				
	
	/**
	 * 设置：省
	 */
	 
	public void setProvince(String province) {
		this.province = province;
	}
	
	/**
	 * 获取：省
	 */
	public String getProvince() {
		return province;
	}
				
	
	/**
	 * 设置：市
	 */
	 
	public void setCity(String city) {
		this.city = city;
	}
	
	/**
	 * 获取：市
	 */
	public String getCity() {
		return city;
	}
				
	
	/**
	 * 设置：收货地址
	 */
	 
	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}
	
	/**
	 * 获取：收货地址
	 */
	public String getReceiverAddress() {
		return receiverAddress;
	}
				
	
	/**
	 * 设置：收货人
	 */
	 
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	
	/**
	 * 获取：收货人
	 */
	public String getReceiverName() {
		return receiverName;
	}
				
	
	/**
	 * 设置：收货人手机号
	 */
	 
	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}
	
	/**
	 * 获取：收货人手机号
	 */
	public String getReceiverPhone() {
		return receiverPhone;
	}
				
	
	/**
	 * 设置：订单
	 */
	 
	public void setOrdersId(Integer ordersId) {
		this.ordersId = ordersId;
	}
	
	/**
	 * 获取：订单
	 */
	public Integer getOrdersId() {
		return ordersId;
	}
								
	
	/**
	 * 设置：
	 */
	 
	public void setLastModifyTime(Date lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}
	
	/**
	 * 获取：
	 */
	public Date getLastModifyTime() {
		return lastModifyTime;
	}
				
	
	/**
	 * 设置：是否默认 0 :默认  1: 非默认
	 */
	 
	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}
	
	/**
	 * 获取：是否默认 0 :默认  1: 非默认
	 */
	public String getIsDefault() {
		return isDefault;
	}
				
	
	/**
	 * 设置：
	 */
	 
	public void setLastModifyBy(String lastModifyBy) {
		this.lastModifyBy = lastModifyBy;
	}
	
	/**
	 * 获取：
	 */
	public String getLastModifyBy() {
		return lastModifyBy;
	}
				
	
	/**
	 * 设置：省id
	 */
	 
	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}
	
	/**
	 * 获取：省id
	 */
	public Integer getProvinceId() {
		return provinceId;
	}
				
	
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
			
}
