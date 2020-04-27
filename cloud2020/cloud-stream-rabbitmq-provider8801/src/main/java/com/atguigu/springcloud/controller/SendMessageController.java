package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author zbh
 * @Date 2020-04-13
 * <p>Description:</p>
 */

@RestController
public class SendMessageController {

    @Resource
    private IMessageProvider iMessageProvider;

    @GetMapping("sendMsg")
    public String send(){
        return iMessageProvider.send();
    }

}
