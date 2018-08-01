package com.freeter.modules.good.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.Result;
import com.freeter.modules.good.entity.ShopCarEntity;
import java.util.List;
import java.util.Map;
import com.freeter.modules.good.entity.vo.ShopCarVO;

import org.apache.ibatis.annotations.Param;
import com.freeter.modules.good.entity.view.ShopCarView;


/**
 * 
 *
 * @author YUFEI
 * @date 2018-07-30 14:41:04
 */
@SuppressWarnings("rawtypes")
public interface ShopCarService extends IService<ShopCarEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShopCarVO> selectListVO(Wrapper<ShopCarEntity> wrapper);
   	
   	ShopCarVO selectVO(@Param("ew") Wrapper<ShopCarEntity> wrapper);
   	
   	List<ShopCarView> selectListView(Wrapper<ShopCarEntity> wrapper);
   	
   	ShopCarView selectView(@Param("ew") Wrapper<ShopCarEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShopCarEntity> wrapper);
   	
   	
   	Result delete(Object[] ids);
   	
   	List<ShopCarView> listForPage(Integer userId, Integer page, Integer pageSize);
	
   	List<ShopCarView> list(@Param("proId")Integer userId);
   	
   	List<ShopCarView> getByProId(@Param("proId")Integer proId,@Param("userId")Integer userId,@Param("productItemId")Integer productItemId);
   	
   	ShopCarView selectByProductIdAndUserIdAndItemStr(@Param("productId") Integer productId, 
            @Param("userId") Long userId, 
            @Param("itemStr") String itemStr);
   	
}

