package com.freeter.modules.pc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.freeter.common.utils.Constant;
import com.freeter.common.utils.DateUtils;
import com.freeter.common.utils.MPUtil;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.R;
import com.freeter.common.utils.ResultCode;
import com.freeter.common.validator.ValidatorUtils;
import com.freeter.modules.good.entity.GoodEntity;
import com.freeter.modules.good.service.GoodService;
import com.freeter.modules.pc.entity.SeckillEntity;
import com.freeter.modules.pc.entity.model.SeckillModel;
import com.freeter.modules.pc.entity.view.SeckillView;
import com.freeter.modules.pc.entity.vo.SeckillVO;
import com.freeter.modules.pc.service.SeckillService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * api接口
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-07-26 18:20:16
 */
@RestController
@RequestMapping("seckill")
@Api(tags = "接口")
public class SeckillController {

	@Autowired
	private SeckillService seckillService;

	@Autowired
	private GoodService goodService;

	@Resource
	private RedisTemplate<String, Object> redisTemplate;

	/**
	 * 列表
	 */
	@GetMapping("/page")
	@ApiOperation("分页查询")
	public R page(@RequestParam Map<String, Object> params, SeckillModel seckillModel) {

		EntityWrapper<SeckillEntity> ew = new EntityWrapper<SeckillEntity>();
		SeckillEntity seckill = new SeckillEntity(seckillModel);
		ew.allEq(MPUtil.allEQMapPre(seckill, "seckill"));
		ew.orderBy("create_time");
		PageUtils page = seckillService.queryPage(params, ew);
		return R.ok().put("page", page);

	}

	/**
	 * 查询
	 */
	@GetMapping("/list")
	@ApiOperation("查询")
	public R list(SeckillModel seckillModel) {
		ValidatorUtils.validateEntity(seckillModel);
		EntityWrapper<SeckillEntity> ew = new EntityWrapper<SeckillEntity>();
		SeckillEntity seckill = new SeckillEntity(seckillModel);
		ew.allEq(MPUtil.allEQMapPre(seckill, "seckill"));
		List<SeckillVO> seckillVOList = seckillService.selectListVO(ew);
		return R.ok("查询成功").put("data", seckillVOList);
	}

	/**
	 * 查询
	 */
	@GetMapping("/query")
	@ApiOperation("查询")
	public R query(SeckillModel seckillModel) {
		ValidatorUtils.validateEntity(seckillModel);
		EntityWrapper<SeckillEntity> ew = new EntityWrapper<SeckillEntity>();
		SeckillEntity seckill = new SeckillEntity(seckillModel);
		ew.allEq(MPUtil.allEQMapPre(seckill, "seckill"));
		SeckillVO seckillVO = seckillService.selectVO(ew);
		return R.ok("查询成功").put("data", seckillVO);
	}

	/**
	 * 信息
	 */
	@GetMapping("/info/{id}")
	@ApiOperation("获取相应的")
	public R info(@PathVariable("id") Integer id) {
		if (id == null) {
			return R.error(ResultCode.S_PARAM_EMPTY);
		}
		EntityWrapper<SeckillEntity> ew = new EntityWrapper<SeckillEntity>();
		ew.eq("id", id);
		SeckillView seckill = seckillService.selectView(ew);
		String activityGoodId = seckill.getActivityGoodId();
		if (StringUtils.isNotBlank(activityGoodId)) {
			String activityGId = activityGoodId.substring(1, activityGoodId.length() - 1);
			String[] activityGIdArr = activityGId.split(activityGId);
			List<Integer> activityGIdList = new ArrayList<Integer>();
			if (activityGIdArr != null && activityGIdArr.length > 0) {
				for (String string : activityGIdArr) {
					activityGIdList.add(Integer.valueOf(string));
				}
			}
			if (CollectionUtils.isNotEmpty(activityGIdList)) {
				List<GoodEntity> goodList = goodService.selectBatchIds(activityGIdList);
				seckill.setGoodEntityList(goodList);
			}
		}
		return R.ok().put("seckill", seckill);
	}

	/**
	 * 保存
	 */
	@PostMapping("/save/json")
	@ApiOperation("添加数据")
	public R saveJson(@RequestBody SeckillEntity seckill) {
		ValidatorUtils.validateEntity(seckill);
		seckillService.insert(seckill);
		return R.ok();
	}

