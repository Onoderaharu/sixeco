package com.freeter.modules.pc.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.freeter.common.utils.PageUtils;
import com.freeter.modules.pc.entity.AdmartEntity;
import java.util.List;
import java.util.Map;
import com.freeter.modules.pc.entity.vo.AdmartVO;
import org.apache.ibatis.annotations.Param;
import com.freeter.modules.pc.entity.view.AdmartView;


/**
 * 商户表
 *
 * @author SIXECO
 * @email yqq@sixeco.com
 * @date 2018-07-25 01:07:47
 */
public interface AdmartService extends IService<AdmartEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<AdmartVO> selectListVO(Wrapper<AdmartEntity> wrapper);
   	
   	AdmartVO selectVO(@Param("ew") Wrapper<AdmartEntity> wrapper);
   	
   	List<AdmartView> selectListView(Wrapper<AdmartEntity> wrapper);
   	
   	AdmartView selectView(@Param("ew") Wrapper<AdmartEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<AdmartEntity> wrapper);
}

