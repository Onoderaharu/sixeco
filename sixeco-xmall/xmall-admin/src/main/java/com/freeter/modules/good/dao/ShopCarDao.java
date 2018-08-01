package com.freeter.modules.good.dao;

import com.freeter.modules.good.entity.ShopCarEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.freeter.modules.good.entity.vo.ShopCarVO;
import com.freeter.modules.good.entity.view.ShopCarView;


/**
 * 
 * 
 * @author YUFEI
 * @date 2018-07-30 14:41:04
 */
@SuppressWarnings("rawtypes")
public interface ShopCarDao extends BaseMapper<ShopCarEntity> {
	
	List<ShopCarVO> selectListVO(@Param("ew") Wrapper<ShopCarEntity> wrapper);
	
	ShopCarVO selectVO(@Param("ew") Wrapper<ShopCarEntity> wrapper);
	
	List<ShopCarView> selectListView(@Param("ew") Wrapper<ShopCarEntity> wrapper);

	List<ShopCarView> selectListView(Pagination page,@Param("ew") Wrapper<ShopCarEntity> wrapper);
	
	ShopCarView selectView(@Param("ew") Wrapper<ShopCarEntity> wrapper);
	
	List<ShopCarView> listForPage(@Param("userId")Integer userId, @Param("page")Integer page, @Param("pageSize")Integer pageSize);
	
	
	@Select("select * from shop_car where user_id = #{userId} order by id desc ")
    List<ShopCarView> list(Integer userId);
    
    @Select("select * from shop_car where product_id = #{proId} and user_id = #{userId} and product_item_id = #{productItemId}")
    List<ShopCarView> getByProId(@Param("proId")Integer proId,@Param("userId")Integer userId,@Param("productItemId")Integer productItemId);
    

    @Select("Select * from shop_car where user_id=#{userId} and product_id = #{productId} and itemStr= #{itemStr}" )
    ShopCarView selectByProductIdAndUserIdAndItemStr(@Param("productId") Integer productId, 
                                                     @Param("userId") Long userId, 
                                                     @Param("itemStr") String itemStr);
	
	
}
