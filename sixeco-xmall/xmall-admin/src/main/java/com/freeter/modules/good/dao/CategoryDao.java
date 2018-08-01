package com.freeter.modules.good.dao;

import com.freeter.modules.good.entity.CategoryEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.freeter.modules.good.entity.vo.CategoryVO;
import com.freeter.modules.good.entity.view.CategoryView;


/**
 * 分类表
 * 
 * @author YUFEI
 * @date 2018-07-28 17:15:57
 */
@SuppressWarnings("rawtypes")
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
	List<CategoryVO> selectListVO(@Param("ew") Wrapper<CategoryEntity> wrapper);
	
	CategoryVO selectVO(@Param("ew") Wrapper<CategoryEntity> wrapper);
	
	
	List<CategoryView> selectListView(@Param("ew") Wrapper<CategoryEntity> wrapper);

	List<CategoryView> selectListView(Pagination page,@Param("ew") Wrapper<CategoryEntity> wrapper);
	
	CategoryView selectView(@Param("ew") Wrapper<CategoryEntity> wrapper);
	
	List<CategoryView> getCateGoryByIdStr(@Param("parentId") Integer parentId, @Param("level") Integer level,
			@Param("isRecommend") Integer isRecommend, @Param("offSet") Integer offSet,
			@Param("pageSize") Integer pageSize);
}
