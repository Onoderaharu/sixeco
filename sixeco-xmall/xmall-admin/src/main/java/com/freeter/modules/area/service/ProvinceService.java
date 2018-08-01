package com.freeter.modules.area.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.freeter.common.utils.PageUtils;
import com.freeter.modules.area.entity.ProvinceEntity;
import java.util.List;
import java.util.Map;
import com.freeter.modules.area.entity.vo.ProvinceVO;
import org.apache.ibatis.annotations.Param;
import com.freeter.modules.area.entity.view.ProvinceView;


/**
 * 
 * 省份表
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-07-30 11:56:26
 */
public interface ProvinceService extends IService<ProvinceEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ProvinceVO> selectListVO(Wrapper<ProvinceEntity> wrapper);
   	
   	ProvinceVO selectVO(@Param("ew") Wrapper<ProvinceEntity> wrapper);
   	
   	List<ProvinceView> selectListView(Wrapper<ProvinceEntity> wrapper);
   	
   	ProvinceView selectView(@Param("ew") Wrapper<ProvinceEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ProvinceEntity> wrapper);
}

