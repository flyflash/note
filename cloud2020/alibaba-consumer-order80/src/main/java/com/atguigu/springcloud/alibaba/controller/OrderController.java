package com.atguigu.springcloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author zbh
 * @Date 2020-04-13
 * <p>Description:</p>
 */
@RestController
public class OrderController {

    @Value("${server-url.nacos-user-service}")
    private String server_url;

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/nacos")
    public String getPayment(){
        return restTemplate.getForObject(server_url + "/payment/nacos", String.class);
    }
}
