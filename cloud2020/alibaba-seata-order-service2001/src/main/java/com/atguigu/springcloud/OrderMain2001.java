package com.atguigu.springcloud;

import cn.hutool.db.sql.Order;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author zbh
 * @Date 2020-04-18
 * <p>Description:</p>
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})//禁用默认的自动配置数据源类
@EnableDiscoveryClient
@EnableFeignClients
public class OrderMain2001 {

    public static void main(String[] args) {
        SpringApplication.run(OrderMain2001.class, args);
    }
}
