package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.CommonResult;
import com.atguigu.springcloud.Payment;
import com.atguigu.springcloud.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @Author zbh
 * @Date 2020-04-06
 * <p>Description:</p>
 */

@RestController
@Slf4j
public class OrderController {

//    private static final String PAYMENT_URL = "http://localhost:8001"; 单机
    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private LoadBalancer loadBalancer;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/consumer/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        log.info("请求参数： {}", payment);
        return restTemplate.postForObject(PAYMENT_URL + "payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") long id){
        log.info("请求参数：{}", id);
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/"+ id, CommonResult.class);
    }

    @RequestMapping("/consumer/payment/lb")
    public String lb(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if(instances == null || instances.size() <= 0){
            return null;
        }

        ServiceInstance instance = loadBalancer.INSTANCE(instances);
        URI uri = instance.getUri();

        return restTemplate.getForObject(uri + "/payment/lb", String.class);
    }

    @RequestMapping("/consumer/payment/zipkin")
    public String zipkin(){
        return restTemplate.getForObject("http://localhost:8001/payment/zipkin", String.class);
    }
}
