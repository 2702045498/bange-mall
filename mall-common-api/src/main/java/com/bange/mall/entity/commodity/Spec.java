package com.bange.mall.entity.commodity;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 
 */
public class Spec implements Serializable {
    private Long id;

    private String specCode;

    private String specName;

    private String markImg;

    private Integer displayMark;

    private Long commodityId;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpecCode() {
        return specCode;
    }

    public void setSpecCode(String specCode) {
        this.specCode = specCode;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public String getMarkImg() {
        return markImg;
    }

    public void setMarkImg(String markImg) {
        this.markImg = markImg;
    }

    public Integer getDisplayMark() {
        return displayMark;
    }

    public void setDisplayMark(Integer displayMark) {
        this.displayMark = displayMark;
    }

    public Long getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Long commodityId) {
        this.commodityId = commodityId;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
}