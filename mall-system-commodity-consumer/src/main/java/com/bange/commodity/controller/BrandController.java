package com.bange.commodity.controller;

import com.bange.mall.entity.commodity.Brand;
import com.bange.mall.service.IBrandService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BrandController {

    @DubboReference
    IBrandService brandService;

    @RequestMapping("/save")
    public String save() {
        Brand brand = new Brand();
        brand.setBrandName("华为");
        brandService.save(brand);
        return " save ==> ok ";
    }

    @RequestMapping("/get")
    public String get() {
        Brand brand = new Brand();
        brand.setBrandName("华为");
        brand.setId(1);
        Brand query = brandService.query(brand);
        System.out.println("==>" + query);
        return "ok ";
    }
}