	/**
	 * 保存
	 */
	@PostMapping("/save/form")
	@ApiOperation("添加数据 （参数：表单格式）")
	public R saveForm(SeckillEntity seckill) {
		ValidatorUtils.validateEntity(seckill);
		seckillService.insert(seckill);
		return R.ok();
	}

	/**
	 * 修改（参数：json）
	 */
	@PostMapping("/update/json")
	@ApiOperation("修改数据（参数：json格式）")
	public R updateJson(@RequestBody SeckillEntity seckill) {
		if (seckill.getId() == null) {
			return R.error(ResultCode.S_PARAM_EMPTY);
		}
		seckillService.updateById(seckill);
		// 秒杀活动正在进行中
		if (Constant.SECKILL_STATE_START.intValue() == seckill.getState().intValue()) {
			SeckillEntity seckillEntity = seckillService.selectById(seckill.getId());
			if (seckillEntity == null) {
				return R.error(ResultCode.S_DATA_NOT_EXIST);
			}
			String activityGoodId = seckill.getActivityGoodId();
			if (StringUtils.isNotBlank(activityGoodId)) {
				String activityGId = activityGoodId.substring(1, activityGoodId.length() - 1);
				String[] activityGIdArr = activityGId.split(activityGId);
				List<Integer> activityGIdList = new ArrayList<Integer>();
				if (activityGIdArr != null && activityGIdArr.length > 0) {
					for (String string : activityGIdArr) {
						activityGIdList.add(Integer.valueOf(string));
					}
					// 上架商品
					setShowInShelve(activityGId, 1);
				}

				// 设置活动存入redis
				setSeckillRedis(seckillEntity, activityGIdList);
			}
		}
		return R.ok();
	}

	/**
	 * 修改（参数：传统表单）
	 */
	@PostMapping("/update/form")
	@ApiOperation("修改数据（参数：表单格式）")
	public R updateForm(SeckillEntity seckill) {
		ValidatorUtils.validateEntity(seckill);
		seckillService.updateAllColumnById(seckill);// 全部更新
		return R.ok();
	}

