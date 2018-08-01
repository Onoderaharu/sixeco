package com.freeter.modules.pc.dao;

import com.freeter.modules.pc.entity.SeckillEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.freeter.modules.pc.entity.vo.SeckillVO;
import com.freeter.modules.pc.entity.view.SeckillView;


/**
 * 
 * 
 * @author SIXECO
 * @email yqq@sixeco.com
 * @date 2018-07-26 18:20:16
 */
public interface SeckillDao extends BaseMapper<SeckillEntity> {
	
	List<SeckillVO> selectListVO(@Param("ew") Wrapper<SeckillEntity> wrapper);
	
	SeckillVO selectVO(@Param("ew") Wrapper<SeckillEntity> wrapper);
	
	
	List<SeckillView> selectListView(@Param("ew") Wrapper<SeckillEntity> wrapper);

	List<SeckillView> selectListView(Pagination page,@Param("ew") Wrapper<SeckillEntity> wrapper);
	
	SeckillView selectView(@Param("ew") Wrapper<SeckillEntity> wrapper);
}
