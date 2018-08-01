package com.freeter.modules.good.entity.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 商品表 接收传参的实体类 （实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 取自ModelAndView
 * 的model名称
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-07-27 11:35:43
 */
@ApiModel(value = "GoodModel")
public class GoodModel implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 商品名称
	 */

	@ApiModelProperty(value = "商品名称")
	private String goodName;

	/**
	 * 商品编号
	 */

	@ApiModelProperty(value = "商品编号")
	private String goodNumber;

	/**
	 * 最大价格
	 */

	@ApiModelProperty(value = "最大价格")
	private BigDecimal maxPrice;

	/**
	 * 最小价格
	 */

	@ApiModelProperty(value = "最小价格")
	private BigDecimal minPrice;

	/**
	 * 商品简介
	 */

	@ApiModelProperty(value = "商品简介")
	private String introduce;

	/**
	 * 展示图片
	 */

	@ApiModelProperty(value = "展示图片")
	private String picImg;

	/**
	 * 是否置顶 1=置顶/0=默认
	 */

	@ApiModelProperty(value = "是否置顶 1=置顶/0=默认")
	private Integer showInTop;

	/**
	 * 是否导航栏 1=显示/0=隐藏
	 */

	@ApiModelProperty(value = "是否导航栏 1=显示/0=隐藏")
	private Integer showInNav;

	/**
	 * 猜你喜欢 1=显示/0=隐藏
	 */

	@ApiModelProperty(value = "猜你喜欢 1=显示/0=隐藏")
	private Integer showInLike;

	/**
	 * 是否热门 1=热门/0=默认
	 */

	@ApiModelProperty(value = "是否热门 1=热门/0=默认")
	private Integer showInHot;

	/**
	 * 是否上架：1=上架/0=下架
	 */

	@ApiModelProperty(value = "是否上架：1=上架/0=下架")
	private Integer showInShelve;

	/**
	 * 搜索的关键词
	 */

	@ApiModelProperty(value = "搜索的关键词")
	private String searchKey;

	/**
	 * 单位
	 */

	@ApiModelProperty(value = "单位")
	private String units;

	/**
	 * 激活状态(0:未激活 1：激活)
	 */

	@ApiModelProperty(value = "激活状态(0:未激活 1：激活)")
	private Integer activate;

	/**
	 * 页面标题
	 */

	@ApiModelProperty(value = "页面标题")
	private String pageTitle;

	/**
	 * 页面的描述
	 */

	@ApiModelProperty(value = "页面的描述")
	private String pageDescription;

	/**
	 * 页面的关键词
	 */

	@ApiModelProperty(value = "页面的关键词")
	private String pageKeyword;

	/**
	 * 备注信息
	 */

	@ApiModelProperty(value = "备注信息")
	private String remarks;

	/**
	 * 上架时间
	 */

	@JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	@ApiModelProperty(value = "上架时间")
	private Date shelveTime;

	/**
	 * 上架人
	 */

	@ApiModelProperty(value = "上架人")
	private String shelveBy;

	/**
	 * 商户id
	 */

	@ApiModelProperty(value = "商户id")
	private Long martId;

	/**
	 * 删除标记，0否1是
	 */

	@ApiModelProperty(value = "删除标记，0否1是")
	private Integer delFlag;

	/**
	 * 分类id
	 */

	@ApiModelProperty(value = "分类id")
	private Long categoryId;

	/**
	 * 内容
	 */

	@ApiModelProperty(value = "内容")
	private String content;

	/**
	 * 默认价格
	 */

	@ApiModelProperty(value = "默认价格")
	private BigDecimal defaultPrice;

	/**
	 * 折扣
	 */

	@ApiModelProperty(value = "折扣")
	private BigDecimal discount;

	/**
	 * 库存
	 */

	@ApiModelProperty(value = "库存")
	private Integer inventory;

	/**
	 * 新品标记，0否1是
	 */

	@ApiModelProperty(value = "新品标记，0否1是")
	private Integer newGoodFlag;

	/**
	 * 一级配置
	 */

	@ApiModelProperty(value = "一级配置")
	private String tip1;

	/**
	 * 二级配置
	 */

	@ApiModelProperty(value = "二级配置")
	private String tip2;

	/**
	 * 三级配置
	 */

	@ApiModelProperty(value = "三级配置")
	private String tip3;

	/**
	 * 四级配置
	 */

	@ApiModelProperty(value = "四级配置")
	private String tip4;

	/**
	 * 分类str 如,0,1,2,
	 */

	@ApiModelProperty(value = "分类str 如,0,1,2,")
	private String categoryStr;

	/**
	 * 配置用图（多张,JSON数组）
	 */

	@ApiModelProperty(value = "配置用图（多张,JSON数组）")
	private String configureImg;

	/**
	 * 评论ID组合 如,1,2,3,
	 */

	@ApiModelProperty(value = "评论ID组合 如,1,2,3,")
	private String commentsIdStr;

	/**
	 * 是否允许购买,0否 1是
	 */

	@ApiModelProperty(value = "是否允许购买,0否 1是")
	private Integer allowBuyFlag;

	/**
	 * 商品类型 默认1普通商品
	 */

	@ApiModelProperty(value = "商品类型 默认1普通商品")
	private Integer type;

	/**
	 * 活动价
	 */

	@ApiModelProperty(value = "活动价")
	private BigDecimal activityPrice;

	/**
	 * 原始库存
	 */

	@ApiModelProperty(value = "原始库存")
	private Integer originalInventory;

	/**
	 * 提货方式 1邮寄 2自提 3邮寄+自提
	 */

	@ApiModelProperty(value = "提货方式 1邮寄 2自提 3邮寄+自提")
	private Integer pickType;

	/**
	 * 供应商
	 */

	@ApiModelProperty(value = "供应商")
	private String supplier;

	private Integer[] goodIds;

	/**
	 * 设置：商品名称
	 */

	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}

	/**
	 * 获取：商品名称
	 */
	public String getGoodName() {
		return goodName;
	}

	/**
	 * 设置：商品编号
	 */

	public void setGoodNumber(String goodNumber) {
		this.goodNumber = goodNumber;
	}

	/**
	 * 获取：商品编号
	 */
	public String getGoodNumber() {
		return goodNumber;
	}

	/**
	 * 设置：最大价格
	 */

	public void setMaxPrice(BigDecimal maxPrice) {
		this.maxPrice = maxPrice;
	}

	/**
	 * 获取：最大价格
	 */
	public BigDecimal getMaxPrice() {
		return maxPrice;
	}

	/**
	 * 设置：最小价格
	 */

	public void setMinPrice(BigDecimal minPrice) {
		this.minPrice = minPrice;
	}

	/**
	 * 获取：最小价格
	 */
	public BigDecimal getMinPrice() {
		return minPrice;
	}

	/**
	 * 设置：商品简介
	 */

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	/**
	 * 获取：商品简介
	 */
	public String getIntroduce() {
		return introduce;
	}

	/**
	 * 设置：展示图片
	 */

	public void setPicImg(String picImg) {
		this.picImg = picImg;
	}

	/**
	 * 获取：展示图片
	 */
	public String getPicImg() {
		return picImg;
	}

	/**
	 * 设置：是否置顶 1=置顶/0=默认
	 */

	public void setShowInTop(Integer showInTop) {
		this.showInTop = showInTop;
	}

	/**
	 * 获取：是否置顶 1=置顶/0=默认
	 */
	public Integer getShowInTop() {
		return showInTop;
	}

	/**
	 * 设置：是否导航栏 1=显示/0=隐藏
	 */

	public void setShowInNav(Integer showInNav) {
		this.showInNav = showInNav;
	}

	/**
	 * 获取：是否导航栏 1=显示/0=隐藏
	 */
	public Integer getShowInNav() {
		return showInNav;
	}

	/**
	 * 设置：猜你喜欢 1=显示/0=隐藏
	 */

	public void setShowInLike(Integer showInLike) {
		this.showInLike = showInLike;
	}

	/**
	 * 获取：猜你喜欢 1=显示/0=隐藏
	 */
	public Integer getShowInLike() {
		return showInLike;
	}

	/**
	 * 设置：是否热门 1=热门/0=默认
	 */

	public void setShowInHot(Integer showInHot) {
		this.showInHot = showInHot;
	}

	/**
	 * 获取：是否热门 1=热门/0=默认
	 */
	public Integer getShowInHot() {
		return showInHot;
	}

	/**
	 * 设置：是否上架：1=上架/0=下架
	 */

	public void setShowInShelve(Integer showInShelve) {
		this.showInShelve = showInShelve;
	}

	/**
	 * 获取：是否上架：1=上架/0=下架
	 */
	public Integer getShowInShelve() {
		return showInShelve;
	}

	/**
	 * 设置：搜索的关键词
	 */

	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}

	/**
	 * 获取：搜索的关键词
	 */
	public String getSearchKey() {
		return searchKey;
	}

	/**
	 * 设置：单位
	 */

	public void setUnits(String units) {
		this.units = units;
	}

	/**
	 * 获取：单位
	 */
	public String getUnits() {
		return units;
	}

	/**
	 * 设置：激活状态(0:未激活 1：激活)
	 */

	public void setActivate(Integer activate) {
		this.activate = activate;
	}

	/**
	 * 获取：激活状态(0:未激活 1：激活)
	 */
	public Integer getActivate() {
		return activate;
	}

	/**
	 * 设置：页面标题
	 */

	public void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
	}

	/**
	 * 获取：页面标题
	 */
	public String getPageTitle() {
		return pageTitle;
	}

	/**
	 * 设置：页面的描述
	 */

	public void setPageDescription(String pageDescription) {
		this.pageDescription = pageDescription;
	}

	/**
	 * 获取：页面的描述
	 */
	public String getPageDescription() {
		return pageDescription;
	}

	/**
	 * 设置：页面的关键词
	 */

	public void setPageKeyword(String pageKeyword) {
		this.pageKeyword = pageKeyword;
	}

	/**
	 * 获取：页面的关键词
	 */
	public String getPageKeyword() {
		return pageKeyword;
	}

	/**
	 * 设置：备注信息
	 */

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	/**
	 * 获取：备注信息
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * 设置：上架时间
	 */

	public void setShelveTime(Date shelveTime) {
		this.shelveTime = shelveTime;
	}

	/**
	 * 获取：上架时间
	 */
	public Date getShelveTime() {
		return shelveTime;
	}

	/**
	 * 设置：上架人
	 */

	public void setShelveBy(String shelveBy) {
		this.shelveBy = shelveBy;
	}

	/**
	 * 获取：上架人
	 */
	public String getShelveBy() {
		return shelveBy;
	}

	/**
	 * 设置：商户id
	 */

	public void setMartId(Long martId) {
		this.martId = martId;
	}

	/**
	 * 获取：商户id
	 */
	public Long getMartId() {
		return martId;
	}

	/**
	 * 设置：删除标记，0否1是
	 */

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}

	/**
	 * 获取：删除标记，0否1是
	 */
	public Integer getDelFlag() {
		return delFlag;
	}

	/**
	 * 设置：分类id
	 */

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * 获取：分类id
	 */
	public Long getCategoryId() {
		return categoryId;
	}

	/**
	 * 设置：内容
	 */

	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * 获取：内容
	 */
	public String getContent() {
		return content;
	}

	/**
	 * 设置：默认价格
	 */

	public void setDefaultPrice(BigDecimal defaultPrice) {
		this.defaultPrice = defaultPrice;
	}

	/**
	 * 获取：默认价格
	 */
	public BigDecimal getDefaultPrice() {
		return defaultPrice;
	}

	/**
	 * 设置：折扣
	 */

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	/**
	 * 获取：折扣
	 */
	public BigDecimal getDiscount() {
		return discount;
	}

	/**
	 * 设置：库存
	 */

	public void setInventory(Integer inventory) {
		this.inventory = inventory;
	}

	/**
	 * 获取：库存
	 */
	public Integer getInventory() {
		return inventory;
	}

	/**
	 * 设置：新品标记，0否1是
	 */

	public void setNewGoodFlag(Integer newGoodFlag) {
		this.newGoodFlag = newGoodFlag;
	}

	/**
	 * 获取：新品标记，0否1是
	 */
	public Integer getNewGoodFlag() {
		return newGoodFlag;
	}

	/**
	 * 设置：一级配置
	 */

	public void setTip1(String tip1) {
		this.tip1 = tip1;
	}

	/**
	 * 获取：一级配置
	 */
	public String getTip1() {
		return tip1;
	}

	/**
	 * 设置：二级配置
	 */

	public void setTip2(String tip2) {
		this.tip2 = tip2;
	}

	/**
	 * 获取：二级配置
	 */
	public String getTip2() {
		return tip2;
	}

	/**
	 * 设置：三级配置
	 */

	public void setTip3(String tip3) {
		this.tip3 = tip3;
	}

	/**
	 * 获取：三级配置
	 */
	public String getTip3() {
		return tip3;
	}

	/**
	 * 设置：四级配置
	 */

	public void setTip4(String tip4) {
		this.tip4 = tip4;
	}

	/**
	 * 获取：四级配置
	 */
	public String getTip4() {
		return tip4;
	}

	/**
	 * 设置：分类str 如,0,1,2,
	 */

	public void setCategoryStr(String categoryStr) {
		this.categoryStr = categoryStr;
	}

	/**
	 * 获取：分类str 如,0,1,2,
	 */
	public String getCategoryStr() {
		return categoryStr;
	}

	/**
	 * 设置：配置用图（多张,JSON数组）
	 */

	public void setConfigureImg(String configureImg) {
		this.configureImg = configureImg;
	}

	/**
	 * 获取：配置用图（多张,JSON数组）
	 */
	public String getConfigureImg() {
		return configureImg;
	}

	/**
	 * 设置：评论ID组合 如,1,2,3,
	 */

	public void setCommentsIdStr(String commentsIdStr) {
		this.commentsIdStr = commentsIdStr;
	}

	/**
	 * 获取：评论ID组合 如,1,2,3,
	 */
	public String getCommentsIdStr() {
		return commentsIdStr;
	}

	/**
	 * 设置：是否允许购买,0否 1是
	 */

	public void setAllowBuyFlag(Integer allowBuyFlag) {
		this.allowBuyFlag = allowBuyFlag;
	}

	/**
	 * 获取：是否允许购买,0否 1是
	 */
	public Integer getAllowBuyFlag() {
		return allowBuyFlag;
	}

	/**
	 * 设置：商品类型 默认1普通商品
	 */

	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * 获取：商品类型 默认1普通商品
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * 设置：活动价
	 */

	public void setActivityPrice(BigDecimal activityPrice) {
		this.activityPrice = activityPrice;
	}

	/**
	 * 获取：活动价
	 */
	public BigDecimal getActivityPrice() {
		return activityPrice;
	}

	/**
	 * 设置：原始库存
	 */

	public void setOriginalInventory(Integer originalInventory) {
		this.originalInventory = originalInventory;
	}

	/**
	 * 获取：原始库存
	 */
	public Integer getOriginalInventory() {
		return originalInventory;
	}

	/**
	 * 设置：提货方式 1邮寄 2自提 3邮寄+自提
	 */

	public void setPickType(Integer pickType) {
		this.pickType = pickType;
	}

	/**
	 * 获取：提货方式 1邮寄 2自提 3邮寄+自提
	 */
	public Integer getPickType() {
		return pickType;
	}

	/**
	 * 设置：供应商
	 */

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	/**
	 * 获取：供应商
	 */
	public String getSupplier() {
		return supplier;
	}

	public Integer[] getGoodIds() {
		return goodIds;
	}

	public void setGoodIds(Integer[] goodIds) {
		this.goodIds = goodIds;
	}

}