	/**
	 * 保存活动商品
	 */
	@PostMapping("/saveActivityGood")
	@ApiOperation("保存活动商品")
	public R saveActivityGood(@RequestBody SeckillModel seckillModel) {
		if (seckillModel.getId() == null) {
			return R.error(ResultCode.S_PARAM_EMPTY);
		}
		SeckillEntity seckillEntity = seckillService.selectById(seckillModel.getId());
		if (seckillEntity == null) {
			return R.error(ResultCode.S_DATA_NOT_EXIST);
		}
		// 秒杀
		if (Constant.ACTIVITY_TYPE_S.intValue() == seckillEntity.getType().intValue()) {
			// 秒杀活动正在进行中
			if (Constant.SECKILL_STATE_START.intValue() == seckillEntity.getState().intValue()) {
				String activityGoodId = seckillEntity.getActivityGoodId();
				if (StringUtils.isEmpty(activityGoodId)) {
					// 设置活动中的商品id
					setActivityGoodId(seckillEntity, seckillModel);
					Integer[] activityGoodIdArr = seckillModel.getGoodIds();
					if (activityGoodIdArr != null && activityGoodIdArr.length > 0) {
						// 上架商品
						setShowInShelve(StringUtils.join(seckillModel.getGoodIds(), ","), 1);
						// 设置活动存入redis
						setSeckillRedis(seckillEntity, Arrays.asList(activityGoodIdArr));
					}
					return R.ok();
				} else {
					String activityGId = activityGoodId.substring(1, activityGoodId.length() - 1);
					// 下架商品
					setShowInShelve(activityGId, 0);
					// 设置活动中的商品id
					setActivityGoodId(seckillEntity, seckillModel);
					Integer[] activityGoodIdArr = seckillModel.getGoodIds();
					if (activityGoodIdArr != null && activityGoodIdArr.length > 0) {
						// 上架商品
						setShowInShelve(StringUtils.join(seckillModel.getGoodIds(), ","), 1);
						// 设置活动存入redis
						setSeckillRedis(seckillEntity, Arrays.asList(activityGoodIdArr));
					}
					return R.ok();
				}
			} else {
				// 秒杀活动未开始
				String activityGoodId = seckillEntity.getActivityGoodId();
				if (StringUtils.isEmpty(activityGoodId)) {
					// 设置活动中的商品id
					setActivityGoodId(seckillEntity, seckillModel);
					Integer[] activityGoodIdArr = seckillModel.getGoodIds();
					if (activityGoodIdArr != null && activityGoodIdArr.length > 0) {
						// 上架商品
						setShowInShelve(StringUtils.join(seckillModel.getGoodIds(), ","), 1);
					}
					return R.ok();
				} else {
					String activityGId = activityGoodId.substring(1, activityGoodId.length() - 1);
					// 下架商品
					setShowInShelve(activityGId, 0);
					// 设置活动中的商品id
					setActivityGoodId(seckillEntity, seckillModel);
					Integer[] activityGoodIdArr = seckillModel.getGoodIds();
					if (activityGoodIdArr != null && activityGoodIdArr.length > 0) {
						// 上架商品
						setShowInShelve(StringUtils.join(seckillModel.getGoodIds(), ","), 1);
					}
					return R.ok();
				}
			}
		}
		// 团购
		if (Constant.ACTIVITY_TYPE_B.intValue() == seckillEntity.getType().intValue()) {
			String activityGoodId = seckillEntity.getActivityGoodId();
			if (StringUtils.isEmpty(activityGoodId)) {
				// 设置活动中的商品id
				setActivityGoodId(seckillEntity, seckillModel);
				Integer[] activityGoodIdArr = seckillModel.getGoodIds();
				if (activityGoodIdArr != null && activityGoodIdArr.length > 0) {
					// 上架商品
					setShowInShelve(StringUtils.join(seckillModel.getGoodIds(), ","), 1);
				}
				return R.ok();
			} else {
				String activityGId = activityGoodId.substring(1, activityGoodId.length() - 1);
				// 下架商品
				setShowInShelve(activityGId, 0);
				// 设置活动中的商品id
				setActivityGoodId(seckillEntity, seckillModel);
				Integer[] activityGoodIdArr = seckillModel.getGoodIds();
				if (activityGoodIdArr != null && activityGoodIdArr.length > 0) {
					// 上架商品
					setShowInShelve(StringUtils.join(seckillModel.getGoodIds(), ","), 1);
				}
				return R.ok();
			}
		}
		return R.error(ResultCode.S_FAIL);
	}

	/**
	 * 设置活动存入redis
	 * 
	 * @param seckillEntity
	 * @param activityGoodIdArr
	 */
	private void setSeckillRedis(SeckillEntity seckillEntity, List<Integer> activityGoodIdList) {
		List<GoodEntity> goodList = goodService.selectBatchIds(activityGoodIdList);
		if (CollectionUtils.isNotEmpty(goodList)) {
			for (GoodEntity goodEntity : goodList) {
				String goodKey = "good-kill-num:".concat(String.valueOf(goodEntity.getGoodId()));
				// 存入当前商品的库存数量
				redisTemplate.opsForValue().set(goodKey,
						String.valueOf(goodEntity.getInventory() == null ? "0" : goodEntity.getInventory()));
			}
		}
		SeckillView seckillView = new SeckillView(seckillEntity);
		seckillView.setGoodEntityList(goodList);
		redisTemplate.opsForValue().set("good-kill:" + seckillView.getId(), JSONObject.toJSONString(seckillView));
		redisTemplate.getConnectionFactory().getConnection().close();
	}

	/**
	 * 设置活动中的商品id
	 */
	private void setActivityGoodId(SeckillEntity seckillEntity, SeckillModel seckillModel) {
		Integer[] activityGoodIdArr = seckillModel.getGoodIds();
		if (activityGoodIdArr != null && activityGoodIdArr.length > 0) {
			String activityGId = StringUtils.join(activityGoodIdArr, ",");
			seckillEntity.setActivityGoodId(",".concat(activityGId).concat(","));
			seckillService.updateById(seckillEntity);
		}
	}

