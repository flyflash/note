package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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
@DefaultProperties(defaultFallback = "payment_global_fallback")
public class OrderController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String ok(@PathVariable("id") int id){
        return paymentHystrixService.ok(id);
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "timeoutHandler", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
//    })
    @HystrixCommand
    public String timeout(@PathVariable("id") int id){
        return paymentHystrixService.timeout(id);
    }

    public String timeoutHandler(int id){
        return "对方支付系统繁忙， 请稍后重试";
    }

    public String payment_global_fallback(){
        return "global异常处理信息";
    }
}
