package com.bange.order.service.impl;

import com.bange.mall.entity.commodity.Brand;
import com.bange.mall.entity.order.CommodityOrder;
import com.bange.mall.entity.user.SysUser;
import com.bange.mall.service.IBrandService;
import com.bange.mall.service.IOrderService;
import com.bange.order.mapper.CommodityOrderDynamicSqlSupport;
import com.bange.order.mapper.CommodityOrderMapper;
import io.seata.spring.annotation.GlobalTransactional;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import java.math.BigDecimal;
import java.net.InetAddress;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

import static org.mybatis.dynamic.sql.SqlBuilder.*;

@DubboService
public class orderServiceImpl implements IOrderService {

    @Autowired
    CommodityOrderMapper commodityOrderMapper;

    @DubboReference
    IBrandService brandService;

//    @DubboReference
//    IUserService userService;


    @Override
    public CommodityOrder query(CommodityOrder commodityOrder) {

        return commodityOrderMapper.selectByPrimaryKey(commodityOrder.getCommodityId()).get();
    }

    @Override
    public List<CommodityOrder> queryList(CommodityOrder commodityOrder) {
        SelectStatementProvider statementProvider = select(CommodityOrderDynamicSqlSupport.id, CommodityOrderDynamicSqlSupport.orderNo)
                .from(CommodityOrderDynamicSqlSupport.commodityOrder)
                .where(CommodityOrderDynamicSqlSupport.id, isGreaterThan(0l))
                .orderBy(CommodityOrderDynamicSqlSupport.id)
                .build()
                .render(RenderingStrategies.MYBATIS3);
        return commodityOrderMapper.selectMany(statementProvider);
    }


    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ, rollbackFor = RuntimeException.class)
    @Override
    public int save(CommodityOrder commodityOrder) {
        return commodityOrderMapper.insert(commodityOrder);

    }

    @Override
    public int edit(CommodityOrder commodityOrder) {
        return commodityOrderMapper.updateByPrimaryKey(commodityOrder);
    }

    @Override
    public int remove(CommodityOrder commodityOrder) {
        return commodityOrderMapper.updateByPrimaryKey(commodityOrder);
    }

    @GlobalTransactional
    @Override
    public int createOrder() {
        try {
            System.out.println("==>进入createOrder方法");
            // 增加brand
            Brand brand = new Brand();
            brand.setBrandName("苹果");
            brandService.save(brand);
            //增加一个用户
            SysUser sysUser = null;
            String IP = InetAddress.getLocalHost().getHostAddress();
            sysUser = new SysUser();
            sysUser.setUserName("testuser03");
            sysUser.setEmail("123456@qq.com");
            sysUser.setAvator("http://localhost:9980/image01.png");
            sysUser.setDelFlag(0);
            sysUser.setGender(1);
            sysUser.setLoginTime(LocalDateTime.now());
            sysUser.setLoginIp(IP);
            sysUser.setPhone("15289005678");
            sysUser.setPwd("123456");
            sysUser.setCreateTime(LocalDateTime.now());
//            int save = userService.save(sysUser);

            //增加一个订单
            CommodityOrder commodityOrder = new CommodityOrder();
            String orderNo = "202302" + new Random().nextInt(3);
            commodityOrder.setOrderNo(orderNo);
            commodityOrder.setUserId(1l);
            commodityOrder.setOrderValidTime(LocalDateTime.now());
            commodityOrder.setCommodityId(new Random().nextLong());
            commodityOrder.setPayPrice(BigDecimal.valueOf(100.89));
            commodityOrder.setPayFlag(1);
            commodityOrder.setPayTime(LocalDateTime.now());
            commodityOrder.setUserAddrId(1l);
            commodityOrder.setActivityPrice(BigDecimal.valueOf(50.00));
            int save1 = commodityOrderMapper.insert(commodityOrder);
            System.out.println("==>执行完成createOrder方法");
                int i=1/0;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return 0;
    }
}