	/**
	 * 设置商品上下架
	 * 
	 * @param activityGoodId
	 * @param showInShelve
	 */
	private void setShowInShelve(String activityGoodId, Integer showInShelve) {
		String[] activityGoodIdArr = activityGoodId.split(",");
		List<GoodEntity> GoodList = new ArrayList<GoodEntity>();
		if (activityGoodIdArr != null && activityGoodIdArr.length > 0) {
			for (String goodId : activityGoodIdArr) {
				GoodEntity good = new GoodEntity();
				good.setGoodId(Integer.valueOf(goodId));
				good.setShowInShelve(showInShelve);
				GoodList.add(good);
			}
		}
		goodService.updateBatchById(GoodList);
	}

	/**
	 * 删除
	 */
	@PostMapping("/delete")
	@ApiOperation("删除数据")
	public R delete(@RequestBody Integer[] ids) {
		seckillService.deleteBatchIds(Arrays.asList(ids));
		return R.ok();
	}

	/**
	 * 修改上架 下架
	 * 
	 * @throws IOException
	 */
	@PostMapping("/updateShelve")
	@ApiOperation("修改上架 下架")
	public R shelve(SeckillEntity seckillEntity) throws IOException {

		SeckillEntity seckill = seckillService.selectById(seckillEntity.getId());
		if (seckill == null) {
			return R.error(ResultCode.S_DATA_NOT_EXIST);
		}
		// 上架
		if (Constant.SECKILL_STATE_START.intValue() == seckillEntity.getState().intValue()) {
			// 秒杀
			if (Constant.ACTIVITY_TYPE_S.intValue() == seckill.getType().intValue()) {
				EntityWrapper<SeckillEntity> ew = new EntityWrapper<SeckillEntity>();
				ew.eq("state", 1);
				ew.eq("type", 2);// 秒杀
				List<SeckillEntity> seckillList = seckillService.selectList(ew);
				if (CollectionUtils.isNotEmpty(seckillList)) {
					return R.error("已有秒杀活动进行中");
				} else {
					seckillService.updateById(seckillEntity);
					// 清空redis中以good-kill为开头的key
					Set<String> keys = redisTemplate.keys("good-kill*");
					if (CollectionUtils.isNotEmpty(keys)) {
						redisTemplate.delete(keys);
						redisTemplate.getConnectionFactory().getConnection().close();
					}
					List<Integer> activityGIdList = new ArrayList<Integer>();
					String activityGoodId = seckill.getActivityGoodId();
					if (StringUtils.isNotBlank(activityGoodId)) {
						String activityGId = activityGoodId.substring(1, activityGoodId.length() - 1);
						String[] activityGIdArr = activityGId.split(activityGId);
						if (activityGIdArr != null && activityGIdArr.length > 0) {
							for (String string : activityGIdArr) {
								activityGIdList.add(Integer.valueOf(string));
							}
							// 上架商品
							setShowInShelve(activityGId, 1);
						}
					}
					// 设置活动存入redis
					setSeckillRedis(seckill, activityGIdList);
					return R.ok();
				}
			}
			// 团购
			if (Constant.ACTIVITY_TYPE_B.intValue() == seckill.getType().intValue()) {
				EntityWrapper<SeckillEntity> ew = new EntityWrapper<SeckillEntity>();
				ew.eq("state", 1);
				ew.eq("type", 3);// 团购
				List<SeckillEntity> seckillList = seckillService.selectList(ew);
				if (CollectionUtils.isNotEmpty(seckillList)) {
					return R.error("已有团购活动进行中");
				} else {
					seckillService.updateById(seckillEntity);
					String activityGoodId = seckill.getActivityGoodId();
					if (StringUtils.isNotBlank(activityGoodId)) {
						String activityGId = activityGoodId.substring(1, activityGoodId.length() - 1);
						if (StringUtils.isNotBlank(activityGId)) {
							// 上架商品
							setShowInShelve(activityGId, 1);
						}
					}
					return R.ok();
				}
			}
		} else if (Constant.SECKILL_STATE_END.intValue() == seckillEntity.getState().intValue()) {// 下架
			// 秒杀
			if (Constant.ACTIVITY_TYPE_S.intValue() == seckill.getType().intValue()) {
				if (Constant.SECKILL_STATE_END.intValue() == seckill.getState().intValue()) {
					return R.error("此活动已是下架状态");
				} else {

					seckillService.updateById(seckillEntity);
					String activityGoodId = seckill.getActivityGoodId();
					if (StringUtils.isNotBlank(activityGoodId)) {
						String activityGId = activityGoodId.substring(1, activityGoodId.length() - 1);
						if (StringUtils.isNotBlank(activityGId)) {
							// 下架商品
							setShowInShelve(activityGId, 0);
						}
					}
					redisTemplate.delete("good-kill:" + seckill.getId());
					redisTemplate.getConnectionFactory().getConnection().close();
					return R.ok();
				}
			}

			// 团购
			if (Constant.ACTIVITY_TYPE_B.intValue() == seckill.getType().intValue()) {
				if (Constant.SECKILL_STATE_END.intValue() == seckill.getState().intValue()) {
					return R.error("此活动已是下架状态");
				} else {
					seckillService.updateById(seckillEntity);
					String activityGoodId = seckill.getActivityGoodId();
					if (StringUtils.isNotBlank(activityGoodId)) {
						String activityGId = activityGoodId.substring(1, activityGoodId.length() - 1);
						if (StringUtils.isNotBlank(activityGId)) {
							// 下架商品
							setShowInShelve(activityGId, 0);
						}
					}
					return R.ok();
				}
			}
		}
		return R.error();
	}

