package com.bange.gen.model;

import java.io.Serializable;

/**
 * 
 */
public class SysRole implements Serializable {
    private Integer id;

    private String roleName;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}