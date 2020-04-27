package com.atguigu.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author zbh
 * @Date 2020-04-08
 * <p>Description:</p>
 */

@Configuration
public class FeignConfig {

    @Bean
    Logger.Level level(){
        return Logger.Level.FULL;
    }
}
