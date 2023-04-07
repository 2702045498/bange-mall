package com.bange.user.service.impl;

import com.bange.mall.entity.SystemUser;
import com.bange.mall.entity.UserAddress;
import com.bange.mall.service.UserService;
import com.bange.user.mapper.SystemUserMapper;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@DubboService
public class UserServiceImpl  implements UserService {
    @Autowired
    SystemUserMapper systemUserMapper;

    @Override
    public UserAddress getUserAddr(Integer userId) {
        Optional<SystemUser> systemUser = systemUserMapper.selectByPrimaryKey(1l);
        System.out.println("==>"+systemUser);
        return new UserAddress(1,20,"北京市");
    }

    @Override
    public int save(SystemUser user) {
        return systemUserMapper.insert(user);
    }


}
