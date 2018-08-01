package com.freeter.modules.good.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.freeter.common.utils.PageUtils;
import java.util.List;
import java.util.Map;

import com.freeter.common.utils.R;
import com.freeter.modules.good.entity.GoodItemImageEntity;
import com.freeter.modules.good.entity.view.GoodItemImageView;
import com.freeter.modules.good.entity.vo.GoodItemImageVO;
import org.apache.ibatis.annotations.Param;


/**
 * 
 *
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-07-31 15:38:04
 */
public interface GoodItemImageService extends IService<GoodItemImageEntity> {

    PageUtils queryPage(Map <String, Object> params);
    
   	List<GoodItemImageVO> selectListVO(Wrapper <GoodItemImageEntity> wrapper);
   	
   	GoodItemImageVO selectVO(@Param("ew") Wrapper <GoodItemImageEntity> wrapper);
   	
   	List<GoodItemImageView> selectListView(Wrapper <GoodItemImageEntity> wrapper);
   	
   	GoodItemImageView selectView(@Param("ew") Wrapper <GoodItemImageEntity> wrapper);
   	
   	PageUtils queryPage(Map <String, Object> params, Wrapper <GoodItemImageEntity> wrapper);

    /**
     * 修改周边商品配置信息
     * @param itemImage
     * @return
     */
    R updateAroundItemImg(String itemImage);
}

