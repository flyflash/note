package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.CommonResult;
import com.atguigu.springcloud.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author zbh
 * @Date 2020-04-06
 * <p>Description:</p>
 */

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/payment/create")
    public CommonResult<Integer> create(@RequestBody Payment payment){
        int result = paymentService.create(payment);

        if(result > 0){
            log.info("插入成功");
            return new CommonResult<>(200, "插入成功 端口号：" + serverPort, result);
        } else {
            log.error("插入失败");
            return new CommonResult<Integer>(444, "插入失败 端口号：" + serverPort, null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id") long id){
        log.info("【请求参数】: {}", id);
        Payment payment = paymentService.getPaymentById(id);

        if(payment != null){
            log.info("查询成功");
            return new CommonResult<>(200, "查询成功 端口号：" + serverPort, payment);
        }else {
            log.error("查询失败");
            return new CommonResult<>(444, "查询失败 端口号：" + serverPort, null);
        }
    }

    @GetMapping("/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for(String element : services){
            log.info("*********element：" + element);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances){
            log.info(instance.getInstanceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }

        return this.discoveryClient;
    }

    @RequestMapping("/payment/lb")
    public String lb(){
        return serverPort;
    }

    @RequestMapping("/payment/zipkin")
    public String zipkin(){
        return "hi, I'm zipkin";
    }
}
