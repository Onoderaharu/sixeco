package com.freeter.modules.pc.controller;

import java.util.Arrays;
import java.util.Map;

import com.freeter.common.validator.ValidatorUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;

import com.freeter.modules.pc.entity.CategoryEntity;
import com.freeter.modules.pc.entity.view.CategoryView;

import com.freeter.modules.pc.service.CategoryService;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.R;
import com.freeter.common.utils.MPUtil;



/**
 * 分类表
 * 后端接口
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-07-28 16:51:05
 */
@RestController
@RequestMapping("pc/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 列表
     */
    @RequestMapping("/page")
    @RequiresPermissions("pc:category:list")
    public R page(@RequestParam Map<String, Object> params,CategoryEntity category){
 
        EntityWrapper< CategoryEntity> ew = new EntityWrapper< CategoryEntity>();
      	ew.allEq(MPUtil.allEQMapPre( category, "category")); 
    	PageUtils page = categoryService.queryPage(params, ew);
    
        return R.ok().put("page", page);
        
    }

	/**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("pc:category:list")
    public R list( CategoryEntity category){
       	EntityWrapper<  CategoryEntity> ew = new EntityWrapper<  CategoryEntity>();
      	ew.allEq(MPUtil.allEQMapPre( category, "category")); 
        return R.ok().put("data",  categoryService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    @RequiresPermissions("pc:category:info")
    public R query(CategoryEntity category){
        EntityWrapper< CategoryEntity> ew = new EntityWrapper< CategoryEntity>();
 		ew.allEq(MPUtil.allEQMapPre( category, "category")); 
		CategoryView  categoryView =  categoryService.selectView(ew);
		return R.ok("查询分类表成功").put("data",  categoryView);
    }
	
    /**
     * 信息
     */
    @RequestMapping("/info/{categoryId}")
    @RequiresPermissions("pc:category:info")
    public R info(@PathVariable("categoryId") Long categoryId){
        CategoryEntity category = categoryService.selectById(categoryId);

        return R.ok().put("category", category);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("pc:category:save")
    public R save(@RequestBody CategoryEntity category){
    	ValidatorUtils.validateEntity(category);
        categoryService.insert(category);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("pc:category:update")
    public R update(@RequestBody CategoryEntity category){
        ValidatorUtils.validateEntity(category);
        categoryService.updateAllColumnById(category);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("pc:category:delete")
    public R delete(@RequestBody Long[] categoryIds){
        categoryService.deleteBatchIds(Arrays.asList(categoryIds));

        return R.ok();
    }

}
