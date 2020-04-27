package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Author zbh
 * @Date 2020-04-07
 * <p>Description:</p>
 */

@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("payment/consul")
    public String payment(){
        return "springCloud with consul:" + serverPort + "\t" + UUID.randomUUID().toString();
    }

}
