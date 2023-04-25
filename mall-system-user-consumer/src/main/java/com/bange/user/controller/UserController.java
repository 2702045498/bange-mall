package com.bange.user.controller;

import com.bange.mall.entity.user.SysUser;
import com.bange.mall.service.IUserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;

@RestController
public class UserController {

    @DubboReference
    IUserService userService;

    @RequestMapping("/userAdderss")
    public String getUserAdderss(){
        SysUser sysUser = new SysUser();
                sysUser.setId(1l);
        SysUser res = userService.query(sysUser);
        System.out.println("==>"+res);
        return "res=>ok";
    }

    @RequestMapping("/saveuser")
    public String saveUser(){
        SysUser sysUser =null;
        try {
            String IP = InetAddress.getLocalHost().getHostAddress();
             sysUser = new SysUser();
            sysUser.setUserName("testuser02");
            sysUser.setEmail("123456@qq.com");
            sysUser.setAvator("http://localhost:9980/image01.png");
            sysUser.setDelFlag(0);
            sysUser.setGender(1);
            sysUser.setLoginTime(LocalDateTime.now());
            sysUser.setLoginIp(IP);
            sysUser.setPhone("15289005678");
            sysUser.setPwd("123456");
            sysUser.setCreateTime(LocalDateTime.now());
            int save = userService.save(sysUser);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        return sysUser.toString();
    }



}
