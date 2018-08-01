package com.freeter.modules.good.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import com.freeter.modules.good.entity.model.GoodItemModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;



/**
 * 
 * 数据库通用操作实体类（普通增删改查）
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-07-31 14:46:54
 */
@TableName("cn_good_item")
@ApiModel(value = "GoodItem")
public class GoodItemEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public GoodItemEntity() {
		
	}
	
	public GoodItemEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	
	@TableId 					
	@ApiModelProperty(value = "",hidden = true)
	private Integer productItemId;
	
	/**
	 * 
	 */
						
	@ApiModelProperty(value = "")
	private Integer productId;
	
	/**
	 * 第一层分类 
	 */
						
	@ApiModelProperty(value = "第一层分类 ")
	private String level1Type;
	
	/**
	 * 第二层分类
	 */
						
	@ApiModelProperty(value = "第二层分类")
	private String level2Type;
	
	/**
	 * 第三层分类 
	 */
						
	@ApiModelProperty(value = "第三层分类 ")
	private String level3Type;
	
	/**
	 * 
	 */
						
	@ApiModelProperty(value = "")
	private String level4Type;
	
	/**
	 * 
	 */
						
	@ApiModelProperty(value = "")
	private String level5Type;
	
	/**
	 * 
	 */
						
	@ApiModelProperty(value = "")
	private String level6Type;
	
	/**
	 * 
	 */
						
	@ApiModelProperty(value = "")
	private String level7Type;
	
	/**
	 * 
	 */
						
	@ApiModelProperty(value = "")
	private String subtype2;
	
	/**
	 * 
	 */
						
	@ApiModelProperty(value = "")
	private String subtype;
	
	/**
	 * 价格
	 */
						
	@ApiModelProperty(value = "价格")
	private Double price;
	
	/**
	 * 
	 */
						
	@ApiModelProperty(value = "")
	private String description;
	
	/**
	 * 
	 */
						
	@ApiModelProperty(value = "")
	private String others;
	
	/**
	 * 是否删除  0:未删 1:已删
	 */
						
	@ApiModelProperty(value = "是否删除  0:未删 1:已删")
	private Integer isDeleted;
	
	/**
	 * 是否使用(上下架)
0 - 否(下架)
1 - 是(上架)
	 */
						
	@ApiModelProperty(value = "是否使用(上下架)")
	private Integer isUse;
	
	/**
	 * 0整车1周边
	 */
						
	@ApiModelProperty(value = "0整车1周边")
	private String type;
	
	/**
	 * 
	 */
						
	@ApiModelProperty(value = "")
	private String isDefault;
	
	/**
	 * 商品编号
	 */
						
	@ApiModelProperty(value = "商品编号")
	private String productCode;
	
	/**
	 * 商品库存
	 */
						
	@ApiModelProperty(value = "商品库存")
	private Integer inventory;
	
	/**
	 * 
	 */
						
	@ApiModelProperty(value = "")
	private String vsn;
	
	/**
	 * 设置：
	 */
	public void setProductItemId(Integer productItemId) {
		this.productItemId = productItemId;
	}
	/**
	 * 获取：
	 */
	public Integer getProductItemId() {
		return productItemId;
	}
	/**
	 * 设置：
	 */
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	/**
	 * 获取：
	 */
	public Integer getProductId() {
		return productId;
	}
	/**
	 * 设置：第一层分类 
	 */
	public void setLevel1Type(String level1Type) {
		this.level1Type = level1Type;
	}
	/**
	 * 获取：第一层分类 
	 */
	public String getLevel1Type() {
		return level1Type;
	}
	/**
	 * 设置：第二层分类
	 */
	public void setLevel2Type(String level2Type) {
		this.level2Type = level2Type;
	}
	/**
	 * 获取：第二层分类
	 */
	public String getLevel2Type() {
		return level2Type;
	}
	/**
	 * 设置：第三层分类 
	 */
	public void setLevel3Type(String level3Type) {
		this.level3Type = level3Type;
	}
	/**
	 * 获取：第三层分类 
	 */
	public String getLevel3Type() {
		return level3Type;
	}
	/**
	 * 设置：
	 */
	public void setLevel4Type(String level4Type) {
		this.level4Type = level4Type;
	}
	/**
	 * 获取：
	 */
	public String getLevel4Type() {
		return level4Type;
	}
	/**
	 * 设置：
	 */
	public void setLevel5Type(String level5Type) {
		this.level5Type = level5Type;
	}
	/**
	 * 获取：
	 */
	public String getLevel5Type() {
		return level5Type;
	}
	/**
	 * 设置：
	 */
	public void setLevel6Type(String level6Type) {
		this.level6Type = level6Type;
	}
	/**
	 * 获取：
	 */
	public String getLevel6Type() {
		return level6Type;
	}
	/**
	 * 设置：
	 */
	public void setLevel7Type(String level7Type) {
		this.level7Type = level7Type;
	}
	/**
	 * 获取：
	 */
	public String getLevel7Type() {
		return level7Type;
	}
	/**
	 * 设置：
	 */
	public void setSubtype2(String subtype2) {
		this.subtype2 = subtype2;
	}
	/**
	 * 获取：
	 */
	public String getSubtype2() {
		return subtype2;
	}
	/**
	 * 设置：
	 */
	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}
	/**
	 * 获取：
	 */
	public String getSubtype() {
		return subtype;
	}
	/**
	 * 设置：价格
	 */
	public void setPrice(Double price) {
		this.price = price;
	}
	/**
	 * 获取：价格
	 */
	public Double getPrice() {
		return price;
	}
	/**
	 * 设置：
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * 获取：
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * 设置：
	 */
	public void setOthers(String others) {
		this.others = others;
	}
	/**
	 * 获取：
	 */
	public String getOthers() {
		return others;
	}
	/**
	 * 设置：是否删除  0:未删 1:已删
	 */
	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}
	/**
	 * 获取：是否删除  0:未删 1:已删
	 */
	public Integer getIsDeleted() {
		return isDeleted;
	}
	/**
	 * 设置：是否使用(上下架)
0 - 否(下架)
1 - 是(上架)
	 */
	public void setIsUse(Integer isUse) {
		this.isUse = isUse;
	}
	/**
	 * 获取：是否使用(上下架)
0 - 否(下架)
1 - 是(上架)
	 */
	public Integer getIsUse() {
		return isUse;
	}
	/**
	 * 设置：0整车1周边
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：0整车1周边
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：
	 */
	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}
	/**
	 * 获取：
	 */
	public String getIsDefault() {
		return isDefault;
	}
	/**
	 * 设置：商品编号
	 */
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	/**
	 * 获取：商品编号
	 */
	public String getProductCode() {
		return productCode;
	}
	/**
	 * 设置：商品库存
	 */
	public void setInventory(Integer inventory) {
		this.inventory = inventory;
	}
	/**
	 * 获取：商品库存
	 */
	public Integer getInventory() {
		return inventory;
	}
	/**
	 * 设置：
	 */
	public void setVsn(String vsn) {
		this.vsn = vsn;
	}
	/**
	 * 获取：
	 */
	public String getVsn() {
		return vsn;
	}
	
	public GoodItemModel getModel(){
	    GoodItemModel itemModel=new GoodItemModel();
	    itemModel.setProductItemId(this.productItemId);
	    itemModel.setProductCode(this.productCode);
	    return itemModel;
    }
}
