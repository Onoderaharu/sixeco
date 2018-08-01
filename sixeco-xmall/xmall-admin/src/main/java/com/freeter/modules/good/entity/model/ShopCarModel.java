package com.freeter.modules.good.entity.model;

import com.freeter.modules.good.entity.ShopCarEntity;

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
 * @date 2018-07-30 14:41:04
 */
@ApiModel(value = "ShopCarModel")
public class ShopCarModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 产品ID
	 */
	
	@ApiModelProperty(value = "产品ID") 
	private Integer productId;
		
	/**
	 * 产品分类
	 */
	
	@ApiModelProperty(value = "产品分类") 
	private Integer productType;
		
	/**
	 * 用户ID
	 */
	
	@ApiModelProperty(value = "用户ID") 
	private Integer userId;
		
	/**
	 * 是否删除
	 */
	
	@ApiModelProperty(value = "是否删除") 
	private Integer isDelete;
			
	/**
	 * 数量
	 */
	
	@ApiModelProperty(value = "数量") 
	private Integer quantity;
		
	/**
	 * 备注
	 */
	
	@ApiModelProperty(value = "备注") 
	private String remark;
		
	/**
	 * 配置1
	 */
	
	@ApiModelProperty(value = "配置1") 
	private String tip1;
		
	/**
	 * 配置2
	 */
	
	@ApiModelProperty(value = "配置2") 
	private String tip2;
		
	/**
	 * 配置3
	 */
	
	@ApiModelProperty(value = "配置3") 
	private String tip3;
		
	/**
	 * 配置4
	 */
	
	@ApiModelProperty(value = "配置4") 
	private String tip4;
		
	/**
	 * 配置集合
	 */
	
	@ApiModelProperty(value = "配置集合") 
	private String itemstr;
		
	/**
	 * 单价
	 */
	
	@ApiModelProperty(value = "单价") 
	private Double price;
		
	/**
	 * 配置ID
	 */
	
	@ApiModelProperty(value = "配置ID") 
	private Integer productItemId;
				
	
	/**
	 * 设置：产品ID
	 */
	 
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	
	/**
	 * 获取：产品ID
	 */
	public Integer getProductId() {
		return productId;
	}
				
	
	/**
	 * 设置：产品分类
	 */
	 
	public void setProductType(Integer productType) {
		this.productType = productType;
	}
	
	/**
	 * 获取：产品分类
	 */
	public Integer getProductType() {
		return productType;
	}
				
	
	/**
	 * 设置：用户ID
	 */
	 
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	/**
	 * 获取：用户ID
	 */
	public Integer getUserId() {
		return userId;
	}
				
	
	/**
	 * 设置：是否删除
	 */
	 
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	
	/**
	 * 获取：是否删除
	 */
	public Integer getIsDelete() {
		return isDelete;
	}
						
	
	/**
	 * 设置：数量
	 */
	 
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	/**
	 * 获取：数量
	 */
	public Integer getQuantity() {
		return quantity;
	}
				
	
	/**
	 * 设置：备注
	 */
	 
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	/**
	 * 获取：备注
	 */
	public String getRemark() {
		return remark;
	}
				
	
	/**
	 * 设置：配置1
	 */
	 
	public void setTip1(String tip1) {
		this.tip1 = tip1;
	}
	
	/**
	 * 获取：配置1
	 */
	public String getTip1() {
		return tip1;
	}
				
	
	/**
	 * 设置：配置2
	 */
	 
	public void setTip2(String tip2) {
		this.tip2 = tip2;
	}
	
	/**
	 * 获取：配置2
	 */
	public String getTip2() {
		return tip2;
	}
				
	
	/**
	 * 设置：配置3
	 */
	 
	public void setTip3(String tip3) {
		this.tip3 = tip3;
	}
	
	/**
	 * 获取：配置3
	 */
	public String getTip3() {
		return tip3;
	}
				
	
	/**
	 * 设置：配置4
	 */
	 
	public void setTip4(String tip4) {
		this.tip4 = tip4;
	}
	
	/**
	 * 获取：配置4
	 */
	public String getTip4() {
		return tip4;
	}
				
	
	/**
	 * 设置：配置集合
	 */
	 
	public void setItemstr(String itemstr) {
		this.itemstr = itemstr;
	}
	
	/**
	 * 获取：配置集合
	 */
	public String getItemstr() {
		return itemstr;
	}
				
	
	/**
	 * 设置：单价
	 */
	 
	public void setPrice(Double price) {
		this.price = price;
	}
	
	/**
	 * 获取：单价
	 */
	public Double getPrice() {
		return price;
	}
				
	
	/**
	 * 设置：配置ID
	 */
	 
	public void setProductItemId(Integer productItemId) {
		this.productItemId = productItemId;
	}
	
	/**
	 * 获取：配置ID
	 */
	public Integer getProductItemId() {
		return productItemId;
	}
			
}
