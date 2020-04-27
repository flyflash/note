package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.dao.PaymentMapper;
import com.atguigu.springcloud.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author zbh
 * @Date 2020-04-06
 * <p>Description:</p>
 */

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentMapper paymentMapper;

    @Override
    public int create(Payment payment) {
        return paymentMapper.create(payment);
    }

    @Override
    public Payment getPaymentById(long id) {
        return paymentMapper.getPaymentById(id);
    }
}
