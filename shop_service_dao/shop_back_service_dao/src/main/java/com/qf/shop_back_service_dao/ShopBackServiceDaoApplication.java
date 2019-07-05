package com.qf.shop_back_service_dao;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.qf")
@DubboComponentScan("com.qf.service.impl")
@MapperScan("com.qf.dao")
public class ShopBackServiceDaoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopBackServiceDaoApplication.class, args);
    }

}
