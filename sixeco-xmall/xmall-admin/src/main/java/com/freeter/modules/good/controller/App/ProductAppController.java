package com.freeter.modules.good.controller.App;

import com.freeter.common.utils.R;
import com.freeter.common.utils.ResultCode;
import com.freeter.modules.good.service.GoodItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author liujun
 * @create 2018-07-31 18:20
 **/
@RestController
@RequestMapping("/api/v2.1/product")
@Api(tags="接口")
public class ProductAppController {
    @Autowired
    private GoodItemService goodItemService;
    
    private static Logger log = LoggerFactory.getLogger(ProductAppController.class);

    @ApiOperation("级联查询周边配置")
    @RequestMapping("/getProductLevelType")
    public R getProductLevelType(Integer productId,String itemStr,Integer type){
        if (productId ==null){
            return R.error("参数丢失");
        }
        log.info("联动查询周边商品配置，参数：productId:[{}],itemStr:[{}],type:[{}]",productId,itemStr,type);
        R result=goodItemService.getProductLevelType(productId,itemStr,type);
        return result;
    }
}
