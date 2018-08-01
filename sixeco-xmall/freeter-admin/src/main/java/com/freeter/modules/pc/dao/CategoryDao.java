package com.freeter.modules.pc.dao;

import com.freeter.modules.pc.entity.CategoryEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.freeter.modules.pc.entity.vo.CategoryVO;
import com.freeter.modules.pc.entity.view.CategoryView;


/**
 * 分类表
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-07-28 16:51:05
 */
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
	List<CategoryVO> selectListVO(@Param("ew") Wrapper<CategoryEntity> wrapper);
	
	CategoryVO selectVO(@Param("ew") Wrapper<CategoryEntity> wrapper);
	
	
	List<CategoryView> selectListView(@Param("ew") Wrapper<CategoryEntity> wrapper);

	List<CategoryView> selectListView(Pagination page,@Param("ew") Wrapper<CategoryEntity> wrapper);
	
	CategoryView selectView(@Param("ew") Wrapper<CategoryEntity> wrapper);
}
