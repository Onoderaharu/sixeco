package com.freeter.modules.pc.entity;

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
 * @author SIXECO
 * @email yqq@sixeco.com
 * @date 2018-07-26 18:20:16
 */
@TableName("cn_seckill")
@ApiModel(value = "Seckill")
public class SeckillEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public SeckillEntity() {
		
	}
	
	public SeckillEntity(T t) {
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
	private Integer id;
	
	/**
	 * 活动名称
	 */
						
	@ApiModelProperty(value = "活动名称")
	private String activityName;
	
	/**
	 * 开始时间
	 */
					
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	@ApiModelProperty(value = "开始时间")
	private Date beginTime;
	
	/**
	 * 结束时间
	 */
					
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
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
	 * 创建时间
	 */
					
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 			
	@TableField(fill = FieldFill.INSERT) 
	@ApiModelProperty(value = "创建时间",hidden = true)
	private Date createTime;
	
	/**
	 * 创建人
	 */
							
	@TableField(fill = FieldFill.INSERT) 
	@ApiModelProperty(value = "创建人",hidden = true)
	private String createBy;
	
	/**
	 * 最后修改时间
	 */
					
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	@TableField(fill = FieldFill.UPDATE) 	
	@ApiModelProperty(value = "最后修改时间",hidden = true)
	private Date updateTime;
	
	/**
	 * 修改人
	 */
						
	@TableField(fill = FieldFill.UPDATE) 	
	@ApiModelProperty(value = "修改人",hidden = true)
	private String updateBy;
	
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
	 * 设置：主键id,自增
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：主键id,自增
	 */
	public Integer getId() {
		return id;
	}
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
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：创建人
	 */
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	/**
	 * 获取：创建人
	 */
	public String getCreateBy() {
		return createBy;
	}
	/**
	 * 设置：最后修改时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：最后修改时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 设置：修改人
	 */
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	/**
	 * 获取：修改人
	 */
	public String getUpdateBy() {
		return updateBy;
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
}
