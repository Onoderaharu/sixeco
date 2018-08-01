package com.freeter.modules.good.controller;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.freeter.modules.good.entity.GoodItemEntity;
import com.freeter.modules.good.entity.view.GoodItemView;
import com.freeter.modules.good.service.GoodItemService;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.freeter.common.utils.Constant;
import com.freeter.common.utils.JSONUtils;
import com.freeter.common.utils.MPUtil;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.R;
import com.freeter.common.utils.Result;
import com.freeter.common.utils.ResultCode;
import com.freeter.common.validator.ValidatorUtils;
import com.freeter.modules.good.entity.GoodEntity;
import com.freeter.modules.good.entity.ShopCarEntity;
import com.freeter.modules.good.entity.model.ShopCarModel;
import com.freeter.modules.good.entity.view.GoodView;
import com.freeter.modules.good.entity.view.ShopCarView;
import com.freeter.modules.good.entity.vo.ShopCarVO;
import com.freeter.modules.good.service.GoodService;
import com.freeter.modules.good.service.ShopCarService;

import freemarker.core.ParseException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * api接口
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-07-30 14:41:04
 */
@RestController
@RequestMapping("shopcar")
@Api(tags = "接口")
public class ShopCarController {

	Logger log = LoggerFactory.getLogger(ShopCarController.class);

	@Autowired
	private ShopCarService shopCarService;

	@Autowired
	private GoodService goodService;

	@Autowired
	private GoodItemService productItemService;

	/**
	 * 列表
	 */
	@GetMapping("/page")
	@ApiOperation("分页查询")
	public R page(@RequestParam Map<String, Object> params, ShopCarModel shopCarModel) {

		EntityWrapper<ShopCarEntity> ew = new EntityWrapper<ShopCarEntity>();
		ShopCarEntity shopCar = new ShopCarEntity(shopCarModel);
		ew.allEq(MPUtil.allEQMapPre(shopCar, "shopCar"));
		PageUtils page = shopCarService.queryPage(params, ew);
		return R.ok().put("data", page.getList());

	}

	/**
	 * 查询
	 */
	@GetMapping("/list")
	@ApiOperation("查询")
	public R list(ShopCarModel shopCarModel) {
		ValidatorUtils.validateEntity(shopCarModel);
		EntityWrapper<ShopCarEntity> ew = new EntityWrapper<ShopCarEntity>();
		ShopCarEntity shopCar = new ShopCarEntity(shopCarModel);
		ew.allEq(MPUtil.allEQMapPre(shopCar, "shopCar"));
		List<ShopCarVO> shopCarVOList = shopCarService.selectListVO(ew);
		return R.ok("查询成功").put("data", shopCarVOList);
	}

	/**
	 * 查询
	 */
	@GetMapping("/query")
	@ApiOperation("查询")
	public R query(ShopCarModel shopCarModel) {
		ValidatorUtils.validateEntity(shopCarModel);
		EntityWrapper<ShopCarEntity> ew = new EntityWrapper<ShopCarEntity>();
		ShopCarEntity shopCar = new ShopCarEntity(shopCarModel);
		ew.allEq(MPUtil.allEQMapPre(shopCar, "shopCar"));
		ShopCarVO shopCarVO = shopCarService.selectVO(ew);
		return R.ok("查询成功").put("data", shopCarVO);
	}

	/**
	 * 信息
	 */
	@GetMapping("/info/{id}")
	@ApiOperation("获取相应的")
	public R info(@PathVariable("id") Integer id) {
		ShopCarEntity shopCar = shopCarService.selectById(id);

		return R.ok().put("shopCar", shopCar);
	}

	/**
	 * 保存
	 */
	@PostMapping("/save/json")
	@ApiOperation("添加数据")
	public R saveJson(@RequestBody ShopCarEntity shopCar) {
		ValidatorUtils.validateEntity(shopCar);
		shopCarService.insert(shopCar);
		return R.ok();
	}

	/**
	 * 保存
	 */
	@PostMapping("/save/form")
	@ApiOperation("添加数据 （参数：表单格式）")
	public R saveForm(ShopCarEntity shopCar) {
		ValidatorUtils.validateEntity(shopCar);
		shopCarService.insert(shopCar);

		return R.ok();
	}

