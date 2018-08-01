package com.freeter.modules.area.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.List;
import com.freeter.common.validator.ValidatorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.freeter.modules.area.entity.model.CityModel;
import com.freeter.modules.area.entity.vo.CityVO;
import com.freeter.common.utils.MPUtil;
import com.freeter.modules.area.entity.CityEntity;
import com.freeter.modules.area.service.CityService;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 城市表
 * api接口
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-07-30 11:56:26
 */
@RestController
@RequestMapping("city")
@Api(tags="城市表接口")
public class CityController {
    @Autowired
    private CityService cityService;
 
	 /**
     * 列表
     */
    @GetMapping("/page")
    @ApiOperation("分页查询城市表")
    public R page(@RequestParam Map<String, Object> params,CityModel cityModel){
        EntityWrapper< CityEntity> ew = new EntityWrapper< CityEntity>();
        CityEntity city = new  CityEntity( cityModel);
     	ew.allEq(MPUtil.allEQMapPre( city, "city")); 
    	PageUtils page = cityService.queryPage(params, ew);
        return R.ok().put("data",  page);
        
    }
	
    /**
     * 查询
     */
    @GetMapping("/list")
    @ApiOperation("查询城市列表")
    public R list(CityModel cityModel){
		ValidatorUtils.validateEntity(cityModel);
        EntityWrapper< CityEntity> ew = new EntityWrapper< CityEntity>();
		CityEntity city = new  CityEntity( cityModel);
     	ew.allEq(MPUtil.allEQMapPre( city, "city")); 
		List<CityVO>  cityVOList =  cityService.selectListVO(ew);
		return R.ok("查询城市表成功").put("data", cityVOList);
    }

	 /**
     * 查询
     */
    @GetMapping("/query")
    @ApiOperation("查询城市表")
    public R query(CityModel cityModel){
		ValidatorUtils.validateEntity(cityModel);
        EntityWrapper< CityEntity> ew = new EntityWrapper< CityEntity>();
		CityEntity city = new  CityEntity( cityModel);
		ew.allEq(MPUtil.allEQMapPre( city, "city")); 
		CityVO  cityVO =  cityService.selectVO(ew);
		return R.ok("查询城市表成功").put("data",  cityVO);
    }
	

    /**
     * 信息
     */
    @GetMapping("/info/{cityId}")
    @ApiOperation("获取相应的城市表")
    public R info(@PathVariable("cityId") Integer cityId){
        CityEntity city = cityService.selectById(cityId);

        return R.ok().put("city", city);
    }
   
    /**
     * 信息
     */
    @GetMapping("/cityInfo/{provinceId}")
    @ApiOperation("根据省份ID查询城市列表")
    public R getProvInfo(@PathVariable("provinceId") Integer provinceId){
        List<CityEntity> city = cityService.selectList(provinceId);
        return R.ok().put("city", city);
    }
    
    
    /**
     * 保存
     */
    @PostMapping("/save/json")
    @ApiOperation("添加城市表数据")
    public R saveJson(@RequestBody CityEntity city){
    	ValidatorUtils.validateEntity(city);
        cityService.insert(city);
        return R.ok();
    }
    
    /**
     * 保存
     */
    @PostMapping("/save/form")
    @ApiOperation("添加城市表数据 （参数：表单格式）")
    public R saveForm(CityEntity city){
    	ValidatorUtils.validateEntity(city);
        cityService.insert(city);

        return R.ok();
    }

    /**
     * 修改（参数：json）
     */
    @PostMapping("/update/json")
    @ApiOperation("修改城市表数据（参数：json格式）")
    public R updateJson(@RequestBody CityEntity city){
        ValidatorUtils.validateEntity(city);
        cityService.updateAllColumnById(city);//全部更新
        
        return R.ok();
    }


    /**
     * 修改（参数：传统表单）
     */
    @PostMapping("/update/form")
    @ApiOperation("修改城市表数据（参数：表单格式）")
    public R updateForm(CityEntity city){
        ValidatorUtils.validateEntity(city);
        cityService.updateAllColumnById(city);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @ApiOperation("删除城市表数据")
    public R delete(@RequestBody Integer[] cityIds){
        cityService.deleteBatchIds(Arrays.asList(cityIds));
        return R.ok();
    }

}
