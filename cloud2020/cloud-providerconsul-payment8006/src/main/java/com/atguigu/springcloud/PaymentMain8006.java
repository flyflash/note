package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author zbh
 * @Date 2020-04-07
 * <p>Description:</p>
 */

@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain8006 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8006.class, args);
    }
}
