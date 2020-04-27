package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @Author zbh
 * @Date 2020-04-08
 * <p>Description:</p>
 */

@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String ok(int id) {
        return "----PaymentFallbackService  ok";
    }

    @Override
    public String timeout(int id) {
        return "----PaymentFallbackService  timeout";
    }
}
