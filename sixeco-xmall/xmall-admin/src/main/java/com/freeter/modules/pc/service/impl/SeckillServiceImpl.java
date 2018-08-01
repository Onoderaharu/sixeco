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

import com.freeter.modules.pc.dao.SeckillDao;
import com.freeter.modules.pc.entity.SeckillEntity;
import com.freeter.modules.pc.service.SeckillService;
import com.freeter.modules.pc.entity.vo.SeckillVO;
import com.freeter.modules.pc.entity.view.SeckillView;


@Service("seckillService")
public class SeckillServiceImpl extends ServiceImpl<SeckillDao, SeckillEntity> implements SeckillService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SeckillEntity> page = this.selectPage(
                new Query<SeckillEntity>(params).getPage(),
                new EntityWrapper<SeckillEntity>()
        );

        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<SeckillEntity> wrapper) {
		  Page<SeckillView> page =new Query<SeckillView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;

 	}
    
    @Override
	public List<SeckillVO> selectListVO( Wrapper<SeckillEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public SeckillVO selectVO( Wrapper<SeckillEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<SeckillView> selectListView(Wrapper<SeckillEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public SeckillView selectView(Wrapper<SeckillEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
