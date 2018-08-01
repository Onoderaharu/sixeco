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

import com.freeter.modules.pc.entity.GoodItemEntity;
import com.freeter.modules.pc.entity.view.GoodItemView;

import com.freeter.modules.pc.service.GoodItemService;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.R;
import com.freeter.common.utils.MPUtil;



/**
 * 
 * 后端接口
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-07-31 14:47:21
 */
@RestController
@RequestMapping("pc/gooditem")
public class GoodItemController {
    @Autowired
    private GoodItemService goodItemService;

    /**
     * 列表
     */
    @RequestMapping("/page")
    @RequiresPermissions("pc:gooditem:list")
    public R page(@RequestParam Map<String, Object> params,GoodItemEntity goodItem){
 
        EntityWrapper< GoodItemEntity> ew = new EntityWrapper< GoodItemEntity>();
      	ew.allEq(MPUtil.allEQMapPre( goodItem, "goodItem")); 
    	PageUtils page = goodItemService.queryPage(params, ew);
    
        return R.ok().put("page", page);
        
    }

	/**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("pc:gooditem:list")
    public R list( GoodItemEntity goodItem){
       	EntityWrapper<  GoodItemEntity> ew = new EntityWrapper<  GoodItemEntity>();
      	ew.allEq(MPUtil.allEQMapPre( goodItem, "goodItem")); 
        return R.ok().put("data",  goodItemService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    @RequiresPermissions("pc:gooditem:info")
    public R query(GoodItemEntity goodItem){
        EntityWrapper< GoodItemEntity> ew = new EntityWrapper< GoodItemEntity>();
 		ew.allEq(MPUtil.allEQMapPre( goodItem, "goodItem")); 
		GoodItemView  goodItemView =  goodItemService.selectView(ew);
		return R.ok("查询成功").put("data",  goodItemView);
    }
	
    /**
     * 信息
     */
    @RequestMapping("/info/{productIte}")
    @RequiresPermissions("pc:gooditem:info")
    public R info(@PathVariable("productItemId) Integer productIte){
        GoodItemEntity goodItem = goodItemService.selectById(productIte);

        return R.ok().put("goodItem", goodItem);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("pc:gooditem:save")
    public R save(@RequestBody GoodItemEntity goodItem){
    	ValidatorUtils.validateEntity(goodItem);
        goodItemService.insert(goodItem);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("pc:gooditem:update")
    public R update(@RequestBody GoodItemEntity goodItem){
        ValidatorUtils.validateEntity(goodItem);
        goodItemService.updateAllColumnById(goodItem);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("pc:gooditem:delete")
    public R delete(@RequestBody Integer[] productItes){
        goodItemService.deleteBatchIds(Arrays.asList(productItes));

        return R.ok();
    }

}
