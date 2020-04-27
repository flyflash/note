package com.atguigu.springcloud.service;

import com.atguigu.springcloud.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(@Param("id") long id);
}
