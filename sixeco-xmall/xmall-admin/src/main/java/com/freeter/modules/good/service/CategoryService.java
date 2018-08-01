package com.freeter.modules.good.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.freeter.common.utils.PageUtils;
import com.freeter.modules.good.entity.CategoryEntity;
import java.util.List;
import java.util.Map;
import com.freeter.modules.good.entity.vo.CategoryVO;
import org.apache.ibatis.annotations.Param;
import com.freeter.modules.good.entity.view.CategoryView;


/**
 * 分类表
 *
 * @author YUFEI
 * @date 2018-07-28 17:15:57
 */
@SuppressWarnings("rawtypes")
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<CategoryVO> selectListVO(Wrapper<CategoryEntity> wrapper);
   	
   	CategoryVO selectVO(@Param("ew") Wrapper<CategoryEntity> wrapper);
   	
   	List<CategoryView> selectListView(Wrapper<CategoryEntity> wrapper);
   	
   	CategoryView selectView(@Param("ew") Wrapper<CategoryEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<CategoryEntity> wrapper);
   	
   	List<CategoryView> getCateGoryByIdStr(@Param("parentId") Integer parentId, @Param("level") Integer level,
			@Param("isRecommend") Integer isRecommend, @Param("offSet") Integer offSet,
			@Param("pageSize") Integer pageSize);
}

