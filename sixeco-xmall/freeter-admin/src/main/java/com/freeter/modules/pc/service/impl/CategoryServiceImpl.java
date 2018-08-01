package com.freeter.modules.pc.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.Query;

import com.freeter.modules.pc.dao.CategoryDao;
import com.freeter.modules.pc.entity.CategoryEntity;
import com.freeter.modules.pc.service.CategoryService;
import com.freeter.modules.pc.entity.vo.CategoryVO;
import com.freeter.modules.pc.entity.view.CategoryView;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CategoryEntity> page = this.selectPage(
                new Query<CategoryEntity>(params).getPage(),
                new EntityWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<CategoryEntity> wrapper) {
		  Page<CategoryView> page =new Query<CategoryView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;

 	}
    
    @Override
	public List<CategoryVO> selectListVO( Wrapper<CategoryEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public CategoryVO selectVO( Wrapper<CategoryEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<CategoryView> selectListView(Wrapper<CategoryEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public CategoryView selectView(Wrapper<CategoryEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
