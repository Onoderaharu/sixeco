package com.freeter.modules.pc.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.freeter.common.utils.PageUtils;
import com.freeter.modules.pc.entity.CategoryEntity;
import java.util.List;
import java.util.Map;
import com.freeter.modules.pc.entity.vo.CategoryVO;
import org.apache.ibatis.annotations.Param;
import com.freeter.modules.pc.entity.view.CategoryView;


/**
 * 分类表
 *
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-07-28 16:51:05
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<CategoryVO> selectListVO(Wrapper<CategoryEntity> wrapper);
   	
   	CategoryVO selectVO(@Param("ew") Wrapper<CategoryEntity> wrapper);
   	
   	List<CategoryView> selectListView(Wrapper<CategoryEntity> wrapper);
   	
   	CategoryView selectView(@Param("ew") Wrapper<CategoryEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<CategoryEntity> wrapper);
}

