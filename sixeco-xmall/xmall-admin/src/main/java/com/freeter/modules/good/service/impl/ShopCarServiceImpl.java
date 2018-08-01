package com.freeter.modules.good.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.Query;
import com.freeter.common.utils.Result;
import com.freeter.modules.good.dao.ShopCarDao;
import com.freeter.modules.good.entity.ShopCarEntity;
import com.freeter.modules.good.service.ShopCarService;
import com.freeter.modules.good.entity.vo.ShopCarVO;
import com.freeter.modules.good.entity.view.ShopCarView;


@SuppressWarnings("rawtypes")
@Service("shopCarService")
public class ShopCarServiceImpl extends ServiceImpl<ShopCarDao, ShopCarEntity> implements ShopCarService {

	
	@Autowired
	private ShopCarDao shopCarDao;
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShopCarEntity> page = this.selectPage(
                new Query<ShopCarEntity>(params).getPage(),
                new EntityWrapper<ShopCarEntity>()
        );

        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShopCarEntity> wrapper) {
		  Page<ShopCarView> page =new Query<ShopCarView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;

 	}
    
    @Override
	public List<ShopCarVO> selectListVO( Wrapper<ShopCarEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShopCarVO selectVO( Wrapper<ShopCarEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShopCarView> selectListView(Wrapper<ShopCarEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShopCarView selectView(Wrapper<ShopCarEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

	
	
	
	@Override
	public List<ShopCarView> list(Integer userId) {
		
		if(userId != null) {
			return shopCarDao.list(userId);
		}
		
		return null;
	}

	@Override
	public List<ShopCarView> getByProId(Integer proId, Integer userId, Integer productItemId) {
		
		return shopCarDao.getByProId(proId, userId, productItemId);
	}

	@Override
	public ShopCarView selectByProductIdAndUserIdAndItemStr(Integer productId, Long userId, String itemStr) {
		
		return shopCarDao.selectByProductIdAndUserIdAndItemStr(productId, userId, itemStr);
	}

	@Override
	public Result delete(Object[] ids) {
		
		if(ids != null) {
			for(int i=0;i<ids.length;i++) {
				Integer id = Integer.valueOf(ids[i].toString());
				shopCarDao.deleteById(id);
			}
		}
		
		return null;
	}

	@Override
	public List<ShopCarView> listForPage(Integer userId, Integer page, Integer pageSize) {
		
		return null;
	}

}
