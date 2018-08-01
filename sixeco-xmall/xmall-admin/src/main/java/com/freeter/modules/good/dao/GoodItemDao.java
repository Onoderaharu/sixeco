package com.freeter.modules.good.dao;

import com.freeter.common.utils.R;
import com.freeter.modules.good.entity.GoodItemEntity;
import com.freeter.modules.good.entity.model.GoodItemModel;
import com.freeter.modules.good.entity.view.GoodItemView;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import com.freeter.modules.good.entity.vo.GoodItemVO;
import org.apache.ibatis.annotations.Param;

/**
 * 
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-07-31 14:46:54
 */
public interface GoodItemDao extends BaseMapper<GoodItemEntity> {
	
	List<GoodItemVO> selectListVO(@Param("ew") Wrapper <GoodItemEntity> wrapper);
	
	GoodItemVO selectVO(@Param("ew") Wrapper <GoodItemEntity> wrapper);
	
	
	List<GoodItemView> selectListView(@Param("ew") Wrapper <GoodItemEntity> wrapper);

	List<GoodItemView> selectListView(Pagination page,
                                      @Param("ew") Wrapper <GoodItemEntity> wrapper);
	
	GoodItemView selectView(@Param("ew") Wrapper <GoodItemEntity> wrapper);

    /**
     * 查询周边商品配置信息
     * @param productItem
     * @return
     */
    List<GoodItemView> getDeploy(GoodItemEntity productItem);

    /**
     * 根据商品id删除配置信息
     * @param productId
     */
    void deleteByProductId(@Param("productId") Integer productId ,
                           @Param("type") String type);

    GoodItemEntity selectByProductIdAndTips(Map<String,Object> map);

    GoodItemEntity findById(@Param("productItemId") Integer productItemId);

    /**
     * 根据商品编号，商品id查询该编号是否和其它商品关联
     * @param productItem
     * @return
     */
    List<GoodItemEntity> checkProductCode(GoodItemModel productItem);

    List<Map<String,Object>> getProductImg(GoodItemView productItem);

    List<GoodItemEntity> getProductItemLv(GoodItemEntity productItem);
}
