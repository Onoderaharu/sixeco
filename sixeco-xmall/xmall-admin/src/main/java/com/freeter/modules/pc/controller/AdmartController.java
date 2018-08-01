package com.freeter.modules.pc.controller;

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
import com.freeter.modules.pc.entity.model.AdmartModel;
import com.freeter.modules.pc.entity.vo.AdmartVO;
import com.freeter.common.utils.MPUtil;


import com.freeter.modules.pc.entity.AdmartEntity;
import com.freeter.modules.pc.service.AdmartService;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;




/**
 * 商户表
 *api接口
 * @author SIXECO
 * @email yqq@sixeco.com
 * @date 2018-07-25 01:07:47
 */
@RestController
@RequestMapping("admart")
@Api(tags="商户表接口")
public class AdmartController {
    @Autowired
    private AdmartService admartService;
 
	 /**
     * 列表
     */
    @GetMapping("/page")
    @ApiOperation("分页查询商户表")
    public R page(@RequestParam Map<String, Object> params,AdmartModel admartModel){
 
        EntityWrapper< AdmartEntity> ew = new EntityWrapper< AdmartEntity>();
        AdmartEntity admart = new  AdmartEntity( admartModel);
     	ew.allEq(MPUtil.allEQMapPre( admart, "admart")); 
    	PageUtils page = admartService.queryPage(params, ew);
        return R.ok().put("data",  page);
        
    }
	
	
	
    /**
     * 查询
     */
    @GetMapping("/list")
    @ApiOperation("查询商户表")
    public R list(AdmartModel admartModel){
		ValidatorUtils.validateEntity(admartModel);
        EntityWrapper< AdmartEntity> ew = new EntityWrapper< AdmartEntity>();
		AdmartEntity admart = new  AdmartEntity( admartModel);
     	ew.allEq(MPUtil.allEQMapPre( admart, "admart")); 
		List<AdmartVO>  admartVOList =  admartService.selectListVO(ew);
		return R.ok("查询商户表成功").put("data", admartVOList);
    }

	 /**
     * 查询
     */
    @GetMapping("/query")
    @ApiOperation("查询商户表")
    public R query(AdmartModel admartModel){
		ValidatorUtils.validateEntity(admartModel);
        EntityWrapper< AdmartEntity> ew = new EntityWrapper< AdmartEntity>();
		AdmartEntity admart = new  AdmartEntity( admartModel);
		ew.allEq(MPUtil.allEQMapPre( admart, "admart")); 
		AdmartVO  admartVO =  admartService.selectVO(ew);
		return R.ok("查询商户表成功").put("data",  admartVO);
    }
	

    /**
     * 信息
     */
    @GetMapping("/info/{martId}")
    @ApiOperation("获取相应的商户表")
    public R info(@PathVariable("martId") Long martId){
        AdmartEntity admart = admartService.selectById(martId);

        return R.ok().put("admart", admart);
    }

    /**
     * 保存
     */
    @PostMapping("/save/json")
    @ApiOperation("添加商户表数据")
    public R saveJson(@RequestBody AdmartEntity admart){
    	ValidatorUtils.validateEntity(admart);
        admartService.insert(admart);
        return R.ok();
    }
    
    /**
     * 保存
     */
    @PostMapping("/save/form")
    @ApiOperation("添加商户表数据 （参数：表单格式）")
    public R saveForm(AdmartEntity admart){
    	ValidatorUtils.validateEntity(admart);
        admartService.insert(admart);

        return R.ok();
    }

    /**
     * 修改（参数：json）
     */
    @PostMapping("/update/json")
    @ApiOperation("修改商户表数据（参数：json格式）")
    public R updateJson(@RequestBody AdmartEntity admart){
        ValidatorUtils.validateEntity(admart);
        admartService.updateAllColumnById(admart);//全部更新
        
        return R.ok();
    }


    /**
     * 修改（参数：传统表单）
     */
    @PostMapping("/update/form")
    @ApiOperation("修改商户表数据（参数：表单格式）")
    public R updateForm(AdmartEntity admart){
        ValidatorUtils.validateEntity(admart);
        admartService.updateAllColumnById(admart);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @ApiOperation("删除商户表数据")
    public R delete(@RequestBody Long[] martIds){
        admartService.deleteBatchIds(Arrays.asList(martIds));
        return R.ok();
    }

}
