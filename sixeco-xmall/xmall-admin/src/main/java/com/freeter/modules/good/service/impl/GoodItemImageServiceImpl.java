package com.freeter.modules.good.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.freeter.common.utils.R;
import com.freeter.common.utils.ResultCode;
import com.freeter.modules.good.dao.GoodItemImageDao;
import com.freeter.modules.good.entity.GoodItemImageEntity;
import com.freeter.modules.good.entity.view.GoodItemImageView;
import com.freeter.modules.good.entity.vo.GoodItemImageVO;
import com.freeter.modules.good.service.GoodItemImageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.Query;


@Service("goodItemImageService")
public class GoodItemImageServiceImpl extends ServiceImpl<GoodItemImageDao, GoodItemImageEntity> implements
                                                                                                 GoodItemImageService {
    private Logger log=LoggerFactory.getLogger(GoodItemImageServiceImpl.class);
    
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GoodItemImageEntity> page = this.selectPage(
                new Query<GoodItemImageEntity>(params).getPage(),
                new EntityWrapper<GoodItemImageEntity>()
        );

        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<GoodItemImageEntity> wrapper) {
		  Page<GoodItemImageView> page =new Query<GoodItemImageView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;

 	}
    
    @Override
	public List<GoodItemImageVO> selectListVO(Wrapper<GoodItemImageEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public GoodItemImageVO selectVO( Wrapper<GoodItemImageEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<GoodItemImageView> selectListView(Wrapper<GoodItemImageEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GoodItemImageView selectView(Wrapper<GoodItemImageEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    /**
     * 修改周边商品配置信息
     *
     * @param itemImageStr
     * @return
     */
    @Override
    public R updateAroundItemImg(String itemImageStr) {
        if (itemImageStr == null) {
            return R.error("参数丢失");
        }
        GoodItemImageEntity itemImage = null;
        try {
            itemImage = JSONObject.parseObject(itemImageStr, new TypeReference<GoodItemImageEntity>() {
            });
        } catch (Exception e) {
            e.printStackTrace();
            log.info("json解析异常");
            return R.error("json解析异常");
        }
        if (itemImage == null) {
            return R.error("参数丢失");
        }
        if (itemImage.getUrl() == null || itemImage.getProductItemId() == null) {
            return R.error("参数丢失");
        }
        GoodItemImageEntity productItemImage = baseMapper.selectByItemId(itemImage);
        if (productItemImage == null) {
            productItemImage = new GoodItemImageEntity();
            productItemImage.setProductItemId(itemImage.getProductItemId());
            productItemImage.setUrl(itemImage.getUrl());
            productItemImage.setType(0);
            baseMapper.insert(productItemImage);
        } else {
            productItemImage.setUrl(itemImage.getUrl());
            baseMapper.updateById(productItemImage);
        }
        return R.ok();
    }
}
