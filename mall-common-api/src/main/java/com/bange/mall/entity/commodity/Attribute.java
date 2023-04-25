package com.bange.mall.entity.commodity;

import java.io.Serializable;

/**
 * 
 */
public class Attribute implements Serializable {
    private Integer id;

    private String attrName;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }
}