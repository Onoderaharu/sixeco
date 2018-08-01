package com.freeter.modules.pc.dao;

import com.freeter.modules.pc.entity.GoodItemEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.freeter.modules.pc.entity.vo.GoodItemVO;
import com.freeter.modules.pc.entity.view.GoodItemView;


/**
 * 
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-07-31 14:47:21
 */
public interface GoodItemDao extends BaseMapper<GoodItemEntity> {
	
	List<GoodItemVO> selectListVO(@Param("ew") Wrapper<GoodItemEntity> wrapper);
	
	GoodItemVO selectVO(@Param("ew") Wrapper<GoodItemEntity> wrapper);
	
	
	List<GoodItemView> selectListView(@Param("ew") Wrapper<GoodItemEntity> wrapper);

	List<GoodItemView> selectListView(Pagination page,@Param("ew") Wrapper<GoodItemEntity> wrapper);
	
	GoodItemView selectView(@Param("ew") Wrapper<GoodItemEntity> wrapper);
}
