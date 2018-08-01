package com.freeter.modules.good.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.R;
import com.freeter.common.validator.Assert;
import com.freeter.common.validator.ValidatorUtils;
import com.freeter.modules.good.entity.CategoryEntity;
import com.freeter.modules.good.entity.GoodEntity;
import com.freeter.modules.good.entity.model.GoodModel;
import com.freeter.modules.good.entity.view.GoodView;
import com.freeter.modules.good.service.CategoryGoodService;
import com.freeter.modules.good.service.CategoryService;
import com.freeter.modules.good.service.GoodImageService;
import com.freeter.modules.good.service.GoodService;
import com.freeter.modules.oss.cloud.OSSFactory;
import com.freeter.modules.pc.entity.AdmartEntity;
import com.freeter.modules.pc.service.AdmartService;

/**
 * 商品表
 *
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-05-31 09:01:38
 */
@RestController
@RequestMapping("good/good")
public class GoodController {

	@Autowired
	private GoodService goodService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private CategoryGoodService categoryGoodService;
	@Autowired
	private GoodImageService goodImageService;
	@Autowired
	private AdmartService admartService;

	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("good:good:list")
	public R list(@RequestParam Map<String, Object> params, GoodView goodView) {
		EntityWrapper<GoodEntity> wrapper = new EntityWrapper<GoodEntity>();
		if (goodView.getCategoryId() != null) {
			wrapper.eq("good.category_id", goodView.getCategoryId());
		}
		if (goodView.getOneCategoryId() != null) {
			EntityWrapper<CategoryEntity> wrapperCategory = new EntityWrapper<CategoryEntity>();
			wrapperCategory.eq("parent_id", goodView.getOneCategoryId());
			List<Object> categoryIds = categoryService.selectObjs(wrapperCategory);
			if (categoryIds.isEmpty()) {
				return R.ok().put("page", new PageUtils(params));
			}
			wrapper.in("good.category_id", categoryIds);
		}
		if (goodView.getChannelId() != null) {
			EntityWrapper<CategoryEntity> wrapperCategory = new EntityWrapper<CategoryEntity>();
			wrapperCategory.eq("channel_id", goodView.getChannelId());
			List<Object> categoryIds = categoryService.selectObjs(wrapperCategory);
			if (categoryIds.isEmpty()) {
				return R.ok().put("page", new PageUtils(params));
			}
			wrapper.in("good.category_id", categoryIds);
		}
		wrapper.like("good.good_name", goodView.getGoodName());
		// 获取未被删除的商品
		wrapper.eq("good.del_flag", 0);
		PageUtils page = new PageUtils(goodService.queryPage(params, wrapper));
		return R.ok().put("page", page);
	}

	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("good:good:save")
	public R save(@RequestBody GoodEntity good) {
		ValidatorUtils.validateEntity(good);
		goodService.insert(good);

		return R.ok();
	}

	/**
	 * 修改
	 * 
	 * @throws IOException
	 */
	@RequestMapping("/update")
	@RequiresPermissions("good:good:update")
	public R update(@RequestBody GoodView goodView) throws IOException {
		Long newCategoryId = goodView.getCategoryId();
		Assert.isNull(goodView.getCategoryId(), "分类不能为空");
		ValidatorUtils.validateEntity(goodView);
		goodService.updateAllColumnById(goodView);
		return R.ok();
	}

	/**
	 * 修改上架 下架
	 * 
	 * @throws IOException
	 */
	@RequestMapping("/updateShelve")
	@RequiresPermissions("good:good:update")
	public R shelve(@RequestBody GoodModel goodModel) {
		ValidatorUtils.validateEntity(goodModel);
		List<GoodEntity> GoodList = new ArrayList<GoodEntity>();
		if (goodModel.getGoodIds() != null && goodModel.getGoodIds().length > 0
				&& goodModel.getShowInShelve() != null) {
			for (Integer goodId : goodModel.getGoodIds()) {
				GoodEntity good = new GoodEntity();
				good.setGoodId(goodId);
				good.setShowInShelve(goodModel.getShowInShelve());
				GoodList.add(good);
			}
		}
		goodService.updateBatchById(GoodList);
		return R.ok();
	}

	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("good:good:delete")
	public R delete(@RequestBody Integer[] goodIds) {
		List<GoodEntity> GoodList = new ArrayList<GoodEntity>();
		if (goodIds != null && goodIds.length > 0) {
			for (Integer goodId : goodIds) {
				GoodEntity good = new GoodEntity();
				good.setGoodId(goodId);
				good.setDelFlag(1);
				GoodList.add(good);
			}
		}
		goodService.updateBatchById(GoodList);
		return R.ok();
	}

