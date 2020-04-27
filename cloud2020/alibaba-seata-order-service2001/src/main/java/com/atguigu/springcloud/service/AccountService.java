package com.atguigu.springcloud.service;

import com.atguigu.springcloud.CommonResult;
import com.atguigu.springcloud.entities.TAccount;
import com.atguigu.springcloud.entities.TOrder;
import org.apache.ibatis.annotations.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "seata-account-service")
public interface AccountService {

    @GetMapping(value = "/account/decr")
    public CommonResult<TAccount> decr(@RequestParam("userId") String userId,
                                       @RequestParam("amount") double amount);
}
