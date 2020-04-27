package com.atguigu.springcloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zbh
 * @Date 2020-04-13
 * <p>Description:</p>
 */

@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/payment/nacos")
    public String getServerPort(){
        return "serverPort: " + serverPort;
    }
}
