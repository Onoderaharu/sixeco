package com.freeter.modules.area.controller;

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
import com.freeter.modules.area.entity.model.ProvinceModel;
import com.freeter.modules.area.entity.view.ProvinceView;
import com.freeter.modules.area.entity.vo.ProvinceVO;
import com.freeter.common.utils.MPUtil;
import com.freeter.modules.area.entity.ProvinceEntity;
import com.freeter.modules.area.service.ProvinceService;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 省份表
 * api接口
 * @author jiangqianshu
 * @email 2635045337@qq.com
 * @date 2018-07-30 11:56:26
 */
@RestController
@RequestMapping("province")
@Api(tags = "省份接口")
public class ProvinceController {
	@Autowired
	private ProvinceService provinceService;

	/**
	 * 列表
	 */
	@GetMapping("/page")
	@ApiOperation("省份分页查询")
	public R page(@RequestParam Map<String, Object> params, ProvinceModel provinceModel) {

		EntityWrapper<ProvinceEntity> ew = new EntityWrapper<ProvinceEntity>();
		ProvinceEntity province = new ProvinceEntity(provinceModel);
		ew.allEq(MPUtil.allEQMapPre(province, "province"));
		PageUtils page = provinceService.queryPage(params, ew);
		return R.ok().put("data", page);

	}

	/**
	 * 查询
	 */
	@GetMapping("/list")
	@ApiOperation("查询省份列表")
	public R list(ProvinceModel provinceModel) {
		ValidatorUtils.validateEntity(provinceModel);
		EntityWrapper<ProvinceEntity> ew = new EntityWrapper<ProvinceEntity>();
		ProvinceEntity province = new ProvinceEntity(provinceModel);
		ew.allEq(MPUtil.allEQMapPre(province, "province"));
		List<ProvinceView> provinceVOList = provinceService.selectListView(ew);
		return R.ok("查询省份成功").put("data", provinceVOList);
	}

	/**
	 * 查询
	 */
	@GetMapping("/query")
	@ApiOperation("查询省份")
	public R query(ProvinceModel provinceModel) {
		ValidatorUtils.validateEntity(provinceModel);
		EntityWrapper<ProvinceEntity> ew = new EntityWrapper<ProvinceEntity>();
		ProvinceEntity province = new ProvinceEntity(provinceModel);
		ew.allEq(MPUtil.allEQMapPre(province, "province"));
		ProvinceVO provinceVO = provinceService.selectVO(ew);
		return R.ok("查询省份成功").put("data", provinceVO);
	}

	/**
	 * 信息
	 */
	@GetMapping("/info/{provinceId}")
	@ApiOperation("获取相应的省份表")
	public R info(@PathVariable("provinceId") Integer provinceId) {
		ProvinceEntity province = provinceService.selectById(provinceId);
		return R.ok().put("province", province);
	}

	/**
	 * 保存
	 */
	@PostMapping("/save/json")
	@ApiOperation("添加省份表数据")
	public R saveJson(@RequestBody ProvinceEntity province) {
		ValidatorUtils.validateEntity(province);
		provinceService.insert(province);
		return R.ok();
	}

	/**
	 * 保存
	 */
	@PostMapping("/save/form")
	@ApiOperation("添加省份表数据 （参数：表单格式）")
	public R saveForm(ProvinceEntity province) {
		ValidatorUtils.validateEntity(province);
		provinceService.insert(province);

		return R.ok();
	}

	/**
	 * 修改（参数：json）
	 */
	@PostMapping("/update/json")
	@ApiOperation("修改省份表数据（参数：json格式）")
	public R updateJson(@RequestBody ProvinceEntity province) {
		ValidatorUtils.validateEntity(province);
		provinceService.updateAllColumnById(province);// 全部更新
		return R.ok();
	}

	/**
	 * 修改（参数：传统表单）
	 */
	@PostMapping("/update/form")
	@ApiOperation("修改省份表数据（参数：表单格式）")
	public R updateForm(ProvinceEntity province) {
		ValidatorUtils.validateEntity(province);
		provinceService.updateAllColumnById(province);// 全部更新
		return R.ok();
	}

	/**
	 * 删除
	 */
	@PostMapping("/delete")
	@ApiOperation("删除省份表数据")
	public R delete(@RequestBody Integer[] provinceIds) {
		provinceService.deleteBatchIds(Arrays.asList(provinceIds));
		return R.ok();
	}
}