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
import com.freeter.modules.pc.entity.model.ReceiverModel;
import com.freeter.modules.pc.entity.vo.ReceiverVO;
import com.freeter.common.utils.MPUtil;


import com.freeter.modules.pc.entity.ReceiverEntity;
import com.freeter.modules.pc.service.ReceiverService;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;




/**
 * 
 *api接口
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-08-01 09:37:48
 */
@RestController
@RequestMapping("pc/receiver")
@Api(tags="接口")
public class ReceiverController {
    @Autowired
    private ReceiverService receiverService;
 
	 /**
     * 列表
     */
    @GetMapping("/page")
    @ApiOperation("分页查询")
    public R page(@RequestParam Map<String, Object> params,ReceiverModel receiverModel){
 
        EntityWrapper< ReceiverEntity> ew = new EntityWrapper< ReceiverEntity>();
        ReceiverEntity receiver = new  ReceiverEntity( receiverModel);
     	ew.allEq(MPUtil.allEQMapPre( receiver, "receiver")); 
    	PageUtils page = receiverService.queryPage(params, ew);
        return R.ok().put("data",  page.getList());
        
    }
	
	
	
    /**
     * 查询
     */
    @GetMapping("/list")
    @ApiOperation("查询")
    public R list(ReceiverModel receiverModel){
		ValidatorUtils.validateEntity(receiverModel);
        EntityWrapper< ReceiverEntity> ew = new EntityWrapper< ReceiverEntity>();
		ReceiverEntity receiver = new  ReceiverEntity( receiverModel);
     	ew.allEq(MPUtil.allEQMapPre( receiver, "receiver")); 
		List<ReceiverVO>  receiverVOList =  receiverService.selectListVO(ew);
		return R.ok("查询成功").put("data", receiverVOList);
    }

	 /**
     * 查询
     */
    @GetMapping("/query")
    @ApiOperation("查询")
    public R query(ReceiverModel receiverModel){
		ValidatorUtils.validateEntity(receiverModel);
        EntityWrapper< ReceiverEntity> ew = new EntityWrapper< ReceiverEntity>();
		ReceiverEntity receiver = new  ReceiverEntity( receiverModel);
		ew.allEq(MPUtil.allEQMapPre( receiver, "receiver")); 
		ReceiverVO  receiverVO =  receiverService.selectVO(ew);
		return R.ok("查询成功").put("data",  receiverVO);
    }
	

    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @ApiOperation("获取相应的")
    public R info(@PathVariable("id") Integer id){
        ReceiverEntity receiver = receiverService.selectById(id);

        return R.ok().put("receiver", receiver);
    }

    /**
     * 保存
     */
    @PostMapping("/save/json")
    @ApiOperation("添加数据")
    public R saveJson(@RequestBody ReceiverEntity receiver){
    	ValidatorUtils.validateEntity(receiver);
        receiverService.insert(receiver);
        return R.ok();
    }
    
    /**
     * 保存
     */
    @PostMapping("/save/form")
    @ApiOperation("添加数据 （参数：表单格式）")
    public R saveForm(ReceiverEntity receiver){
    	ValidatorUtils.validateEntity(receiver);
        receiverService.insert(receiver);

        return R.ok();
    }

    /**
     * 修改（参数：json）
     */
    @PostMapping("/update/json")
    @ApiOperation("修改数据（参数：json格式）")
    public R updateJson(@RequestBody ReceiverEntity receiver){
        ValidatorUtils.validateEntity(receiver);
        receiverService.updateAllColumnById(receiver);//全部更新
        
        return R.ok();
    }


    /**
     * 修改（参数：传统表单）
     */
    @PostMapping("/update/form")
    @ApiOperation("修改数据（参数：表单格式）")
    public R updateForm(ReceiverEntity receiver){
        ValidatorUtils.validateEntity(receiver);
        receiverService.updateAllColumnById(receiver);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @ApiOperation("删除数据")
    public R delete(@RequestBody Integer[] ids){
        receiverService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

}
