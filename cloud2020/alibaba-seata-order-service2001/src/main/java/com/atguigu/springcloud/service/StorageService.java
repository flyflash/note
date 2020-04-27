package com.atguigu.springcloud.service;

import com.atguigu.springcloud.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "seata-storage-service")
public interface StorageService {

    @GetMapping(value = "/storage/decr")
    public CommonResult decr(@RequestParam("commodityCode") String commodityCode,
                             @RequestParam("count") int count);

}
