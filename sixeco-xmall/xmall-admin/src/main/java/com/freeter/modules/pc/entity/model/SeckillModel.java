package com.freeter.modules.pc.entity.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * 接收传参的实体类 （实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 取自ModelAndView 的model名称
 * 
 * @author SIXECO
 * @email yqq@sixeco.com
 * @date 2018-07-26 18:20:16
 */
@ApiModel(value = "SeckillModel")
public class SeckillModel implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 活动名称
	 */

	@ApiModelProperty(value = "活动名称")
	private String activityName;

	/**
	 * 开始时间
	 */

	@JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	@ApiModelProperty(value = "开始时间")
	private Date beginTime;

	/**
	 * 结束时间
	 */

	@JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	@ApiModelProperty(value = "结束时间")
	private Date endTime;

	/**
	 * 活动商品id用逗号隔开
	 */

	@ApiModelProperty(value = "活动商品id用逗号隔开")
	private String activityGoodId;

	/**
	 * 提示语
	 */

	@ApiModelProperty(value = "提示语")
	private String describes;

	/**
	 * 活动状态 0-未开始 1-进行中 2-已结束
	 */

	@ApiModelProperty(value = "活动状态 0-未开始 1-进行中 2-已结束")
	private Integer state;

	/**
	 * 1普通活动2秒抢3团购
	 */

	@ApiModelProperty(value = "1普通活动2秒抢3团购")
	private Integer type;

	/**
	 * 开始时间点
	 */

	@ApiModelProperty(value = "开始时间点")
	private String beginTimePoint;

	/**
	 * 结束时间点
	 */

	@ApiModelProperty(value = "结束时间点")
	private String endTimePoint;

	/**
	 * 活动id
	 */
	private Integer id;

	/**
	 * 商品ids
	 */
	private Integer[] goodIds;

	/**
	 * 设置：活动名称
	 */

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	/**
	 * 获取：活动名称
	 */
	public String getActivityName() {
		return activityName;
	}

	/**
	 * 设置：开始时间
	 */

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	/**
	 * 获取：开始时间
	 */
	public Date getBeginTime() {
		return beginTime;
	}

	/**
	 * 设置：结束时间
	 */

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	/**
	 * 获取：结束时间
	 */
	public Date getEndTime() {
		return endTime;
	}

	/**
	 * 设置：活动商品id用逗号隔开
	 */

	public void setActivityGoodId(String activityGoodId) {
		this.activityGoodId = activityGoodId;
	}

	/**
	 * 获取：活动商品id用逗号隔开
	 */
	public String getActivityGoodId() {
		return activityGoodId;
	}

	/**
	 * 设置：提示语
	 */

	public void setDescribes(String describes) {
		this.describes = describes;
	}

	/**
	 * 获取：提示语
	 */
	public String getDescribes() {
		return describes;
	}

	/**
	 * 设置：活动状态 0-未开始 1-进行中 2-已结束
	 */

	public void setState(Integer state) {
		this.state = state;
	}

	/**
	 * 获取：活动状态 0-未开始 1-进行中 2-已结束
	 */
	public Integer getState() {
		return state;
	}

	/**
	 * 设置：1普通活动2秒抢3团购
	 */

	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * 获取：1普通活动2秒抢3团购
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * 设置：开始时间点
	 */

	public void setBeginTimePoint(String beginTimePoint) {
		this.beginTimePoint = beginTimePoint;
	}

	/**
	 * 获取：开始时间点
	 */
	public String getBeginTimePoint() {
		return beginTimePoint;
	}

	/**
	 * 设置：结束时间点
	 */

	public void setEndTimePoint(String endTimePoint) {
		this.endTimePoint = endTimePoint;
	}

	/**
	 * 获取：结束时间点
	 */
	public String getEndTimePoint() {
		return endTimePoint;
	}

	public Integer[] getGoodIds() {
		return goodIds;
	}

	public void setGoodIds(Integer[] goodIds) {
		this.goodIds = goodIds;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
