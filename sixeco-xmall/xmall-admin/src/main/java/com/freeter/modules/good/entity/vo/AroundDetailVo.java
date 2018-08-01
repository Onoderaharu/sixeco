package com.freeter.modules.good.entity.vo;

import java.util.List;
import java.util.Set;

/**
 * @author liujun
 * @create 2018-06-21 17:04
 **/
public class AroundDetailVo {

    private String itemName;

    private String valueName;

    private String title;

    private Set<AroundItemLevel> select;
    
    private List<String> selectList;

    public AroundDetailVo(String itemName, String valueName, String title, Set<AroundItemLevel> select) {
        super();
        this.itemName = itemName;
        this.valueName = valueName;
        this.title = title;
        this.select = select;
    }
    public AroundDetailVo(String itemName, String valueName, String title, List<String> selectList) {
        super();
        this.itemName = itemName;
        this.valueName = valueName;
        this.title = title;
        this.selectList = selectList;
    }

    public AroundDetailVo() {
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getValueName() {
        return valueName;
    }

    public void setValueName(String valueName) {
        this.valueName = valueName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set <AroundItemLevel> getSelect() {
        return select;
    }

    public void setSelect(Set <AroundItemLevel> select) {
        this.select = select;
    }

    public List <String> getSelectList() {
        return selectList;
    }

    public void setSelectList(List <String> selectList) {
        this.selectList = selectList;
    }
}
