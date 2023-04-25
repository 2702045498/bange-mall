package com.bange.mall.entity.commodity;

import java.io.Serializable;

/**
 * 
 */
public class SpecAttrValue implements Serializable {
    private Long id;

    private Long specId;

    private Integer attrValueId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSpecId() {
        return specId;
    }

    public void setSpecId(Long specId) {
        this.specId = specId;
    }

    public Integer getAttrValueId() {
        return attrValueId;
    }

    public void setAttrValueId(Integer attrValueId) {
        this.attrValueId = attrValueId;
    }
}