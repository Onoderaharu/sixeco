package com.freeter.modules.good.entity.vo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 分类表 手机端接口返回实体辅助类 （主要作用去除一些不必要的字段）
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-07-28 17:15:57
 */
@ApiModel(value = "CategoryVO")
public class CategoryVO implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 父分类ID
	 */

	@ApiModelProperty(value = "父分类ID")
	private Long parentId;

	/**
	 * 分类名称
	 */

	@ApiModelProperty(value = "分类名称")
	private String categoryName;

	/**
	 * 目录类型 2=二级目录/1=一级目录/0=总目录
	 */

	@ApiModelProperty(value = "目录类型 2=二级目录/1=一级目录/0=总目录")
	private Integer type;

	/**
	 * 状态 1=显示/0=隐藏
	 */

	@ApiModelProperty(value = "状态 1=显示/0=隐藏")
	private Integer status;

	/**
	 * 是否推荐（0：不推荐 1：推荐）
	 */

	@ApiModelProperty(value = "是否推荐（0：不推荐 1：推荐）")
	private Integer showInCommend;

	/**
	 * 是否导航栏 1=显示/0=隐藏
	 */

	@ApiModelProperty(value = "是否导航栏 1=显示/0=隐藏")
	private Integer showInNav;

	/**
	 * 是否置顶 1=置顶/0=默认
	 */

	@ApiModelProperty(value = "是否置顶 1=置顶/0=默认")
	private Integer showInTop;

	/**
	 * 是否热门 1=热门/0=默认
	 */

	@ApiModelProperty(value = "是否热门 1=热门/0=默认")
	private Integer showInHot;

	/**
	 * 分类小图标
	 */

	@ApiModelProperty(value = "分类小图标")
	private String icon;

	/**
	 * 页面标题
	 */

	@ApiModelProperty(value = "页面标题")
	private String pageTitle;

	/**
	 * 页面描述
	 */

	@ApiModelProperty(value = "页面描述")
	private String pageDescription;

	/**
	 * 页面关键词
	 */

	@ApiModelProperty(value = "页面关键词")
	private String pageKeyword;

	/**
	 * 备注信息
	 */

	@ApiModelProperty(value = "备注信息")
	private String remarks;

	/**
	 * 频道id
	 */

	@ApiModelProperty(value = "频道id")
	private String channelId;

	/**
	 * 删除标记（0未删除1删除）
	 */

	@ApiModelProperty(value = "删除标记（0未删除1删除）")
	private String deleteFlag;

	/**
	 * 父分类id，用，开始结尾，中间用，分割
	 */

	@ApiModelProperty(value = "父分类id，用，开始结尾，中间用，分割")
	private String categoryIdStr;

	/**
	 * 分类下所有商品id，用，开始结尾，中间用，分割
	 */

	@ApiModelProperty(value = "分类下所有商品id，用，开始结尾，中间用，分割")
	private String goodIdStr;

	/**
	 * 设置：父分类ID
	 */

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	/**
	 * 获取：父分类ID
	 */
	public Long getParentId() {
		return parentId;
	}

	/**
	 * 设置：分类名称
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	/**
	 * 获取：分类名称
	 */
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * 设置：目录类型 2=二级目录/1=一级目录/0=总目录
	 */

	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * 获取：目录类型 2=二级目录/1=一级目录/0=总目录
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * 设置：状态 1=显示/0=隐藏
	 */

	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * 获取：状态 1=显示/0=隐藏
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * 设置：是否推荐（0：不推荐 1：推荐）
	 */

	public void setShowInCommend(Integer showInCommend) {
		this.showInCommend = showInCommend;
	}

	/**
	 * 获取：是否推荐（0：不推荐 1：推荐）
	 */
	public Integer getShowInCommend() {
		return showInCommend;
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
	 * 设置：分类小图标
	 */

	public void setIcon(String icon) {
		this.icon = icon;
	}

	/**
	 * 获取：分类小图标
	 */
	public String getIcon() {
		return icon;
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
	 * 设置：页面描述
	 */

	public void setPageDescription(String pageDescription) {
		this.pageDescription = pageDescription;
	}

	/**
	 * 获取：页面描述
	 */
	public String getPageDescription() {
		return pageDescription;
	}

	/**
	 * 设置：页面关键词
	 */

	public void setPageKeyword(String pageKeyword) {
		this.pageKeyword = pageKeyword;
	}

	/**
	 * 获取：页面关键词
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
	 * 设置：频道id
	 */

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	/**
	 * 获取：频道id
	 */
	public String getChannelId() {
		return channelId;
	}

	/**
	 * 设置：删除标记（0未删除1删除）
	 */

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	/**
	 * 获取：删除标记（0未删除1删除）
	 */
	public String getDeleteFlag() {
		return deleteFlag;
	}

	/**
	 * 设置：父分类id，用，开始结尾，中间用，分割
	 */

	public void setCategoryIdStr(String categoryIdStr) {
		this.categoryIdStr = categoryIdStr;
	}

	/**
	 * 获取：父分类id，用，开始结尾，中间用，分割
	 */
	public String getCategoryIdStr() {
		return categoryIdStr;
	}

	/**
	 * 设置：分类下所有商品id，用，开始结尾，中间用，分割
	 */

	public void setGoodIdStr(String goodIdStr) {
		this.goodIdStr = goodIdStr;
	}

	/**
	 * 获取：分类下所有商品id，用，开始结尾，中间用，分割
	 */
	public String getGoodIdStr() {
		return goodIdStr;
	}

}
