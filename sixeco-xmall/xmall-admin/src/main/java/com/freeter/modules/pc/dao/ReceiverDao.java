package com.freeter.modules.pc.dao;

import com.freeter.modules.pc.entity.ReceiverEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.freeter.modules.pc.entity.vo.ReceiverVO;
import com.freeter.modules.pc.entity.view.ReceiverView;


/**
 * 
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-08-01 09:37:48
 */
public interface ReceiverDao extends BaseMapper<ReceiverEntity> {
	
	List<ReceiverVO> selectListVO(@Param("ew") Wrapper<ReceiverEntity> wrapper);
	
	ReceiverVO selectVO(@Param("ew") Wrapper<ReceiverEntity> wrapper);
	
	
	List<ReceiverView> selectListView(@Param("ew") Wrapper<ReceiverEntity> wrapper);

	List<ReceiverView> selectListView(Pagination page, @Param("ew") Wrapper<ReceiverEntity> wrapper);
	
	ReceiverView selectView(@Param("ew") Wrapper<ReceiverEntity> wrapper);
}
