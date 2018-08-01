package com.freeter.modules.good.entity.view;


import com.freeter.modules.good.entity.GoodItemEntity;
import com.freeter.modules.good.entity.GoodItemImageEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-07-31 14:46:54
 */
@TableName("cn_good_item")
@ApiModel(value = "GoodItem")
public class GoodItemView extends GoodItemEntity implements Serializable {
	private static final long serialVersionUID = 1L;

    private Integer productId;

    private String level1Type;

    private String level2Type;

    private String level3Type;

    private Integer levelType;

    private Integer subType;

    private String subtype;

    private String subtype2;

    private String subtype3;

    private String subtype4;

    private String subtype5;

    private Integer isRecommend;

    private Integer isHot;

    private Integer cityId;

    @Override public Integer getProductId() {
        return productId;
    }

    @Override public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @Override public String getLevel1Type() {
        return level1Type;
    }

    @Override public void setLevel1Type(String level1Type) {
        this.level1Type = level1Type;
    }

    @Override public String getLevel2Type() {
        return level2Type;
    }

    @Override public void setLevel2Type(String level2Type) {
        this.level2Type = level2Type;
    }

    @Override public String getLevel3Type() {
        return level3Type;
    }

    @Override public void setLevel3Type(String level3Type) {
        this.level3Type = level3Type;
    }

    public Integer getLevelType() {
        return levelType;
    }

    public void setLevelType(Integer levelType) {
        this.levelType = levelType;
    }

    public Integer getSubType() {
        return subType;
    }

    public void setSubType(Integer subType) {
        this.subType = subType;
    }

    @Override public String getSubtype() {
        return subtype;
    }

    @Override public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    @Override public String getSubtype2() {
        return subtype2;
    }

    @Override public void setSubtype2(String subtype2) {
        this.subtype2 = subtype2;
    }

    public String getSubtype3() {
        return subtype3;
    }

    public void setSubtype3(String subtype3) {
        this.subtype3 = subtype3;
    }

    public String getSubtype4() {
        return subtype4;
    }

    public void setSubtype4(String subtype4) {
        this.subtype4 = subtype4;
    }

    public String getSubtype5() {
        return subtype5;
    }

    public void setSubtype5(String subtype5) {
        this.subtype5 = subtype5;
    }

    public Integer getIsRecommend() {
        return isRecommend;
    }

    public void setIsRecommend(Integer isRecommend) {
        this.isRecommend = isRecommend;
    }

    public Integer getIsHot() {
        return isHot;
    }

    public void setIsHot(Integer isHot) {
        this.isHot = isHot;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public GoodItemView(){
	}
 
 	public GoodItemView(GoodItemEntity goodItemEntity){
 	try {
			BeanUtils.copyProperties(this, goodItemEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}

    private List<GoodItemImageEntity> imgList;

    public List <GoodItemImageEntity> getImgList() {
        return imgList;
    }

    public void setImgList(List <GoodItemImageEntity> imgList) {
        this.imgList = imgList;
    }
}
