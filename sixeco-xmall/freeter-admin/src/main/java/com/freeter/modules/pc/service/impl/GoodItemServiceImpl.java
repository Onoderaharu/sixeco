package com.freeter.modules.pc.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.Query;

import com.freeter.modules.pc.dao.GoodItemDao;
import com.freeter.modules.pc.entity.GoodItemEntity;
import com.freeter.modules.pc.service.GoodItemService;
import com.freeter.modules.pc.entity.vo.GoodItemVO;
import com.freeter.modules.pc.entity.view.GoodItemView;


@Service("goodItemService")
public class GoodItemServiceImpl extends ServiceImpl<GoodItemDao, GoodItemEntity> implements GoodItemService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GoodItemEntity> page = this.selectPage(
                new Query<GoodItemEntity>(params).getPage(),
                new EntityWrapper<GoodItemEntity>()
        );

        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<GoodItemEntity> wrapper) {
		  Page<GoodItemView> page =new Query<GoodItemView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;

 	}
    
    @Override
	public List<GoodItemVO> selectListVO( Wrapper<GoodItemEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public GoodItemVO selectVO( Wrapper<GoodItemEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<GoodItemView> selectListView(Wrapper<GoodItemEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GoodItemView selectView(Wrapper<GoodItemEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
