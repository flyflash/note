package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.CommonResult;
import com.atguigu.springcloud.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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

    @RequestMapping("/payment/lb")
    public String lb(){
        return serverPort;
    }
}
