package com.freeter.modules.area.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.freeter.common.utils.PageUtils;
import com.freeter.modules.area.entity.CityEntity;
import java.util.List;
import java.util.Map;
import com.freeter.modules.area.entity.vo.CityVO;
import org.apache.ibatis.annotations.Param;
import com.freeter.modules.area.entity.view.CityView;


/**
 * 
 * 城市表
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-07-30 11:56:26
 */
public interface CityService extends IService<CityEntity> {
	
	List<CityEntity> selectList(Integer provId);

    PageUtils queryPage(Map<String, Object> params);
    
   	List<CityVO> selectListVO(Wrapper<CityEntity> wrapper);
   	
   	CityVO selectVO(@Param("ew") Wrapper<CityEntity> wrapper);
   	
   	List<CityView> selectListView(Wrapper<CityEntity> wrapper);
   	
   	CityView selectView(@Param("ew") Wrapper<CityEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<CityEntity> wrapper);
}

