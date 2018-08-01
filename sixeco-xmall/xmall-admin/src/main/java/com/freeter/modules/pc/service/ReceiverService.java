package com.freeter.modules.pc.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.freeter.common.utils.PageUtils;
import com.freeter.modules.pc.entity.ReceiverEntity;
import java.util.List;
import java.util.Map;
import com.freeter.modules.pc.entity.vo.ReceiverVO;
import org.apache.ibatis.annotations.Param;
import com.freeter.modules.pc.entity.view.ReceiverView;


/**
 * 
 *
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-08-01 09:37:48
 */
public interface ReceiverService extends IService<ReceiverEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ReceiverVO> selectListVO(Wrapper<ReceiverEntity> wrapper);
   	
   	ReceiverVO selectVO(@Param("ew") Wrapper<ReceiverEntity> wrapper);
   	
   	List<ReceiverView> selectListView(Wrapper<ReceiverEntity> wrapper);
   	
   	ReceiverView selectView(@Param("ew") Wrapper<ReceiverEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params, Wrapper<ReceiverEntity> wrapper);
}