	/**
	 * 修改（参数：json）
	 */
	@PostMapping("/update/json")
	@ApiOperation("修改数据（参数：json格式）")
	public R updateJson(@RequestBody ShopCarEntity shopCar) {
		ValidatorUtils.validateEntity(shopCar);
		shopCarService.updateAllColumnById(shopCar);// 全部更新

		return R.ok();
	}

	/**
	 * 修改（参数：传统表单）
	 */
	@PostMapping("/update/form")
	@ApiOperation("修改数据（参数：表单格式）")
	public R updateForm(ShopCarEntity shopCar) {
		ValidatorUtils.validateEntity(shopCar);
		shopCarService.updateAllColumnById(shopCar);// 全部更新

		return R.ok();
	}

	/**
	 * 删除
	 */
	@PostMapping("/deleteByIds")
	@ApiOperation("删除数据")
	public R deleteByIds(@RequestBody Integer[] ids) {
		shopCarService.deleteBatchIds(Arrays.asList(ids));
		return R.ok();
	}

	/**
	 * 需求变更：产品ID、配置ID区分
	 * 
	 * @param productId
	 * @param quantity
	 * @param userId
	 * @param itemStr
	 * @return
	 * @throws ParseException
	 * @throws java.text.ParseException
	 */
	@ApiOperation("加入购物车")
	@ApiImplicitParams({ @ApiImplicitParam(name = "productId", value = "产品ID", dataType = "Integer", required = true),
			@ApiImplicitParam(name = "quantity", value = "数量", dataType = "Integer", required = true),
			@ApiImplicitParam(name = "userId", value = "用户ID", dataType = "Integer", required = true),
			@ApiImplicitParam(name = "itemStr", value = "配置信息json字符串", dataType = "String"), })
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Result add(Integer productId, Integer quantity, Integer userId, String itemStr)
			throws ParseException, java.text.ParseException {

		if (productId == null || quantity == null || userId == null || itemStr == null) {
			return new Result(ResultCode.S_PARAM_EMPTY);
		} else {
			log.info("添加购物车参数：productId={},quantity={},userId={},itemStr={}", productId, quantity, userId, itemStr);
		}

		/**
		 * 根据itemStr 配置信息，获取product_item_id 根据配置信息，获取对应价格
		 */
		Integer productItemId = null;
		BigDecimal price = new BigDecimal("0");
		StringBuffer itemString = new StringBuffer("");
		Result result = new Result();

		GoodEntity goodEntity = goodService.selectById(productId);
		if (goodEntity == null) {
			log.info("加入购物车失败：productId={}商品为空", productId);
			return new Result(ResultCode.S_DATA_NOT_EXIST);
		}

		GoodItemEntity productItemEntity = new GoodItemEntity();
		String tip1 = goodEntity.getTip1();
		String tip2 = goodEntity.getTip2();
		String tip3 = goodEntity.getTip3();
		String tip4 = goodEntity.getTip4();

		productItemEntity.setProductId(productId);

		String tip1Value = null, tip2Value = null, tip3Value = null, tip4Value = null;
		if (StringUtils.isNotBlank(itemStr)) {
			// 配置信息json字符
			Map<String, Object> itemMap = JSONUtils.jsonToMap(itemStr);

			if (itemMap != null) {
				if (StringUtils.isNotBlank(tip1) && !Constant.COMMON_NULL.equals(tip1)) {
					tip1Value = String.valueOf(itemMap.get(tip1));
					if (itemMap.containsKey(tip1)) {
						if (tip1Value != null && !Constant.COMMON_NULL.equals(String.valueOf(tip1Value))) {
							itemString.append(tip1Value).append(" ");
							productItemEntity.setLevel1Type(tip1Value);
						} else {
							tip1Value = null;
						}
					}
				}
				if (StringUtils.isNotBlank(tip2) && !Constant.COMMON_NULL.equals(tip2)) {
					tip2Value = String.valueOf(itemMap.get(tip2));
					if (itemMap.containsKey(tip2)) {
						if (tip2Value != null && !Constant.COMMON_NULL.equals(String.valueOf(tip2Value))) {
							itemString.append(tip2Value).append(" ");
							productItemEntity.setLevel2Type(tip2Value);
						} else {
							tip2Value = null;
						}
					}
				}
				if (StringUtils.isNotBlank(tip3) && !Constant.COMMON_NULL.equals(tip3)) {
					tip3Value = String.valueOf(itemMap.get(tip3));
					if (itemMap.containsKey(tip3)) {
						if (tip3Value != null && !Constant.COMMON_NULL.equals(String.valueOf(tip3Value))) {
							itemString.append(tip3Value).append(" ");
							productItemEntity.setLevel3Type(tip3Value);
						} else {
							tip3Value = null;
						}
					}
				}
				if (StringUtils.isNotBlank(tip4) && !Constant.COMMON_NULL.equals(tip4)) {
					tip4Value = String.valueOf(itemMap.get(tip4));
					if (itemMap.containsKey(tip4)) {
						if (tip4Value != null && !Constant.COMMON_NULL.equals(String.valueOf(tip4Value))) {
							itemString.append(tip4Value).append(" ");
							productItemEntity.setLevel4Type(tip4Value);
						} else {
							tip4Value = null;
						}
					}
				}

			}
		}

		// 根据解析的itemStr 获取productItemId
		List<GoodItemView> productItemList = productItemService.listProductItemByCondition(productId, tip1Value,
				tip2Value, tip3Value, tip4Value, null, null, null, Constant.COMMON_YES);
		if (productItemList == null || productItemList.size() < 1) {
			// 获取默认配置ID
			productItemList = productItemService.listProductItemByCondition(productId, null, null, null, null, null,
					null, null, Constant.COMMON_YES);
		}

		if (productItemList != null && productItemList.size() > 0) {
			GoodItemView proItem = productItemList.get(0);
			itemString = new StringBuffer();
			itemString.append(proItem.getLevel1Type()).append(proItem.getLevel2Type()).append(proItem.getLevel3Type())
					.append(proItem.getLevel4Type());
			productItemId = proItem.getProductItemId();
			if (proItem.getPrice() == null || proItem.getPrice() == 0) {
				price = goodEntity.getDefaultPrice();
			} else {
				price = new BigDecimal(proItem.getPrice());
			}
			log.info("通过 itemStr 解析获取到的 productItemId={},price={}", productItemId, price);
		}

		// 切换配置，价格重新获取,根据配置，获取最新价格
		/*
		 * List<Map<String,Object>> proMapList =
		 * productItemService.getProductImg(productItem); if(proMapList != null &&
		 * !proMapList.isEmpty() && proMapList.size() > 0) { Map<String,Object> imgMap =
		 * proMapList.get(0); String priceStr = String.valueOf(imgMap.get("price"));
		 * price = StringUtils.isNotBlank(priceStr) ?
		 * Double.valueOf(String.valueOf(imgMap.get("price"))) : new Double(""); }
		 */

		// 防止手动输入负数
		quantity = quantity < 0 ? 0 : quantity;
		List<ShopCarView> shopCarList = shopCarService.getByProId(productId, userId, productItemId);

		ShopCarEntity shopCar = null;
		if (!shopCarList.isEmpty() && shopCarList.size() > 0) {
			shopCar = shopCarList.get(0);
			// 已有数据，数量更新
			if (shopCar != null) {
				shopCar.setQuantity(shopCar.getQuantity() + quantity);
				shopCar.setCreateTime(this.getTime());
				// 判断price是否为0
				if (price.intValue() == 0) {
					price = goodEntity.getDefaultPrice();
				}
				shopCar.setTip1(productItemEntity.getLevel1Type());
				shopCar.setTip2(productItemEntity.getLevel2Type());
				shopCar.setTip3(productItemEntity.getLevel3Type());
				shopCar.setTip4(productItemEntity.getLevel4Type());
				shopCar.setPrice(price.doubleValue());
				shopCar.setItemStr(itemString.toString().replace("null", "").replace("NULL", ""));
				shopCar.setCreateTime(getTime());
				boolean isOk = shopCarService.update(shopCar, null);
				// Result st = shopCarService.updateByPrimaryKeySelective(shopCar);
				if (isOk) {
					return new Result(shopCar);
				} else {
					return new Result(ResultCode.S_DATA_NOT_EXIST);
				}
			}
		} else {
			// 没有数据，新增
			shopCar = new ShopCarEntity<>();
			shopCar.setUserId(userId);
			shopCar.setProductId(productId);
			shopCar.setProductItemId(productItemId);
			// 判断price是否为0
			if (price.intValue() == 0) {
				price = goodEntity.getDefaultPrice();
			}
			shopCar.setTip1(productItemEntity.getLevel1Type());
			shopCar.setTip2(productItemEntity.getLevel2Type());
			shopCar.setTip3(productItemEntity.getLevel3Type());
			shopCar.setTip4(productItemEntity.getLevel4Type());
			shopCar.setPrice(price.doubleValue());
			shopCar.setQuantity(quantity);
			shopCar.setItemStr(itemString.toString().replace("null", "").replace("NULL", ""));
			shopCar.setCreateTime(this.getTime());
			boolean isOk = shopCarService.insert(shopCar);
			if (isOk) {
				log.info("用户 userId={} 添加购物车成功", userId);
			}
		}

		return result;
	}

