package com.freeter.modules.area.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.Query;

import com.freeter.modules.area.dao.ProvinceDao;
import com.freeter.modules.area.entity.ProvinceEntity;
import com.freeter.modules.area.service.ProvinceService;
import com.freeter.modules.area.entity.vo.ProvinceVO;
import com.freeter.modules.area.entity.view.ProvinceView;


@Service("provinceService")
public class ProvinceServiceImpl extends ServiceImpl<ProvinceDao, ProvinceEntity> implements ProvinceService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ProvinceEntity> page = this.selectPage(
                new Query<ProvinceEntity>(params).getPage(),
                new EntityWrapper<ProvinceEntity>()
        );

        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ProvinceEntity> wrapper) {
		  Page<ProvinceView> page =new Query<ProvinceView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;

 	}
    
    @Override
	public List<ProvinceVO> selectListVO( Wrapper<ProvinceEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ProvinceVO selectVO( Wrapper<ProvinceEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ProvinceView> selectListView(Wrapper<ProvinceEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ProvinceView selectView(Wrapper<ProvinceEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
