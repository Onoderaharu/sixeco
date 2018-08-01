package com.freeter.modules.area.dao;

import com.freeter.modules.area.entity.CityEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.freeter.modules.area.entity.vo.CityVO;
import com.freeter.modules.area.entity.view.CityView;


/**
 * 
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-07-30 11:56:26
 */
public interface CityDao extends BaseMapper<CityEntity> {
	
	List<CityVO> selectListVO(@Param("ew") Wrapper<CityEntity> wrapper);
	
	CityVO selectVO(@Param("ew") Wrapper<CityEntity> wrapper);
	
	List<CityEntity>selectCityByProvId(Integer id);
	
	List<CityView> selectListView(@Param("ew") Wrapper<CityEntity> wrapper);

	List<CityView> selectListView(Pagination page,@Param("ew") Wrapper<CityEntity> wrapper);
	
	CityView selectView(@Param("ew") Wrapper<CityEntity> wrapper);
}
