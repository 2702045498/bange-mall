package com.bange.commodity.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommodityController {
    @RequestMapping("/get/{id}")
    public String getCommodity(int id){
        return "get-->commodity-"+id;
    }

}
