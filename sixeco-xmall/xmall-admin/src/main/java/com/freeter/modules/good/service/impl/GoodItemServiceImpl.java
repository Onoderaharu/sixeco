package com.freeter.modules.good.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.freeter.common.utils.*;
import com.freeter.modules.good.dao.GoodItemDao;
import com.freeter.modules.good.entity.GoodEntity;
import com.freeter.modules.good.entity.GoodItemEntity;
import com.freeter.modules.good.entity.GoodItemImageEntity;
import com.freeter.modules.good.entity.model.GoodItemModel;
import com.freeter.modules.good.entity.model.OrderDetail;
import com.freeter.modules.good.entity.view.GoodItemView;
import com.freeter.modules.good.entity.vo.AroundDetailVo;
import com.freeter.modules.good.entity.vo.AroundItemLevel;
import com.freeter.modules.good.entity.vo.GoodItemVO;
import com.freeter.modules.good.service.GoodItemService;
import com.freeter.modules.good.service.GoodService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service("goodItemService")
public class GoodItemServiceImpl extends ServiceImpl<GoodItemDao, GoodItemEntity> implements
                                                                                  GoodItemService {
    
    @Autowired
    private GoodService goodService;
    
    private Logger log = LoggerFactory.getLogger(GoodItemServiceImpl.class);
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GoodItemEntity> page = this.selectPage(
                new Query<GoodItemEntity>(params).getPage(),
                new EntityWrapper<GoodItemEntity>()
        );

        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<GoodItemEntity> wrapper) {
		  Page<GoodItemView> page =new Query<GoodItemView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;

 	}

    /**
     * 查询周边商品配置信息
     *
     * @param proItem
     * @return
     */
    @Override
    public R getAroundDeploy(GoodItemEntity proItem) {
        //根据id查询商品是否存在
        GoodEntity product = goodService.selectById(proItem.getProductId());
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("product", product.getOldObj());

        if (product == null) {
            return R.error("商品不存在");
        }
        List<GoodItemView> valueList = baseMapper.getDeploy(proItem);
        List<GoodItemImageEntity> imgList = new ArrayList<GoodItemImageEntity>();
        List<AroundDetailVo> AroundProductList = new ArrayList<AroundDetailVo>();

        String l1Name = product.getTip1();
        String l2Name = product.getTip2();
        String l3Name = product.getTip3();
        String l4Name = product.getTip4();
        Set<AroundItemLevel> l1Set = new HashSet<>();
        Set<AroundItemLevel> l2Set = new HashSet<AroundItemLevel>();
        Set<AroundItemLevel> l3Set = new HashSet<AroundItemLevel>();
        Set<AroundItemLevel> l4Set = new HashSet<AroundItemLevel>();
        Set<AroundItemLevel> l5Set = new HashSet<AroundItemLevel>();

        if (valueList != null && valueList.size() > 0) {
            for (GoodItemView item : valueList) {
                for (GoodItemImageEntity itemImage : item.getImgList()) {
                    imgList.add(itemImage);
                }
            }
            this.setImg(valueList, imgList);

            for (GoodItemView productItem : valueList) {
                String l1Type = productItem.getLevel1Type();
                if (l1Type != null && !"".equals(l1Type)) {
                    l1Set.add(new AroundItemLevel(l1Type, productItem.getIsUse().toString()));
                }
                String l2Type = productItem.getLevel2Type();
                if (l2Type != null && !"".equals(l2Type)) {
                    l2Set.add(new AroundItemLevel(l2Type, productItem.getIsUse().toString()));
                }
                String l3Type = productItem.getLevel3Type();
                if (l3Type != null && !"".equals(l3Type)) {
                    l3Set.add(new AroundItemLevel(l3Type, productItem.getIsUse().toString()));
                }
                String l4Type = productItem.getLevel4Type();
                if (l4Type != null && !"".equals(l4Type)) {
                    l4Set.add(new AroundItemLevel(l4Type, productItem.getIsUse().toString()));
                }
                String l5Type = productItem.getLevel5Type();
                if (l5Type != null && !"".equals(l5Type)) {
                    l5Set.add(new AroundItemLevel(l5Type, productItem.getIsUse().toString()));
                }
            }

        }
        if (l1Name != null && !"".equals(l1Name)) { // 存在下拉框值 
            AroundDetailVo cd = new AroundDetailVo(Constant.ITEM_LEVEL1_NAME,
                    Constant.LEVEL1_TYPE, l1Name, l1Set);
            AroundProductList.add(cd);
        }
        if (l2Name != null && !"".equals(l2Name)) {
            AroundDetailVo cd = new AroundDetailVo(Constant.ITEM_LEVEL2_NAME,
                    Constant.LEVEL2_TYPE, l2Name, l2Set);
            AroundProductList.add(cd);
        }
        if (l3Name != null && !"".equals(l3Name)) {
            AroundDetailVo cd = new AroundDetailVo(Constant.ITEM_LEVEL3_NAME,
                    Constant.LEVEL3_TYPE, l3Name, l3Set);
            AroundProductList.add(cd);
        }
        if (l4Name != null && !"".equals(l4Name)) {
            AroundDetailVo cd = new AroundDetailVo(Constant.ITEM_LEVEL4_NAME,
                    Constant.LEVEL4_TYPE, l4Name, l4Set);
            AroundProductList.add(cd);
        }
        resultMap.put("AroundProductList", AroundProductList);
        resultMap.put("valueList", valueList);
        return R.ok().put("data",resultMap);
    }

    /**
     * 保存图片
     * @author tanxin
     * @param productItemList
     * @param imgList
     */
    private void setImg(List<GoodItemView> productItemList, List<GoodItemImageEntity> imgList) {
        for (GoodItemView productItem : productItemList) {
            // 条目id
            Integer itemId = productItem.getProductItemId();
            if (imgList != null && imgList.size() > 0) {
                for (GoodItemImageEntity productItemImage : imgList) {
                    // 条目id
                    Integer iId = productItemImage.getProductItemId();
                    Integer piId = productItemImage.getProductItemImageId();
                    if (iId.equals(itemId)) {
                        int i = 0;
                        for (GoodItemImageEntity img : productItem.getImgList()) {
                            if (img.getProductItemImageId().equals(piId)) {
                                break;
                            }
                            i++;
                        }
                        if (i == productItem.getImgList().size()) {
                            productItem.getImgList().add(productItemImage);
                        }
                    }
                }
            }
        }
    }

    @Override
    public R deleteAroundItemByProductId(Integer productId , String productType) {
        if (productId==null || productType==null){
            return  R.error("参数丢失");
        }
        baseMapper.deleteByProductId(productId, productType);
        return R.ok();
    }

    /**
     * 修改周边配置上下架
     *
     * @param itemId
     * @param itemStatus
     * @return
     */
    @Override
    public R upOrDownItem(Integer itemId, Integer itemStatus) {
        GoodItemEntity productItem = baseMapper.selectById(itemId);
        if (productItem == null) {
            return R.error("数据不存在");
        }
        productItem.setIsUse(itemStatus);
        Integer count = baseMapper.updateById(productItem);
        return R.ok();
    }
    /**
     * 删除周边配置信息
     *
     * @param itemId
     * @return
     */
    @Override
    public R deleteAroundItem(Integer itemId) {
        if (itemId == null) {
            return R.error("参数丢失");
        }
        GoodItemEntity productItem = baseMapper.selectById(itemId);
        if (productItem == null) {
            return R.error("数据不存在");
        }
        productItem.setIsDeleted(1);
        Integer count = baseMapper.updateById(productItem);
        return R.ok();
    }

    @Override
    public R reduceStock(String jsonStr) {
        log.info("周边商品支付完成减少库存++++jsonStr:[{}]",jsonStr);
        if (StringUtils.isBlank(jsonStr)){
            return R.error("参数丢失");
        }
        List<OrderDetail> orderDetailList=new ArrayList<OrderDetail>();
        try {
            orderDetailList=JSONObject.parseObject(jsonStr,new TypeReference<List<OrderDetail>>(){});
        }catch (Exception e){
            e.printStackTrace();
            return R.error("json转换异常");
        }
        Boolean isFlag=true;
        StringBuffer sb=new StringBuffer();
        sb.append("库存修改失败：");
        for (OrderDetail detail : orderDetailList ){
            Map<String,Object> map=new HashMap<String,Object>();
            map.put("productId",detail.getProductId());
            map.put("level1Type",detail.getTip1());
            map.put("level2Type",detail.getTip2());
            map.put("level3Type",detail.getTip3());
            map.put("level4Type",detail.getTip4());
            GoodItemEntity item = baseMapper.selectByProductIdAndTips(map);
            if ( item != null ){
                log.info("获取库存量sum:{}",item.getInventory());
                log.info("购买数量num:{}",detail.getNum());
                Integer sum = (item.getInventory() - (detail.getNum() == null ? 0 : detail.getNum())) < 0 ? 0
                        : (item.getInventory() - (detail.getNum() == null ? 0 : detail.getNum()));
                log.info("当前库存sum:{}",sum);
                item.setInventory(sum);
                baseMapper.updateById(item);
            }else {
                isFlag=false;
                sb.append("订单id：").append(detail.getOrderId()).append("商品名称和配置：").append(detail.getName()).append("-").append(detail.getItemStr()).append("----;");
            }
        }
        if (isFlag){
            return R.ok();
        }else {
            log.info("部分库存修改失败：{}",sb);
            return R.error(sb.toString());
        }
    }
    
    @Override
	public List<GoodItemVO> selectListVO(Wrapper<GoodItemEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public GoodItemVO selectVO( Wrapper<GoodItemEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<GoodItemView> selectListView(Wrapper<GoodItemEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GoodItemView selectView(Wrapper<GoodItemEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    /**
     * 修改周边商品配置
     *
     * @param productItemStr
     * @return
     */
    @Override
    public R updateAroundItem(String productItemStr) {
        if (productItemStr == null) {
            return R.error("参数丢失");
        }
        GoodItemModel productItem = null;
        try {
            productItem = JSONObject.parseObject(productItemStr, new TypeReference<GoodItemModel>() {
            });
        } catch (Exception e) {
            e.printStackTrace();
            log.info("json解析异常");
            return R.error("json解析异常");
        }
        if (productItem == null) {
            return R.error("参数丢失");
        }
        GoodItemEntity item = baseMapper.findById(productItem.getProductItemId());
        if (item == null) {
            return R.error("数据不存在");
        }
        if (StringUtils.isBlank(productItem.getProductCode())) {
            return R.error("商品编号不能为空");
        }
        //判断周边商品编号是否与别的商品关联
        List<GoodItemEntity> itemCheckList = baseMapper.checkProductCode(productItem);
        if (itemCheckList != null && itemCheckList.size() > 0) {
            StringBuffer sb = new StringBuffer();
            sb.append("商品编号“").append(productItem.getProductCode()).append("”已存在");
            return R.error( sb.toString());
        }
        //把productCode存进要修改的数据中
        item.setProductCode(productItem.getProductCode());
        item.setInventory(productItem.getInventory());
        //把可能修改的信息赋值进数据中
        if (productItem.getLevel1Type() != null) {
            item.setLevel1Type(productItem.getLevel1Type());
        }
        if (productItem.getLevel2Type() != null) {
            item.setLevel2Type(productItem.getLevel2Type());
        }
        if (productItem.getLevel3Type() != null) {
            item.setLevel3Type(productItem.getLevel3Type());
        }
        if (productItem.getPrice() != null) {
            item.setPrice(productItem.getPrice());
        }
        Integer count = baseMapper.updateById(item);
        return R.ok();
    }

    /**
     * 新增周边商品信息
     *
     * @param productItemStr
     * @return
     */
    @Override
    public R saveAroundItem(String productItemStr) {
        GoodItemEntity productItem = null;
        try {
            productItem = JSONObject.parseObject(productItemStr, new TypeReference<GoodItemEntity>() {
            });
        } catch (Exception e) {
            e.printStackTrace();
            log.info("json解析异常");
            return R.error("json解析异常");
        }
        if (productItem == null || productItem.getProductId() == null) {
            return R.error("参数丢失");
        }
        GoodEntity product = goodService.selectById(productItem.getProductId());
        if (product == null) {
            return R.error("商品不存在");
        }
        if (StringUtils.isBlank(productItem.getProductCode())) {
            return R.error("商品编号不能为空");
        }
        //根据id生成当前商品内的唯一编号，此编号未被修改的情况下不允许新建新的栏目
        productItem.setProductCode(productItem.getProductCode() + "-" + productItem.getProductId());
        //判断周边商品编号是否存在
        List<GoodItemEntity> itemCheckList = baseMapper.checkProductCode(productItem.getModel());
        if (itemCheckList != null && itemCheckList.size() > 0) {
            StringBuffer sb = new StringBuffer();
            sb.append("商品编号“").append(productItem.getProductCode()).append("”已存在");
            return R.error(sb.toString());
        }
        //初始化配置信息
        productItem.setProductItemId(null);
        productItem.setIsDeleted(0);
        productItem.setIsUse(1);
        productItem.setType("1");
        Integer productItemId = baseMapper.insert(productItem);
        return R.ok().put("data",productItem);
    }

    /**
     * 根据周边商品配置信息查询周边商品图片库存等信息
     * @param itemView
     * @return
     */
    @Override 
    public R getProductImg(GoodItemView itemView) {
        List<Map<String,Object>> mapList= baseMapper.getProductImg(itemView);
        return R.ok().put("data",mapList);
    }

    /**
     * 联动查询商品配置信息，
     * @param productId
     * @param itemStr
     * @param type
     * @return
     */
    @Override 
    public R getProductLevelType(Integer productId, String itemStr, Integer type) {
        List<Object> resultList= new ArrayList <Object>() ;
        if (type==1){
            //先查询商品是否存在
            GoodEntity pro = goodService.selectById(productId);
            if (pro==null){
                return R.error("商品不存在");
            }
            String subtype = pro.getGoodName(),subtype2 = pro.getContent(),itemLevel1Name=pro.getTip1(),itemLevel2Name=pro.getTip2(),itemLevel3Name=pro.getTip3(),itemLevel4Name=pro.getTip4();
            GoodItemEntity productItem=new GoodItemEntity();
            productItem.setProductId(productId);
            //判断itemstr是否存在
            if (StringUtils.isNotBlank(itemStr)){
                //如果初始传了值
                Map<String, Object> productMap = JSONUtils.jsonToMap(itemStr);
                if(org.apache.commons.lang3.StringUtils.isNotBlank(itemLevel1Name) && !"null".equals(itemLevel1Name))  {
                    String itemLevel1NameValue = String.valueOf(productMap.get(itemLevel1Name));
                    if(itemLevel1NameValue != null && !"null".equals(itemLevel1NameValue) && org.apache.commons.lang3.StringUtils
                            .isNotBlank(itemLevel1NameValue)) {
                        productItem.setLevel1Type(itemLevel1NameValue);
                    }
                }
                if(org.apache.commons.lang3.StringUtils.isNotBlank(itemLevel2Name) && !"null".equals(itemLevel2Name))  {
                    String itemLevel2NameValue = String.valueOf(productMap.get(itemLevel2Name));
                    if(itemLevel2NameValue != null && !"null".equals(itemLevel2NameValue) && StringUtils
                            .isNotBlank(itemLevel2NameValue)) {
                        productItem.setLevel2Type(itemLevel2NameValue);
                    }
                }
                if(org.apache.commons.lang3.StringUtils.isNotBlank(itemLevel3Name) && !"null".equals(itemLevel3Name))  {
                    String itemLevel3NameValue = String.valueOf(productMap.get(itemLevel3Name));
                    if(itemLevel3NameValue != null && !"null".equals(itemLevel3NameValue) && StringUtils.isNotBlank(itemLevel3NameValue)) {
                        productItem.setLevel3Type(itemLevel3NameValue);
                    }
                }
                if(org.apache.commons.lang3.StringUtils.isNotBlank(itemLevel4Name) && !"null".equals(itemLevel4Name))  {
                    String itemLevel4NameValue = String.valueOf(productMap.get(itemLevel4Name));
                    if(itemLevel4NameValue != null && !"null".equals(itemLevel4NameValue) && StringUtils.isNotBlank(itemLevel4NameValue)) {
                        productItem.setLevel4Type(itemLevel4NameValue);
                    }
                }
                //一个配置都没有传递
                if (StringUtils.isBlank(productItem.getLevel1Type()) && StringUtils.isBlank(productItem.getLevel2Type()) && StringUtils.isBlank(productItem.getLevel3Type())){
                    GoodItemEntity p=new GoodItemEntity();
                    p.setProductId(productId);
                    //不存在时展示全部的第一个配置,并默认选择一个第一配置来查询第二第三配置
                    List<GoodItemEntity> itemListLv1=baseMapper.getProductItemLv(p);
                    Set<String> configLv1Set=new HashSet<String>();
                    for (GoodItemEntity item:itemListLv1){
                        configLv1Set.add(item.getLevel1Type());
                    }
                    AroundDetailVo detailVoLv1=new AroundDetailVo(Constant.ITEM_LEVEL1_NAME,Constant.LEVEL1_TYPE,(StringUtils.isNotBlank(itemLevel1Name) && !"null".equals(itemLevel1Name))?itemLevel1Name:null,
                            (StringUtils.isNotBlank(itemLevel1Name) && !"null".equals(itemLevel1Name))?new ArrayList <String>(configLv1Set):null);
                    if (detailVoLv1.getTitle()!=null){
                        resultList.add(detailVoLv1);
                    }
                    //判断第一配置是否存在
                    if (detailVoLv1.getSelectList() != null &&detailVoLv1.getSelectList().size()>0){
                        p.setLevel1Type(detailVoLv1.getSelectList().get(0));
                    }
                    List<GoodItemEntity> itemListLv2=baseMapper.getProductItemLv(p);
                    Set<String> configLv2Set=new HashSet<String>();
                    for (GoodItemEntity item:itemListLv2){
                        configLv2Set.add(item.getLevel2Type());
                    }
                    AroundDetailVo detailVoLv2=new AroundDetailVo(Constant.ITEM_LEVEL2_NAME,Constant.LEVEL2_TYPE,
                            (StringUtils.isNotBlank(itemLevel2Name) && !"null".equals(itemLevel2Name))?itemLevel2Name:null,
                            (StringUtils.isNotBlank(itemLevel2Name) && !"null".equals(itemLevel2Name))?(new ArrayList <String>(configLv2Set)):null);
                    if (detailVoLv2.getTitle()!=null){
                        resultList.add(detailVoLv2);
                    }
                    //判断第二配置是否存在
                    if (detailVoLv2.getSelectList() != null &&detailVoLv2.getSelectList().size()>0){
                        p.setLevel2Type(detailVoLv2.getSelectList().get(0));
                    }
                    List<GoodItemEntity> itemListLv3=baseMapper.getProductItemLv(p);
                    Set<String> configLv3Set=new HashSet<String>();
                    for (GoodItemEntity item:itemListLv3){
                        configLv3Set.add(item.getLevel3Type());
                    }
                    AroundDetailVo detailVoLv3=new AroundDetailVo(Constant.ITEM_LEVEL3_NAME,Constant.LEVEL3_TYPE,
                            (StringUtils.isNotBlank(itemLevel3Name) && !"null".equals(itemLevel3Name))?itemLevel3Name:null,
                            (StringUtils.isNotBlank(itemLevel3Name) && !"null".equals(itemLevel3Name))?new ArrayList <String>(configLv3Set):null);
                    if (detailVoLv3.getTitle()!=null){
                        resultList.add(detailVoLv3);
                    }
                    //给了第一个配置，二三没有给的情况
                }else if (StringUtils.isNotBlank(productItem.getLevel1Type()) && StringUtils.isBlank(productItem.getLevel2Type()) && StringUtils.isBlank(productItem.getLevel3Type())){
                    GoodItemEntity p = new GoodItemEntity();
                    p.setProductId(productId);
                    List<GoodItemEntity> itemListLv1=baseMapper.getProductItemLv(p);
                    Set<String> configLv1Set=new HashSet<String>();
                    for (GoodItemEntity item:itemListLv1){
                        configLv1Set.add(item.getLevel1Type());
                    }
                    AroundDetailVo detailVoLv1=new AroundDetailVo(Constant.ITEM_LEVEL1_NAME,Constant.LEVEL1_TYPE,(StringUtils.isNotBlank(itemLevel1Name) && !"null".equals(itemLevel1Name))?itemLevel1Name:null,
                            (StringUtils.isNotBlank(itemLevel1Name) && !"null".equals(itemLevel1Name))?new ArrayList <String>(configLv1Set):null);
                    if (detailVoLv1.getTitle()!=null){
                        resultList.add(detailVoLv1);
                    }
                    //把传递过来的第一配置放进条件中
                    p.setLevel1Type(productItem.getLevel1Type());

                    List<GoodItemEntity> itemListLv2=baseMapper.getProductItemLv(p);
                    Set<String> configLv2Set=new HashSet<String>();
                    for (GoodItemEntity item:itemListLv2){
                        configLv2Set.add(item.getLevel2Type());
                    }
                    AroundDetailVo detailVoLv2=new AroundDetailVo(Constant.ITEM_LEVEL2_NAME,Constant.LEVEL2_TYPE,
                            (StringUtils.isNotBlank(itemLevel2Name) && !"null".equals(itemLevel2Name))?itemLevel2Name:null,
                            (StringUtils.isNotBlank(itemLevel2Name) && !"null".equals(itemLevel2Name))?(new ArrayList <String>(configLv2Set)):null);
                    if (detailVoLv2.getTitle()!=null){
                        resultList.add(detailVoLv2);
                    }
                    //判断第二配置是否存在
                    if (detailVoLv2.getSelectList() != null && detailVoLv2.getSelectList().size()>0){
                        p.setLevel2Type(detailVoLv2.getSelectList().get(0));
                    }
                    List<GoodItemEntity> itemListLv3=baseMapper.getProductItemLv(p);
                    Set<String> configLv3Set=new HashSet<String>();
                    for (GoodItemEntity item:itemListLv3){
                        configLv3Set.add(item.getLevel3Type());
                    }
                    AroundDetailVo detailVoLv3=new AroundDetailVo(Constant.ITEM_LEVEL3_NAME,Constant.LEVEL3_TYPE,
                            (StringUtils.isNotBlank(itemLevel3Name) && !"null".equals(itemLevel3Name))?itemLevel3Name:null,
                            (StringUtils.isNotBlank(itemLevel3Name) && !"null".equals(itemLevel3Name))?new ArrayList <String>(configLv3Set):null);
                    if (detailVoLv3.getTitle()!=null){
                        resultList.add(detailVoLv3);
                    }
                }else  {
                    //给了第一个、二个配置，三没有给的情况   && 都给了的情况，返回参数一样
                    GoodItemEntity p = new GoodItemEntity();
                    p.setProductId(productId);
                    List<GoodItemEntity> itemListLv1=baseMapper.getProductItemLv(p);
                    Set<String> configLv1Set=new HashSet<String>();
                    for (GoodItemEntity item:itemListLv1){
                        configLv1Set.add(item.getLevel1Type());
                    }
                    AroundDetailVo detailVoLv1=new AroundDetailVo(Constant.ITEM_LEVEL1_NAME,Constant.LEVEL1_TYPE,(StringUtils.isNotBlank(itemLevel1Name) && !"null".equals(itemLevel1Name))?itemLevel1Name:null,
                            (StringUtils.isNotBlank(itemLevel1Name) && !"null".equals(itemLevel1Name))?new ArrayList <String>(configLv1Set):null);
                    if (detailVoLv1.getTitle()!=null){
                        resultList.add(detailVoLv1);
                    }
                    //把传递过来的第一配置放进条件中
                    p.setLevel1Type(productItem.getLevel1Type());

                    List<GoodItemEntity> itemListLv2=baseMapper.getProductItemLv(p);
                    Set<String> configLv2Set=new HashSet<String>();
                    for (GoodItemEntity item:itemListLv2){
                        configLv2Set.add(item.getLevel2Type());
                    }
                    AroundDetailVo detailVoLv2=new AroundDetailVo(Constant.ITEM_LEVEL2_NAME,Constant.LEVEL2_TYPE,
                            (StringUtils.isNotBlank(itemLevel2Name) && !"null".equals(itemLevel2Name))?itemLevel2Name:null,
                            (StringUtils.isNotBlank(itemLevel2Name) && !"null".equals(itemLevel2Name))?(new ArrayList <String>(configLv2Set)):null);
                    if (detailVoLv2.getTitle()!=null){
                        resultList.add(detailVoLv2);
                    }
                    //把第二层的值传进去
                    p.setLevel2Type(productItem.getLevel2Type());
                    List<GoodItemEntity> itemListLv3=baseMapper.getProductItemLv(p);
                    Set<String> configLv3Set=new HashSet<String>();
                    for (GoodItemEntity item:itemListLv3){
                        configLv3Set.add(item.getLevel3Type());
                    }
                    AroundDetailVo detailVoLv3=new AroundDetailVo(Constant.ITEM_LEVEL3_NAME,Constant.LEVEL3_TYPE,
                            (StringUtils.isNotBlank(itemLevel3Name) && !"null".equals(itemLevel3Name))?itemLevel3Name:null,
                            (StringUtils.isNotBlank(itemLevel3Name) && !"null".equals(itemLevel3Name))?new ArrayList <String>(configLv3Set):null);
                    if (detailVoLv3.getTitle()!=null){
                        resultList.add(detailVoLv3);
                    }
                }
            }

        }
        return R.ok().put("data",resultList);
    }

    @Override
    public List<GoodItemView> listProductItemByCondition(Integer productId, String level1Type, String level2Type,
                                                            String level3Type, String level4Type, String level5Type, String level6Type, String level7Type,
                                                            Integer type) {
        return null;
    }
}
