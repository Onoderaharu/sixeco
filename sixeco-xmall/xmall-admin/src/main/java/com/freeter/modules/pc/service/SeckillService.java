package com.freeter.modules.pc.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.freeter.common.utils.PageUtils;
import com.freeter.modules.pc.entity.SeckillEntity;
import java.util.List;
import java.util.Map;
import com.freeter.modules.pc.entity.vo.SeckillVO;
import org.apache.ibatis.annotations.Param;
import com.freeter.modules.pc.entity.view.SeckillView;


/**
 * 
 *
 * @author SIXECO
 * @email yqq@sixeco.com
 * @date 2018-07-26 18:20:16
 */
public interface SeckillService extends IService<SeckillEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<SeckillVO> selectListVO(Wrapper<SeckillEntity> wrapper);
   	
   	SeckillVO selectVO(@Param("ew") Wrapper<SeckillEntity> wrapper);
   	
   	List<SeckillView> selectListView(Wrapper<SeckillEntity> wrapper);
   	
   	SeckillView selectView(@Param("ew") Wrapper<SeckillEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<SeckillEntity> wrapper);
}

