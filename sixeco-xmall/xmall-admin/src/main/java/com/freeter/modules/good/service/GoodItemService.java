package com.freeter.modules.good.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.R;
import com.freeter.modules.good.entity.GoodItemEntity;
import com.freeter.modules.good.entity.view.GoodItemView;
import java.util.List;
import java.util.Map;

import com.freeter.modules.good.entity.vo.GoodItemVO;
import org.apache.ibatis.annotations.Param;


/**
 * 
 *
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-07-31 14:46:54
 */
public interface GoodItemService extends IService<GoodItemEntity> {

    PageUtils queryPage(Map <String, Object> params);
    
   	List<GoodItemVO> selectListVO(Wrapper <GoodItemEntity> wrapper);
   	
   	GoodItemVO selectVO(@Param("ew") Wrapper <GoodItemEntity> wrapper);
   	
   	List<GoodItemView> selectListView(Wrapper <GoodItemEntity> wrapper);
   	
   	GoodItemView selectView(@Param("ew") Wrapper <GoodItemEntity> wrapper);
   	
   	PageUtils queryPage(Map <String, Object> params, Wrapper <GoodItemEntity> wrapper);


    /**
     *查询周边商品配置信息
     * @param productItem
     * @return
     */
    R getAroundDeploy(GoodItemEntity productItem);

    /**
     * 根据周边商品id删除周边配置信息
     * @param productId
     * @return
     */
    R deleteAroundItemByProductId(Integer productId , String productType);

    /**
     * 修改周边配置上下架
     * @param itemId
     * @param itemStatus
     * @return
     */
    R upOrDownItem(Integer itemId, Integer itemStatus);

    /**
     * 删除周边配置信息
     * @param itemId
     * @return
     */
    R deleteAroundItem(Integer itemId);

    //减少库存接口
    R reduceStock(String jsonStr);

    /**
     * 修改周边商品配置
     * @param productItem
     * @return
     */
    R updateAroundItem(String productItem);

    /**
     * 新增周边商品信息
     * @param productItem
     * @return
     */
    R saveAroundItem(String productItem);

    /**
     * 根据周边商品配置信息查询周边商品图片库存等信息
     * @param itemView
     * @return
     */
    R getProductImg(GoodItemView itemView);

    /**
     * 联动查询商品配置信息，
     * @param productId
     * @param itemStr
     * @param type
     * @return
     */
    R getProductLevelType(Integer productId, String itemStr, Integer type);
    
    	/** 获取配置ID */
	List<GoodItemView> listProductItemByCondition(@Param("productId") Integer productId,
			@Param("level1Type") String level1Type, @Param("level2Type") String level2Type,
			@Param("level3Type") String level3Type, @Param("level4Type") String level4Type,
			@Param("level5Type") String level5Type, @Param("level6Type") String level6Type,
			@Param("level7Type") String level7Type, @Param("type") Integer type);
   	
}

