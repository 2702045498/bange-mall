package com.bange.commodity;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@EnableDiscoveryClient
@EnableDubbo
@SpringBootApplication
public class CommodityProviderApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(CommodityProviderApplication.class,args);
    }
}
