package com.freeter.modules.good.dao;

import com.freeter.modules.good.entity.GoodItemImageEntity;
import com.freeter.modules.good.entity.view.GoodItemImageView;
import com.freeter.modules.good.entity.vo.GoodItemImageVO;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;



/**
 * 
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-07-31 15:38:04
 */
public interface GoodItemImageDao extends BaseMapper<GoodItemImageEntity> {
	
	List<GoodItemImageVO> selectListVO(@Param("ew") Wrapper <GoodItemImageEntity> wrapper);
	
	GoodItemImageVO selectVO(@Param("ew") Wrapper <GoodItemImageEntity> wrapper);
	
	
	List<GoodItemImageView> selectListView(@Param("ew") Wrapper <GoodItemImageEntity> wrapper);

	List<GoodItemImageView> selectListView(Pagination page,
                                           @Param("ew") Wrapper <GoodItemImageEntity> wrapper);
	
	GoodItemImageView selectView(@Param("ew") Wrapper <GoodItemImageEntity> wrapper);

    GoodItemImageEntity selectByItemId(GoodItemImageEntity itemImage);
}
