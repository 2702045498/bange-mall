package com.bange.mall.entity.commodity;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 
 */
public class Commodity implements Serializable {
    private Long id;

    private String commdityCode;

    private String commdityName;

    private String commdodityImg;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommdityCode() {
        return commdityCode;
    }

    public void setCommdityCode(String commdityCode) {
        this.commdityCode = commdityCode;
    }

    public String getCommdityName() {
        return commdityName;
    }

    public void setCommdityName(String commdityName) {
        this.commdityName = commdityName;
    }

    public String getCommdodityImg() {
        return commdodityImg;
    }

    public void setCommdodityImg(String commdodityImg) {
        this.commdodityImg = commdodityImg;
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