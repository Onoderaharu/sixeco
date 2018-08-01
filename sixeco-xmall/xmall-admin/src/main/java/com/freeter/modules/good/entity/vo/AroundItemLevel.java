package com.freeter.modules.good.entity.vo;

/**
 * @author liujun
 * @create 2018-06-23 12:54
 **/
public class AroundItemLevel {
    
    private String levelType;//配置名
    private String levelStatus;//配置上下架状态

    public AroundItemLevel(String levelType, String levelStatus) {
        this.levelType = levelType;
        this.levelStatus = levelStatus;
    }

    public AroundItemLevel() {
    }

    @Override
    public boolean equals(Object o) {
        if ( this == o ) return true;
        if ( o == null || getClass ( ) != o.getClass ( ) ) return false;

        AroundItemLevel that = (AroundItemLevel) o;

        if ( levelType != null ? ! levelType.equals ( that.levelType ) : that.levelType != null ) return false;
        return levelStatus != null ? levelStatus.equals ( that.levelStatus ) : that.levelStatus == null;
    }

    @Override
    public int hashCode() {
        int result = levelType != null ? levelType.hashCode ( ) : 0;
        result = 31 * result + ( levelStatus != null ? levelStatus.hashCode ( ) : 0 );
        return result;
    }

    public String getLevelType() {
        return levelType;
    }

    public void setLevelType(String levelType) {
        this.levelType = levelType;
    }

    public String getLevelStatus() {
        return levelStatus;
    }

    public void setLevelStatus(String levelStatus) {
        this.levelStatus = levelStatus;
    }
}
