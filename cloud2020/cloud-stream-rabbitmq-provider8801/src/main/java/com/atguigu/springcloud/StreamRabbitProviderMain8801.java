package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author zbh
 * @Date 2020-04-13
 * <p>Description:</p>
 */

@SpringBootApplication
@EnableEurekaClient
public class StreamRabbitProviderMain8801 {

    public static void main(String[] args) {
        SpringApplication.run(StreamRabbitProviderMain8801.class, args);
    }
}