	private Date getTime() throws ParseException, java.text.ParseException {
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(System.currentTimeMillis());
		java.util.Date d = c.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss ");
		return sdf.parse(sdf.format(d));
	}

	@ApiOperation("获取购物车列表")
	@ApiImplicitParams({ @ApiImplicitParam(name = "userId", value = "用户ID", dataType = "Integer", required = true), })
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public Result list(Integer userId, Integer page, Integer pageSize)
			throws IllegalAccessException, InvocationTargetException {

		if (userId == null) {
			return new Result(ResultCode.S_PARAM_EMPTY);
		}

		page = page != null ? page : 0;
		pageSize = pageSize != null ? pageSize : 10;

		ShopCarView shopCar = new ShopCarView();
		List<Long> ids = new ArrayList<Long>();
		List<ShopCarView> list = shopCarService.listForPage(userId, page, pageSize);
		List<ShopCarVO> dtoList = new ArrayList<ShopCarVO>();
		ShopCarVO dtos = null;
		if (!list.isEmpty() && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				shopCar = list.get(i);
				dtos = new ShopCarVO();
				ids.add(Long.valueOf(shopCar.getProductId()));
				BeanUtils.copyProperties(shopCar, dtos);
				dtos.setIntro(shopCar.getItemStr());
				dtos.setItemStr(shopCar.getItemStr());
				// 查询库存信息
				GoodItemEntity productItem = productItemService.selectById(shopCar.getProductItemId());
				if (productItem != null) {
					dtos.setInventory(productItem.getInventory());
				}
				dtoList.add(dtos);
			}
		}

