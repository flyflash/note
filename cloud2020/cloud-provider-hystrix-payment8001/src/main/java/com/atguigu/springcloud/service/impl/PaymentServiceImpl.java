package com.atguigu.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.atguigu.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Author zbh
 * @Date 2020-04-08
 * <p>Description:</p>
 */

@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public String payment_ok(int id) {
        return "线程池：" + Thread.currentThread().getName() + "  payment_ok,id=" + id;
    }

    @Override
    @HystrixCommand(fallbackMethod = "payment_timeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
    })
    public String payment_timeout(int id) {
        int timeout = 3;
        try {
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + "  payment_timeout,id=" + id;
    }

    public String payment_timeoutHandler(int id) {
        return "线程池：" + Thread.currentThread().getName() + "  payment_timeoutHandler,id=" + id;
    }


    // 服务熔断
    @Override
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), // 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), // 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60") // 失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(int id){
        if (id < 0){
            throw new RuntimeException("**********id不能为负数");
        }

        String simpleUUID = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "调用成功，流水号：" + simpleUUID;
    }

    public String paymentCircuitBreaker_fallback(int id){
        return "id不能为负数，请稍后重试······ id:" + id;
    }
}
