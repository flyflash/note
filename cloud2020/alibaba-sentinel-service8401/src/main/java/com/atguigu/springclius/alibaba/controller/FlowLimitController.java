package com.atguigu.springclius.alibaba.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zbh
 * @Date 2020-04-16
 * <p>Description:</p>
 */

@RestController
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA(){
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB(){
        return "------testB";
    }
}