		List<GoodView> goodList = goodService.getByIds(ids, page, pageSize);
		if (goodList != null && goodList.size() > 0 && goodList != null && dtoList.size() > 0) {
			for (GoodView goodView : goodList) {
				for (ShopCarVO pro : dtoList) {
					if (goodView.getGoodId().equals(pro.getProductId())) {
						// 封面图
						pro.setImageUrl(goodView.getPicImg());
						// 名称
						pro.setProductName(goodView.getGoodName());
						pro.setAllowBuy(goodView.getAllowBuyFlag());
						// 提货信息
						pro.setPickType(goodView.getPickType() != null ? goodView.getPickType().toString() : "");
					}
				}
			}
		}

		return new Result(dtoList);
	}

	@ApiOperation("批量删除购物车")
	@ApiImplicitParams({ @ApiImplicitParam(name = "ids", value = "购物车ID", dataType = "String", required = true), })
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public Result delete(String ids) {

		if (ids == null) {
			return new Result(ResultCode.S_PARAM_EMPTY);
		} else {
			// ids = ids.replace("\\n", "").replaceAll("\\", "").trim();
		}

		JSONArray json = JSONArray.parseArray(ids);
		Integer[] idList = (Integer[]) json.toArray();
		if (idList != null && idList.length > 0) {
			deleteByIds(idList);
			// shopCarService.delete(idList);
		}
		return new Result(ResultCode.S_PARAM_ERROR);

	}

	@ApiOperation("购物车数量变更")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "购物车ID", dataType = "Integer", required = true),
			@ApiImplicitParam(name = "quantity", value = "购物车数量", dataType = "Integer", required = true), })
	@RequestMapping(value = "/updateNum", method = RequestMethod.POST)
	public Result updateNum(Integer id, Integer quantity) {

		if (id == null || quantity == null) {
			return new Result(ResultCode.S_PARAM_EMPTY);
		}

		ShopCarEntity shopCar = new ShopCarEntity();
		shopCar.setId(id);
		// 防止手动输入负数
		quantity = quantity < 0 ? 0 : quantity;
		shopCar.setQuantity(quantity);
		boolean isOk = shopCarService.update(shopCar, null);
		if (isOk) {
			shopCar = shopCarService.selectById(id);
			return new Result(shopCar);
		} else {
			return new Result(ResultCode.S_PARAM_ERROR);
		}

	}

}
