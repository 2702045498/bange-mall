package com.bange.order;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@EnableDubbo
@EnableDiscoveryClient
@SpringBootApplication
public class OrderProviderApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(OrderProviderApplication.class,args);
    }
}