	/**
	 * 商城前端获取秒杀数据
	 */
	@PostMapping("/seckillInfo")
	@ApiOperation("商城前端获取秒杀数据")
	public R seckillInfo() {
		Set<String> set = redisTemplate.keys("product-kill:*");
		if (CollectionUtils.isNotEmpty(set)) {
			String id = "";
			for (String string : set) {
				id = string;
				break;
			}
			String info = (String) redisTemplate.opsForValue().get(id);
			redisTemplate.getConnectionFactory().getConnection().close();
			SeckillView seckillView = JSON.parseObject(info, SeckillView.class);
			seckillView.setSystemCurrentTime(DateUtils.format(new Date(), DateUtils.DATE_TIME_PATTERN));
			if (StringUtils.isNotBlank(info)) {
				return R.ok().put("seckill", seckillView);
			} else {
				return R.error("秒杀活动已经结束!");
			}
		} else {
			return R.error("秒杀活动已经结束");
		}
	}

	/**
	 * 商城前端获取团购数据
	 */
	@PostMapping("/groupBuyInfo")
	@ApiOperation("商城前端获取团购数据")
	public R groupBuyInfo() {
		EntityWrapper<SeckillEntity> ew = new EntityWrapper<SeckillEntity>();
		ew.eq("state", 1);
		ew.eq("type", 3);// 团购
		SeckillView seckill = seckillService.selectView(ew);
		if (seckill == null) {
			return R.error("团购活动已经结束!");
		} else {
			String activityGoodId = seckill.getActivityGoodId();
			if (StringUtils.isNotBlank(activityGoodId)) {
				String activityGId = activityGoodId.substring(1, activityGoodId.length() - 1);
				String[] activityGIdArr = activityGId.split(activityGId);
				List<Integer> activityGIdList = new ArrayList<Integer>();
				if (activityGIdArr != null && activityGIdArr.length > 0) {
					for (String string : activityGIdArr) {
						activityGIdList.add(Integer.valueOf(string));
					}
				}
				if (CollectionUtils.isNotEmpty(activityGIdList)) {
					List<GoodEntity> goodList = goodService.selectBatchIds(activityGIdList);
					seckill.setGoodEntityList(goodList);
				}
			}
			seckill.setSystemCurrentTime(DateUtils.format(new Date(), DateUtils.DATE_TIME_PATTERN));
			return R.ok().put("seckill", seckill);
		}
	}

