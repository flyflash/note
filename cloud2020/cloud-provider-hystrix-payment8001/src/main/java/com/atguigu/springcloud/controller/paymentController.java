package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author zbh
 * @Date 2020-04-08
 * <p>Description:</p>
 */

@RestController
public class paymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String ok(@PathVariable("id") int id){
        return paymentService.payment_ok(id);
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String timeout(@PathVariable("id") int id){
        return paymentService.payment_timeout(id);
    }

    // 服务熔断
    @GetMapping("/payment/circuit/{id}")
    public String circuit(@PathVariable("id") int id){
        return paymentService.paymentCircuitBreaker(id);
    }
}
