package com.bange.mall.service;


import com.bange.mall.entity.SystemUser;
import com.bange.mall.entity.UserAddress;

public interface UserService {
    // 获取用户地址
    UserAddress getUserAddr(Integer userId);

   int  save(SystemUser user);


}
