package com.freeter.modules.good.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.freeter.modules.good.entity.view.ChannelView;

import java.lang.reflect.InvocationTargetException;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;



/**
 * 频道
 * 
 * @author SIXECO
 * @email yqq@sixeco.com
 * @date 2018-05-28 17:34:00
 */
@TableName("cn_channel")
@ApiModel(value = "Channel")
public class ChannelEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ChannelEntity() {
		
	}
	
	public ChannelEntity(T t) {
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
	private Long channelId;
	
	/**
	 * 频道名称
	 */
					 
	@ApiModelProperty(value = "频道名称")
	private String name;
	
	/**
	 * 排序
	 */
					 
	@ApiModelProperty(value = "排序")
	private Integer sort;
	
	/**
	 * 设置：
	 */
	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}
	/**
	 * 获取：
	 */
	public Long getChannelId() {
		return channelId;
	}
	/**
	 * 设置：频道名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：频道名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：排序
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	/**
	 * 获取：排序
	 */
	public Integer getSort() {
		return sort;
	}
}
