package com.freeter.modules.good.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

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
 * @date 2018-07-31 15:38:04
 */
@TableName("cn_good_item_image")
@ApiModel(value = "GoodItemImage")
public class GoodItemImageEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public GoodItemImageEntity() {
		
	}
	
	public GoodItemImageEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 主键id,自增
	 */
	
	@TableId 					
	@ApiModelProperty(value = "主键id,自增",hidden = true)
	private Integer productItemImageId;
	
	/**
	 * 商品配置id
	 */
			
	@NotNull (message = "商品配置id不能为空") 				
	@ApiModelProperty(value = "商品配置id")
	private Integer productItemId;
	
	/**
	 * 商品id
	 */
						
	@ApiModelProperty(value = "商品id")
	private Integer productId;
	
	/**
	 * 资源路径url
	 */
						
	@ApiModelProperty(value = "资源路径url")
	private String url;
	
	/**
	 * 文件类型
	 */
						
	@ApiModelProperty(value = "文件类型")
	private String fileType;
	
	/**
	 * 标签
	 */
						
	@ApiModelProperty(value = "标签")
	private String tag;
	
	/**
	 * 配置需要vsn编码
	 */
						
	@ApiModelProperty(value = "配置需要vsn编码")
	private String vsn;
	
	/**
	 * 1主图、2封面、3详情、4参数、5配置  （配置需要vsn编码）
	 */
						
	@ApiModelProperty(value = "1主图、2封面、3详情、4参数、5配置  （配置需要vsn编码）")
	private Integer type;
	
	/**
	 * 1整车2周边
	 */
						
	@ApiModelProperty(value = "1整车2周边")
	private Integer classify;
	
	/**
	 * 设置：主键id,自增
	 */
	public void setProductItemImageId(Integer productItemImageId) {
		this.productItemImageId = productItemImageId;
	}
	/**
	 * 获取：主键id,自增
	 */
	public Integer getProductItemImageId() {
		return productItemImageId;
	}
	/**
	 * 设置：商品配置id
	 */
	public void setProductItemId(Integer productItemId) {
		this.productItemId = productItemId;
	}
	/**
	 * 获取：商品配置id
	 */
	public Integer getProductItemId() {
		return productItemId;
	}
	/**
	 * 设置：商品id
	 */
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	/**
	 * 获取：商品id
	 */
	public Integer getProductId() {
		return productId;
	}
	/**
	 * 设置：资源路径url
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * 获取：资源路径url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * 设置：文件类型
	 */
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	/**
	 * 获取：文件类型
	 */
	public String getFileType() {
		return fileType;
	}
	/**
	 * 设置：标签
	 */
	public void setTag(String tag) {
		this.tag = tag;
	}
	/**
	 * 获取：标签
	 */
	public String getTag() {
		return tag;
	}
	/**
	 * 设置：配置需要vsn编码
	 */
	public void setVsn(String vsn) {
		this.vsn = vsn;
	}
	/**
	 * 获取：配置需要vsn编码
	 */
	public String getVsn() {
		return vsn;
	}
	/**
	 * 设置：1主图、2封面、3详情、4参数、5配置  （配置需要vsn编码）
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取：1主图、2封面、3详情、4参数、5配置  （配置需要vsn编码）
	 */
	public Integer getType() {
		return type;
	}
	/**
	 * 设置：1整车2周边
	 */
	public void setClassify(Integer classify) {
		this.classify = classify;
	}
	/**
	 * 获取：1整车2周边
	 */
	public Integer getClassify() {
		return classify;
	}
}
