package com.freeter.modules.area.dao;

import com.freeter.modules.area.entity.ProvinceEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.freeter.modules.area.entity.vo.ProvinceVO;
import com.freeter.modules.area.entity.view.ProvinceView;


/**
 * 
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-07-30 11:56:26
 */
public interface ProvinceDao extends BaseMapper<ProvinceEntity> {
	
	List<ProvinceVO> selectListVO(@Param("ew") Wrapper<ProvinceEntity> wrapper);
	
	ProvinceVO selectVO(@Param("ew") Wrapper<ProvinceEntity> wrapper);
	
	
	List<ProvinceView> selectListView(@Param("ew") Wrapper<ProvinceEntity> wrapper);

	List<ProvinceView> selectListView(Pagination page,@Param("ew") Wrapper<ProvinceEntity> wrapper);
	
	ProvinceView selectView(@Param("ew") Wrapper<ProvinceEntity> wrapper);
}
