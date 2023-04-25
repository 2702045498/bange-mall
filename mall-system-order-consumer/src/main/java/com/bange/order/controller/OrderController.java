package com.bange.order.controller;

import com.bange.mall.entity.order.CommodityOrder;
import com.bange.mall.service.IOrderService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Random;


@RestController
public class OrderController {

    @DubboReference
    IOrderService orderService;


    @RequestMapping("/getOrder")
    public String getOrder(){
        CommodityOrder commodityOrder = new CommodityOrder();
        commodityOrder.setCommodityId(1l);
        commodityOrder.setOrderNo("0001222");
        return  orderService.query(commodityOrder).toString();
    }
    @RequestMapping("/save")
    public String save(){
        CommodityOrder commodityOrder = new CommodityOrder();
        String orderNo="202302"+ new Random().nextInt(3);
        commodityOrder.setOrderNo(orderNo);
        commodityOrder.setUserId(1l);
        commodityOrder.setOrderValidTime(LocalDateTime.now());
        commodityOrder.setCommodityId(1l);
        commodityOrder.setPayPrice(BigDecimal.valueOf(100.89));
        commodityOrder.setPayFlag(1);
        commodityOrder.setPayTime(LocalDateTime.now());
        commodityOrder.setUserAddrId(1l);
        commodityOrder.setActivityPrice(BigDecimal.valueOf(50.00));
        int save = orderService.save(commodityOrder);
        return "save->ok-commodityOrder";
    }

    @RequestMapping("/create")
    public String createOrder(){
        try {
            System.out.println("==>调用create方法");
            //增加一个订单
            CommodityOrder commodityOrder = new CommodityOrder();
            String orderNo="202302"+ new Random().nextInt(3);
            commodityOrder.setOrderNo(orderNo);
            commodityOrder.setUserId(1l);
            commodityOrder.setOrderValidTime(LocalDateTime.now());
            commodityOrder.setCommodityId(new Random().nextLong());
            commodityOrder.setPayPrice(BigDecimal.valueOf(100.89));
            commodityOrder.setPayFlag(1);
            commodityOrder.setPayTime(LocalDateTime.now());
            commodityOrder.setUserAddrId(1l);
            commodityOrder.setActivityPrice(BigDecimal.valueOf(50.00));
            int save1 = orderService.save(commodityOrder);
            return "ok==>create";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
    @RequestMapping("/addOrder")
    public String addOrder(){
        try {
            System.out.println("==>调用addOrder方法");
            //增加一个订单
            int order = orderService.createOrder();
            return "ok==>addOrder";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
