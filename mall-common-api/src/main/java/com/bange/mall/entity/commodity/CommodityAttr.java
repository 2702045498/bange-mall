package com.bange.mall.entity.commodity;

import java.io.Serializable;

/**
 * 
 */
public class CommodityAttr implements Serializable {
    private Long id;

    private Long commdityId;

    private Integer attrId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCommdityId() {
        return commdityId;
    }

    public void setCommdityId(Long commdityId) {
        this.commdityId = commdityId;
    }

    public Integer getAttrId() {
        return attrId;
    }

    public void setAttrId(Integer attrId) {
        this.attrId = attrId;
    }
}