package com.bange.commodity.service.impl;

import com.bange.commodity.mapper.BrandDynamicSqlSupport;
import com.bange.commodity.mapper.BrandMapper;
import com.bange.mall.entity.commodity.Brand;
import com.bange.mall.service.IBrandService;
import org.apache.dubbo.config.annotation.DubboService;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.mybatis.dynamic.sql.SqlBuilder.select;


@DubboService
public class BrandServiceImpl implements IBrandService {

    @Autowired
    BrandMapper brandMapper;

    @Override
    public Brand query(Brand brand) {
        SelectStatementProvider statementProvider = select(BrandDynamicSqlSupport.id, BrandDynamicSqlSupport.brandName)
                .from(BrandDynamicSqlSupport.brand)
                .where(BrandDynamicSqlSupport.id, isEqualTo(1))
                .build()
                .render(RenderingStrategies.MYBATIS3);

        return brandMapper.selectOne(statementProvider).get();
    }

    @Override
    public List<Brand> queryList(Brand brand) {
        return null;
    }
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.REPEATABLE_READ,rollbackFor = RuntimeException.class)
    @Override
    public int save(Brand brand) {
        return brandMapper.insert(brand);
    }

    @Override
    public int edit(Brand brand) {
        return 0;
    }

    @Override
    public int remove(Brand brand) {
        return 0;
    }
}
