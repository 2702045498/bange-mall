package com.bange.user.controller;

import com.bange.mall.entity.SystemUser;
import com.bange.mall.entity.UserAddress;
import com.bange.mall.service.UserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;

@RestController
public class UserController {

    @DubboReference
    UserService userService;
    @RequestMapping("/userAdderss")
    public UserAddress getUserAdderss(){
        return userService.getUserAddr(1);
    }

    @RequestMapping("/saveuser")
    public String saveUser(){
        SystemUser systemUser =null;
        try {
            String IP = InetAddress.getLocalHost().getHostAddress();
             systemUser = new SystemUser();
            systemUser.setUserName("testuser01");
            systemUser.setNickName("测试用户1");
            systemUser.setEmail("123456@qq.com");
            systemUser.setUserStatus(1);
            systemUser.setAvatar("http://localhost:9980/image01.png");
            systemUser.setDelFlag(0);
            systemUser.setGender(1);
            systemUser.setLoginTime(LocalDateTime.now());
            systemUser.setLoginIp(IP);
            systemUser.setPhone("15289005678");
            systemUser.setPwd("123456");
            systemUser.setCreateTime(LocalDateTime.now());
            int save = userService.save(systemUser);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        return systemUser.toString();
    }



}
