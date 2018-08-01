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

import com.freeter.modules.pc.dao.AdmartDao;
import com.freeter.modules.pc.entity.AdmartEntity;
import com.freeter.modules.pc.service.AdmartService;
import com.freeter.modules.pc.entity.vo.AdmartVO;
import com.freeter.modules.pc.entity.view.AdmartView;


@Service("admartService")
public class AdmartServiceImpl extends ServiceImpl<AdmartDao, AdmartEntity> implements AdmartService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<AdmartEntity> page = this.selectPage(
                new Query<AdmartEntity>(params).getPage(),
                new EntityWrapper<AdmartEntity>()
        );

        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<AdmartEntity> wrapper) {
		  Page<AdmartView> page =new Query<AdmartView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;

 	}
    
    @Override
	public List<AdmartVO> selectListVO( Wrapper<AdmartEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public AdmartVO selectVO( Wrapper<AdmartEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<AdmartView> selectListView(Wrapper<AdmartEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public AdmartView selectView(Wrapper<AdmartEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
