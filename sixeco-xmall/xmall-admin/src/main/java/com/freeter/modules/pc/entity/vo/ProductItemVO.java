package com.freeter.modules.pc.entity.vo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * 手机端接口返回实体辅助类 （主要作用去除一些不必要的字段）
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-07-30 17:53:30
 */
@ApiModel(value = "ProductItemVO")
public class ProductItemVO implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */

	@ApiModelProperty(value = "")
	private Integer productId;

	/**
	 * 第一层分类 车身
	 */

	@ApiModelProperty(value = "第一层分类   车身")
	private String level1Type;

	/**
	 * 第二层分类 车顶
	 */

	@ApiModelProperty(value = "第二层分类   车顶")
	private String level2Type;

	/**
	 * 第三层分类 内饰
	 */

	@ApiModelProperty(value = "第三层分类   内饰")
	private String level3Type;

	/**
	 * 第四层分类 电池
	 */

	@ApiModelProperty(value = "第四层分类   电池")
	private String level4Type;

	/**
	 * 第五层分类 电池包
	 */

	@ApiModelProperty(value = "第五层分类   电池包")
	private String level5Type;

	/**
	 * 第六层分类 选装手动空调
	 */

	@ApiModelProperty(value = "第六层分类   选装手动空调")
	private String level6Type;

	/**
	 * 第七层分类 电机
	 */

	@ApiModelProperty(value = "第七层分类   电机")
	private String level7Type;

	/**
	 * 车系
	 */

	@ApiModelProperty(value = "车系")
	private String subtype2;

	/**
	 * 车型
	 */

	@ApiModelProperty(value = "车型")
	private String subtype;

	/**
	 * 价格
	 */

	@ApiModelProperty(value = "价格")
	private Double price;

	/**
	 * 描述
	 */

	@ApiModelProperty(value = "描述")
	private String description;

	/**
	 * 其他信息
	 */

	@ApiModelProperty(value = "其他信息")
	private String others;

	/**
	 * 是否删除 0:未删 1:已删
	 */

	@ApiModelProperty(value = "是否删除  0:未删 1:已删")
	private Integer isDeleted;

	/**
	 * 是否使用(上下架) 0 - 否(下架) 1 - 是(上架)
	 */

	@ApiModelProperty(value = "是否使用(上下架)0 - 否(下架)1 - 是(上架)")
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
	 * vsn编码
	 */

	@ApiModelProperty(value = "vsn编码")
	private String vsn;

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
	 * 设置：第一层分类 车身
	 */

	public void setLevel1Type(String level1Type) {
		this.level1Type = level1Type;
	}

	/**
	 * 获取：第一层分类 车身
	 */
	public String getLevel1Type() {
		return level1Type;
	}

	/**
	 * 设置：第二层分类 车顶
	 */

	public void setLevel2Type(String level2Type) {
		this.level2Type = level2Type;
	}

	/**
	 * 获取：第二层分类 车顶
	 */
	public String getLevel2Type() {
		return level2Type;
	}

	/**
	 * 设置：第三层分类 内饰
	 */

	public void setLevel3Type(String level3Type) {
		this.level3Type = level3Type;
	}

	/**
	 * 获取：第三层分类 内饰
	 */
	public String getLevel3Type() {
		return level3Type;
	}

	/**
	 * 设置：第四层分类 电池
	 */

	public void setLevel4Type(String level4Type) {
		this.level4Type = level4Type;
	}

	/**
	 * 获取：第四层分类 电池
	 */
	public String getLevel4Type() {
		return level4Type;
	}

	/**
	 * 设置：第五层分类 电池包
	 */

	public void setLevel5Type(String level5Type) {
		this.level5Type = level5Type;
	}

	/**
	 * 获取：第五层分类 电池包
	 */
	public String getLevel5Type() {
		return level5Type;
	}

	/**
	 * 设置：第六层分类 选装手动空调
	 */

	public void setLevel6Type(String level6Type) {
		this.level6Type = level6Type;
	}

	/**
	 * 获取：第六层分类 选装手动空调
	 */
	public String getLevel6Type() {
		return level6Type;
	}

	/**
	 * 设置：第七层分类 电机
	 */

	public void setLevel7Type(String level7Type) {
		this.level7Type = level7Type;
	}

	/**
	 * 获取：第七层分类 电机
	 */
	public String getLevel7Type() {
		return level7Type;
	}

	/**
	 * 设置：车系
	 */

	public void setSubtype2(String subtype2) {
		this.subtype2 = subtype2;
	}

	/**
	 * 获取：车系
	 */
	public String getSubtype2() {
		return subtype2;
	}

	/**
	 * 设置：车型
	 */

	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}

	/**
	 * 获取：车型
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
	 * 设置：描述
	 */

	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 获取：描述
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 设置：其他信息
	 */

	public void setOthers(String others) {
		this.others = others;
	}

	/**
	 * 获取：其他信息
	 */
	public String getOthers() {
		return others;
	}

	/**
	 * 设置：是否删除 0:未删 1:已删
	 */

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

	/**
	 * 获取：是否删除 0:未删 1:已删
	 */
	public Integer getIsDeleted() {
		return isDeleted;
	}

	/**
	 * 设置：是否使用(上下架) 0 - 否(下架) 1 - 是(上架)
	 */

	public void setIsUse(Integer isUse) {
		this.isUse = isUse;
	}

	/**
	 * 获取：是否使用(上下架) 0 - 否(下架) 1 - 是(上架)
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
	 * 设置：vsn编码
	 */

	public void setVsn(String vsn) {
		this.vsn = vsn;
	}

	/**
	 * 获取：vsn编码
	 */
	public String getVsn() {
		return vsn;
	}

}
