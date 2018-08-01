package com.freeter.modules.pc.entity.view;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.baomidou.mybatisplus.annotations.TableName;
import com.freeter.modules.good.entity.GoodEntity;
import com.freeter.modules.pc.entity.SeckillEntity;

import io.swagger.annotations.ApiModel;

/**
 * 
 * 后端返回视图实体辅助类 （通常后端关联的表或者自定义的字段需要返回使用）
 * 
 * @author SIXECO
 * @email yqq@sixeco.com
 * @date 2018-07-26 18:20:16
 */
@TableName("cn_seckill")
@ApiModel(value = "Seckill")
public class SeckillView extends SeckillEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public SeckillView() {
	}

	public SeckillView(SeckillEntity seckillEntity) {
		try {
			BeanUtils.copyProperties(this, seckillEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 商品List
	 */
	private List<GoodEntity> GoodEntityList;

	/**
	 * 系统当前的时间
	 */
	private String systemCurrentTime;

	public List<GoodEntity> getGoodEntityList() {
		return GoodEntityList;
	}

	public void setGoodEntityList(List<GoodEntity> goodEntityList) {
		GoodEntityList = goodEntityList;
	}

	public String getSystemCurrentTime() {
		return systemCurrentTime;
	}

	public void setSystemCurrentTime(String systemCurrentTime) {
		this.systemCurrentTime = systemCurrentTime;
	}

}
