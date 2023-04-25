package com.bange.mall.entity.system;

import java.io.Serializable;

/**
 * 
 */
public class SysUserRole implements Serializable {
    private Integer id;

    private Integer roleId;

    private Long userId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}