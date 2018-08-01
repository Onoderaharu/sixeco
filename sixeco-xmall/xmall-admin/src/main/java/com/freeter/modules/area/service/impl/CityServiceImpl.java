package com.freeter.modules.area.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;

import javax.annotation.Resource;

import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.Query;
import com.freeter.modules.area.dao.CityDao;
import com.freeter.modules.area.entity.CityEntity;
import com.freeter.modules.area.service.CityService;
import com.freeter.modules.area.entity.vo.CityVO;
import com.freeter.modules.area.entity.view.CityView;


@Service("cityService")
public class CityServiceImpl extends ServiceImpl<CityDao, CityEntity> implements CityService {
   
	@Resource
	private CityDao cityDao;
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CityEntity> page = this.selectPage(
                new Query<CityEntity>(params).getPage(),
                new EntityWrapper<CityEntity>()
        );

        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<CityEntity> wrapper) {
		  Page<CityView> page =new Query<CityView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;

 	}
    
    @Override
	public List<CityVO> selectListVO( Wrapper<CityEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public CityVO selectVO( Wrapper<CityEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<CityView> selectListView(Wrapper<CityEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public CityView selectView(Wrapper<CityEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

	@Override
	public List<CityEntity> selectList(Integer provId) {
		return cityDao.selectCityByProvId(provId);
	}

}
