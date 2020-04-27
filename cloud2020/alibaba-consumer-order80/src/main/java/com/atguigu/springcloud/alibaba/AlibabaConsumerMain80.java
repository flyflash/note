package com.atguigu.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author zbh
 * @Date 2020-04-13
 * <p>Description:</p>
 */

@SpringBootApplication
@EnableDiscoveryClient
public class AlibabaConsumerMain80 {

    public static void main(String[] args) {
        SpringApplication.run(AlibabaConsumerMain80.class, args);
    }
}
