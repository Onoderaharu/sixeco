package com.freeter.modules.pc.entity.model;

import com.freeter.modules.pc.entity.CategoryEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 分类表
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-07-28 16:51:05
 */
@ApiModel(value = "CategoryModel")
public class CategoryModel  implements Serializable {
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
	private String name;
			
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
	 
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 获取：分类名称
	 */
	public String getName() {
		return name;
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
			
}
