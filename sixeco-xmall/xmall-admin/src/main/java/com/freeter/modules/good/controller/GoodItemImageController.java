package com.freeter.modules.good.controller;

import java.util.Arrays;
import java.util.Map;
import java.util.List;

import com.freeter.common.validator.ValidatorUtils;
import com.freeter.modules.good.entity.GoodItemImageEntity;
import com.freeter.modules.good.entity.model.GoodItemImageModel;
import com.freeter.modules.good.entity.vo.GoodItemImageVO;
import com.freeter.modules.good.service.GoodItemImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.freeter.common.utils.MPUtil;

import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;




/**
 * 
 *api接口
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-07-31 15:45:52
 */
@RestController
@RequestMapping("gooditemimage")
@Api(tags="接口")
public class GoodItemImageController {
    @Autowired
    private GoodItemImageService goodItemImageService;
 
	 /**
     * 列表
     */
    @GetMapping("/page")
    @ApiOperation("分页查询")
    public R page(@RequestParam Map<String, Object> params,GoodItemImageModel goodItemImageModel){
 
        EntityWrapper<GoodItemImageEntity> ew = new EntityWrapper< GoodItemImageEntity>();
        GoodItemImageEntity goodItemImage = new  GoodItemImageEntity( goodItemImageModel);
     	ew.allEq(MPUtil.allEQMapPre( goodItemImage, "goodItemImage")); 
    	PageUtils page = goodItemImageService.queryPage(params, ew);
        return R.ok().put("data",  page.getList());
        
    }
	
	
	
    /**
     * 查询
     */
    @GetMapping("/list")
    @ApiOperation("查询")
    public R list(GoodItemImageModel goodItemImageModel){
		ValidatorUtils.validateEntity(goodItemImageModel);
        EntityWrapper< GoodItemImageEntity> ew = new EntityWrapper< GoodItemImageEntity>();
		GoodItemImageEntity goodItemImage = new  GoodItemImageEntity( goodItemImageModel);
     	ew.allEq(MPUtil.allEQMapPre( goodItemImage, "goodItemImage")); 
		List<GoodItemImageVO>  goodItemImageVOList =  goodItemImageService.selectListVO(ew);
		return R.ok("查询成功").put("data", goodItemImageVOList);
    }

	 /**
     * 查询
     */
    @GetMapping("/query")
    @ApiOperation("查询")
    public R query(GoodItemImageModel goodItemImageModel){
		ValidatorUtils.validateEntity(goodItemImageModel);
        EntityWrapper< GoodItemImageEntity> ew = new EntityWrapper< GoodItemImageEntity>();
		GoodItemImageEntity goodItemImage = new  GoodItemImageEntity( goodItemImageModel);
		ew.allEq(MPUtil.allEQMapPre( goodItemImage, "goodItemImage")); 
		GoodItemImageVO  goodItemImageVO =  goodItemImageService.selectVO(ew);
		return R.ok("查询成功").put("data",  goodItemImageVO);
    }
	

    /**
     * 信息
     */
    @GetMapping("/info/{productItemImageId}")
    @ApiOperation("获取相应的")
    public R info(@PathVariable("productItemImageId") Integer productItemImageId){
        GoodItemImageEntity goodItemImage = goodItemImageService.selectById(productItemImageId);

        return R.ok().put("goodItemImage", goodItemImage);
    }

    /**
     * 保存
     */
    @PostMapping("/save/json")
    @ApiOperation("添加数据")
    public R saveJson(@RequestBody GoodItemImageEntity goodItemImage){
    	ValidatorUtils.validateEntity(goodItemImage);
        goodItemImageService.insert(goodItemImage);
        return R.ok();
    }
    
    /**
     * 保存
     */
    @PostMapping("/save/form")
    @ApiOperation("添加数据 （参数：表单格式）")
    public R saveForm(GoodItemImageEntity goodItemImage){
    	ValidatorUtils.validateEntity(goodItemImage);
        goodItemImageService.insert(goodItemImage);

        return R.ok();
    }

    /**
     * 修改（参数：json）
     */
    @PostMapping("/update/json")
    @ApiOperation("修改数据（参数：json格式）")
    public R updateJson(@RequestBody GoodItemImageEntity goodItemImage){
        ValidatorUtils.validateEntity(goodItemImage);
        goodItemImageService.updateAllColumnById(goodItemImage);//全部更新
        
        return R.ok();
    }


    /**
     * 修改（参数：传统表单）
     */
    @PostMapping("/update/form")
    @ApiOperation("修改数据（参数：表单格式）")
    public R updateForm(GoodItemImageEntity goodItemImage){
        ValidatorUtils.validateEntity(goodItemImage);
        goodItemImageService.updateAllColumnById(goodItemImage);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @ApiOperation("删除数据")
    public R delete(@RequestBody Integer[] productItemImageIds){
        goodItemImageService.deleteBatchIds(Arrays.asList(productItemImageIds));
        return R.ok();
    }

}
