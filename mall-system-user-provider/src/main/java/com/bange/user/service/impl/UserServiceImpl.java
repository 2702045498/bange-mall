package com.bange.user.service.impl;

import com.bange.mall.entity.user.SysUser;
import com.bange.mall.service.IUserService;
import com.bange.user.mapper.SysUserMapper;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@DubboService
public class UserServiceImpl  implements IUserService {
    @Autowired
    SysUserMapper sysUserMapper;

    @Override
    public SysUser query(SysUser sysUser) {
        return null;
    }

    @Override
    public List<SysUser> queryList(SysUser sysUser) {
        return null;
    }

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.REPEATABLE_READ,rollbackFor = RuntimeException.class)
    @Override
    public int save(SysUser sysUser) {
        return sysUserMapper.insert(sysUser);
    }

    @Override
    public int edit(SysUser sysUser) {
        return 0;
    }

    @Override
    public int remove(SysUser sysUser) {
        return 0;
    }
}
