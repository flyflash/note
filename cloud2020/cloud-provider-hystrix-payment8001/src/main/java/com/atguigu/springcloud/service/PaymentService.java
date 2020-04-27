package com.atguigu.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

public interface PaymentService {

    String payment_ok(int id);

    String payment_timeout(int id);

    String paymentCircuitBreaker(int id);
}
