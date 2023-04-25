package com.bange.mall.service;


import com.bange.mall.entity.user.SysUser;

import java.util.List;

public interface IUserService {
    SysUser query(SysUser sysUser);

    List<SysUser> queryList(SysUser sysUser);

    int save(SysUser sysUser);

    int edit(SysUser sysUser);

    int remove(SysUser sysUser);


}
