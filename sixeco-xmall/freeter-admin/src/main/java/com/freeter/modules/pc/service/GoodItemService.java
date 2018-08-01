package com.freeter.modules.pc.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.freeter.common.utils.PageUtils;
import com.freeter.modules.pc.entity.GoodItemEntity;
import java.util.List;
import java.util.Map;
import com.freeter.modules.pc.entity.vo.GoodItemVO;
import org.apache.ibatis.annotations.Param;
import com.freeter.modules.pc.entity.view.GoodItemView;


/**
 * 
 *
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-07-31 14:47:21
 */
public interface GoodItemService extends IService<GoodItemEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GoodItemVO> selectListVO(Wrapper<GoodItemEntity> wrapper);
   	
   	GoodItemVO selectVO(@Param("ew") Wrapper<GoodItemEntity> wrapper);
   	
   	List<GoodItemView> selectListView(Wrapper<GoodItemEntity> wrapper);
   	
   	GoodItemView selectView(@Param("ew") Wrapper<GoodItemEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<GoodItemEntity> wrapper);
}

