package com.freeter.modules.good.controller;

import java.util.Arrays;
import java.util.Map;
import java.util.List;

import com.freeter.common.utils.ResultCode;
import com.freeter.common.validator.ValidatorUtils;
import com.freeter.modules.good.entity.GoodItemEntity;
import com.freeter.modules.good.entity.model.GoodItemModel;
import com.freeter.modules.good.entity.view.GoodItemView;
import com.freeter.modules.good.entity.vo.GoodItemVO;
import com.freeter.modules.good.service.GoodItemImageService;
import com.freeter.modules.good.service.GoodItemService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
 * @date 2018-07-31 14:46:54
 */
@RestController
@RequestMapping("/api/v2/productItem")
@Api(tags="接口")
public class GoodItemController {
    @Autowired
    private GoodItemService goodItemService;
    
    @Autowired
    private GoodItemImageService goodItemImageService;
 
    private Logger log=LoggerFactory.getLogger(GoodItemController.class);
    /**
     * 根据商品id查询周边商品配置信息
     *
     * @param productItem
     * @return
     */
    @ApiOperation("根据商品id查询周边商品配置信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "productId" ,value = "产品id" ,dataType = "Integer", required = true),
            @ApiImplicitParam(name = "level1Type" , value = "第一层配置的选择，用来筛选查询" ,dataType = "String"),
            @ApiImplicitParam(name = "level2Type" , value = "第二层配置的选择，用来筛选查询" ,dataType = "String"),
            @ApiImplicitParam(name = "level3Type" , value = "第三层配置的选择，用来筛选查询" ,dataType = "String"),
    })
    @RequestMapping("/getAroundDeploy")
    public R getAroundDeploy( GoodItemEntity productItem ) {
        if ( productItem == null ) {
            return  R.error("参数丢失");
        }
        log.info ( "传入参数productItem[{}]", ToStringBuilder.reflectionToString ( productItem ) );
        R result = goodItemService.getAroundDeploy ( productItem );
        return result;
    }

    /**
     * 根据配置id上下架周边商品配置
     *
     * @param itemId
     * @param itemStatus
     * @return
     */
    @ApiOperation("根据配置id上下架周边商品配置")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "itemId" ,value = "商品配置id" ,dataType = "Integer", required = true),
            @ApiImplicitParam(name = "itemStatus" ,value = "商品上下架状态（0下架1上架）" ,dataType = "Integer", required = true),
    })
    @RequestMapping("/upOrDownItem")
    public R upOrDownItem(Integer itemId, Integer itemStatus) {
        if ( itemId == null || itemStatus == null || ( itemStatus!=0 &&  itemStatus!=1 ) ) {
            return R.error("参数丢失");
        }
        log.info ( "===上下架周边商品配置==itemId[{}],itemStatus[{}]=",itemId,itemStatus );
        return goodItemService.upOrDownItem ( itemId, itemStatus );
    }

    /**
     * 根据配置id删除周边商品配置
     *
     * @param itemId
     * @return
     */
    @ApiOperation("根据配置id删除周边商品配置")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "itemId" ,value = "商品配置id" ,dataType = "Integer", required = true),
    })
    @RequestMapping("/deleteAroundItem")
    public R deleteAroundItem(Integer itemId) {
        if ( itemId == null ) {
            return R.error("参数丢失");
        }
        log.info ( "===删除周边商品配置信息=[{}]==" ,itemId);
        return goodItemService.deleteAroundItem ( itemId );
    }

    /**
     * 根据周边商品编号删除配置信息
     * @param productId
     * @return
     */
    @ApiOperation("根据周边商品编号删除所有配置信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "productId" ,value = "周边商品编号" ,dataType = "Integer", required = true),
            @ApiImplicitParam(name = "type" ,value = "配置类型0整车1周边" ,dataType = "String" ,required = true),
    })
    @RequestMapping("/deleteAroundItemByProductId")
    public R deleteAroundItemByProductId(Integer productId ,String type){
        return goodItemService.deleteAroundItemByProductId(productId ,type);
    }

    /**
     * 减少库存接口
     * @param jsonStr
     * @return
     */
    @ApiOperation("周边商品减少库存接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "jsonStr" ,value = "json串，格式为order转json" ,dataType = "String", required = true),
    })
    @RequestMapping("/reduceStock")
    public R reduceStock(String jsonStr){
        return goodItemService.reduceStock(jsonStr);
    }

    /**
     * 新增、修改周边商品配置图片
     * @param paramsJson
     * @return
     */
    @ApiOperation("新增、修改周边商品配置图片")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "paramsJson" ,value = "周边商品配置的json串" ,dataType = "String", required = true),
    })
    @RequestMapping("/updateAroundItemImg")
    public R updateAroundItemImg(String paramsJson){
        return goodItemImageService.updateAroundItemImg(paramsJson);
    }

    /**
     * 修改周边商品配置信息
     * @param paramsJson
     * @return
     */
    @ApiOperation("修改周边商品配置信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "paramsJson" ,value = "周边商品配置的json串" ,dataType = "String", required = true),
    })
    @RequestMapping("/updateAroundItem")
    public R updateAroundItem(String paramsJson){
        if ( paramsJson == null ) {
            return R.error("参数丢失");
        }
        log.info ( "===updateAroundItem 修改周边商品配置信息paramsJson[{}]===",paramsJson );
        R result = goodItemService.updateAroundItem ( paramsJson );
        return result;
    }

    /**
     * 保存周边商品配置信息
     * @param paramsJson
     * @return
     */
    @ApiOperation("保存周边商品配置信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "paramsJson" ,value = "周边商品配置的json串" ,dataType = "String", required = true),
    })
    @RequestMapping("/saveAroundItem")
    public R saveAroundItem(String paramsJson) {
        if ( paramsJson == null ) {
            return R.error("参数丢失");
        }
        log.info ( "===saveAroundItem保存周边商品配置信息paramsJson[{}]===",paramsJson );
        R result = goodItemService.saveAroundItem ( paramsJson );
        return result;
    }

    /**
     * （远程接口调用）
     * @param itemView
     * @return
     */
    @ApiOperation("查询周边商品图片信息")
    @RequestMapping("/getProductImg")
    public R getProductImg(@RequestBody GoodItemView itemView){
        if ( itemView == null ) {
            return R.error("参数丢失");
        }
        return goodItemService.getProductImg(itemView);
    }

}