	/**
	 * 设置是否推荐
	 */
	@RequestMapping("/showInLike")
	@RequiresPermissions("good:good:showInLike")
	public R showInLike(@RequestBody Integer[] goodIds) {
		List<GoodEntity> GoodList = new ArrayList<GoodEntity>();
		if (goodIds != null && goodIds.length > 0) {
			for (Integer goodId : goodIds) {
				GoodEntity good = goodService.selectById(goodId);
				if (good != null) {
					if (good.getShowInLike() != null && "1".equals(String.valueOf(good.getShowInLike()))) {
						good.setShowInLike(0);
						goodService.updateById(good);
					} else {
						good.setShowInLike(1);
						goodService.updateById(good);
					}
				}
			}
			return R.ok();
		} else {
			return R.error();
		}
	}

	/**
	 * 设置是否可购
	 */
	@RequestMapping("/allowBuy")
	@RequiresPermissions("good:good:allowBuy")
	public R allowBuy(@RequestBody Integer[] goodIds) {
		List<GoodEntity> GoodList = new ArrayList<GoodEntity>();
		if (goodIds != null && goodIds.length > 0) {
			for (Integer goodId : goodIds) {
				GoodEntity good = goodService.selectById(goodId);
				if (good != null) {
					if (good.getAllowBuyFlag() != null && "1".equals(String.valueOf(good.getAllowBuyFlag()))) {
						good.setAllowBuyFlag(0);
						goodService.updateById(good);
					} else {
						good.setAllowBuyFlag(1);
						goodService.updateById(good);
					}
				}
			}
			return R.ok();
		} else {
			return R.error();
		}
	}

	/**
	 * 信息
	 */
	@RequestMapping("/info/{goodId}")
	@RequiresPermissions("good:good:info")
	public R info(@PathVariable("goodId") Integer goodId) {
		GoodEntity good = goodService.selectById(goodId);
		GoodView goodView = new GoodView(good);
		if (good != null) {
			CategoryEntity category = categoryService.selectById(good.getCategoryId());
			if (category != null) {
				goodView.setCategoryId(category.getCategoryId());
				if (StringUtils.isNotBlank(category.getChannelId())) {
					goodView.setChannelId(Long.valueOf(category.getChannelId()));
				}
				goodView.setParentId(category.getParentId());
			}
			return R.ok().put("good", goodView);
		} else {
			return R.error();
		}
	}

	/**
	 * 根据商品类型type查询--分页
	 */
	@RequestMapping("/getGoodListbyType")
	// @RequiresPermissions("good:good:getGoodListbyType")
	public R getGoodListbyType(@RequestParam Map<String, Object> params, GoodModel goodModel) {
		if (goodModel.getType() == null) {
			return R.error();
		}
		EntityWrapper<GoodEntity> ew = new EntityWrapper<GoodEntity>();
		// 获取未被删除的商品
		ew.eq("good.del_flag", 0);
		ew.eq("good.type", goodModel.getType());
		Page<GoodView> page = goodService.queryPage(params, ew);
		return R.ok().put("page", page);
	}

	/**
	 * 商户列表
	 */
	@RequestMapping("/getMartList")
	@RequiresPermissions("good:mart:list")
	public R getMartList() {
		AdmartEntity admartEntity = new AdmartEntity();
		EntityWrapper<AdmartEntity> ew = new EntityWrapper<AdmartEntity>();
		List list = admartService.selectList(ew);
		return R.ok().put("data", list);
	}

	/**
	 * 修改
	 * 
	 * @throws IOException
	 */
	@RequestMapping("/updateImage")
	@RequiresPermissions("good:good:update")
	public R updateImage(GoodEntity good, @RequestParam("files") MultipartFile file) throws IOException {
		if (file != null && file.getSize() > 0) {

			// 上传文件
			String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
			String url = OSSFactory.build().uploadSuffix(file.getBytes(), suffix);
			good.setPicImg(url);
		}

		goodService.updateById(good);

		return R.ok();
	}

	/**
	 * 修改
	 * 
	 * @throws IOException
	 */
	@RequestMapping("/deleteImage")
	@RequiresPermissions("good:good:update")
	public R updateImage(GoodEntity good, @RequestParam(value = "filePath") String filePath) throws IOException {
		OSSFactory.build().deleteByPath(filePath);
		good = goodService.selectById(good.getGoodId());
		good.setPicImg(null);
		goodService.updateAllColumnById(good);

		return R.ok();
	}

}
