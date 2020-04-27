package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zbh
 * @Date 2020-04-13
 * <p>Description:</p>
 */

@RefreshScope
@RestController
public class ConfigClientController3366 {

    @Value("${server.port}")
    private String serverPort;

    @Value("${config.info}")
    private String configInfo;

    @RequestMapping("/configInfo")
    public String getConfigInfo(){
        return "serverPort: " + serverPort + "\t" + "configInfo: " + configInfo;
    }
}
