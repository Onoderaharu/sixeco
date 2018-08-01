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

import com.freeter.modules.pc.dao.ReceiverDao;
import com.freeter.modules.pc.entity.ReceiverEntity;
import com.freeter.modules.pc.service.ReceiverService;
import com.freeter.modules.pc.entity.vo.ReceiverVO;
import com.freeter.modules.pc.entity.view.ReceiverView;


@Service("receiverService")
public class ReceiverServiceImpl extends ServiceImpl<ReceiverDao, ReceiverEntity> implements ReceiverService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ReceiverEntity> page = this.selectPage(
                new Query<ReceiverEntity>(params).getPage(),
                new EntityWrapper<ReceiverEntity>()
        );

        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ReceiverEntity> wrapper) {
		  Page<ReceiverView> page =new Query<ReceiverView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;

 	}
    
    @Override
	public List<ReceiverVO> selectListVO( Wrapper<ReceiverEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ReceiverVO selectVO( Wrapper<ReceiverEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ReceiverView> selectListView(Wrapper<ReceiverEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ReceiverView selectView(Wrapper<ReceiverEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
