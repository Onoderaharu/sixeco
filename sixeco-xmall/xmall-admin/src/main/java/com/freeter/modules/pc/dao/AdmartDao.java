package com.freeter.modules.pc.dao;

import com.freeter.modules.pc.entity.AdmartEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.freeter.modules.pc.entity.vo.AdmartVO;
import com.freeter.modules.pc.entity.view.AdmartView;


/**
 * 商户表
 * 
 * @author SIXECO
 * @email yqq@sixeco.com
 * @date 2018-07-25 01:07:47
 */
public interface AdmartDao extends BaseMapper<AdmartEntity> {
	
	List<AdmartVO> selectListVO(@Param("ew") Wrapper<AdmartEntity> wrapper);
	
	AdmartVO selectVO(@Param("ew") Wrapper<AdmartEntity> wrapper);
	
	
	List<AdmartView> selectListView(@Param("ew") Wrapper<AdmartEntity> wrapper);

	List<AdmartView> selectListView(Pagination page,@Param("ew") Wrapper<AdmartEntity> wrapper);
	
	AdmartView selectView(@Param("ew") Wrapper<AdmartEntity> wrapper);
}