	@PostMapping("/checkGood")
	@ApiOperation("检查商品")
	public R checkSecKillGood(@RequestBody Integer[] goodIds) {
		if (goodIds == null || goodIds.length == 0) {
			return R.error(ResultCode.S_PARAM_EMPTY);
		}
		String msg = "";
		List<Integer> activityGoodIdList = Arrays.asList(goodIds);
		List<GoodEntity> goodList = goodService.selectBatchIds(activityGoodIdList);
		for (GoodEntity goodEntity : goodList) {
			if (Constant.SHELVE_DOWN.intValue() == goodEntity.getShowInShelve().intValue()) {
				msg = "购物车中包含已下架的商品";
				break;
			}
			// 秒杀
			if (Constant.ACTIVITY_TYPE_S == goodEntity.getType().intValue()) {
				EntityWrapper<SeckillEntity> ew = new EntityWrapper<SeckillEntity>();
				ew.eq("state", 1);
				ew.like("activity_good_id", ",".concat(String.valueOf(goodEntity.getGoodId())).concat(","));
				SeckillView seckill = seckillService.selectView(ew);
				Date beginTime = seckill.getBeginTime();// 开始时间
				Date endTime = seckill.getEndTime();// 结束时间
				String beginTimePoint = seckill.getBeginTimePoint();// 开始时间点
				String endTimePoint = seckill.getEndTimePoint();// 结束时间点
				Date systemCurrentTime = new Date();// 系统当前时间
				if (beginTime != null && endTime != null && StringUtils.isNotBlank(beginTimePoint)
						&& StringUtils.isNotBlank(endTimePoint)) {
					if (beginTime.after(systemCurrentTime)) {
						msg = "活动未开始";
						break;
					}
					if (endTime.before(systemCurrentTime)) {
						msg = "本次活动已结束!敬请期待下一活动!";
						break;
					}
					Date beginDateTime = DateUtils.convertDate(systemCurrentTime, beginTimePoint);
					if (beginDateTime.after(systemCurrentTime)) {
						msg = "活动未开始";
						break;
					}
					Date endDateTime = DateUtils.convertDate(systemCurrentTime, endTimePoint);
					if (endDateTime.after(systemCurrentTime)) {
						msg = "本次活动已结束!敬请期待下一活动!";
						break;
					}
				} else {
					msg = "请设置活动时间";
					break;
				}
				String goodNum = (String) redisTemplate.opsForValue()
						.get("good-kill-num:".concat(String.valueOf(goodEntity.getGoodId())));
				redisTemplate.getConnectionFactory().getConnection().close();
				if (StringUtils.isNotBlank(goodNum)) {
					Long num = Long.valueOf(goodNum);
					if (num <= 0) {
						msg = "该商品已被抢完啦!敬请期待下次活动!";
						break;
					}
				}
			}
			// 团购
			if (Constant.ACTIVITY_TYPE_B == goodEntity.getType().intValue()) {
				EntityWrapper<SeckillEntity> ew = new EntityWrapper<SeckillEntity>();
				ew.eq("state", 1);
				ew.like("activity_good_id", ",".concat(String.valueOf(goodEntity.getGoodId())).concat(","));
				SeckillView seckill = seckillService.selectView(ew);
				Date beginTime = seckill.getBeginTime();// 开始时间
				Date endTime = seckill.getEndTime();// 结束时间
				String beginTimePoint = seckill.getBeginTimePoint();// 开始时间点
				String endTimePoint = seckill.getEndTimePoint();// 结束时间点
				Date systemCurrentTime = new Date();// 系统当前时间
				if (beginTime != null && endTime != null && StringUtils.isNotBlank(beginTimePoint)
						&& StringUtils.isNotBlank(endTimePoint)) {
					if (beginTime.after(systemCurrentTime)) {
						msg = "活动未开始";
						break;
					}
					if (endTime.before(systemCurrentTime)) {
						msg = "本次活动已结束!敬请期待下一活动!";
						break;
					}
					Date beginDateTime = DateUtils.convertDate(systemCurrentTime, beginTimePoint);
					if (beginDateTime.after(systemCurrentTime)) {
						msg = "活动未开始";
						break;
					}
					Date endDateTime = DateUtils.convertDate(systemCurrentTime, endTimePoint);
					if (endDateTime.after(systemCurrentTime)) {
						msg = "本次活动已结束!敬请期待下一活动!";
						break;
					}
				} else {
					msg = "请设置活动时间";
					break;
				}
				Integer num = goodEntity.getInventory();
				if (num <= 0) {
					msg = "该商品已被抢完啦!敬请期待下次活动!";
					break;
				}
			}
		}
		if (StringUtils.isNotBlank(msg)) {
			return R.error(msg);
		} else {
			return R.ok();
		}
	}

}
