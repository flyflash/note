package com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author zbh
 * @Date 2020-04-07
 * <p>Description:</p>
 */

@Configuration
public class MySelfRule {

    @Bean
    public IRule iRule(){
        // 将默认的轮询策略替换为随机策略
        return new RandomRule();
    }
}
