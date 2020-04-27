package com.atguigu.cloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author zbh
 * @Date 2020-04-10
 * <p>Description:</p>
 */

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder){

        RouteLocatorBuilder.Builder routes = builder.routes();

        routes.route("path_route_atguigu", r->r.path("/guonei").uri("http://news.baidu.com/guonei")).build();

        return routes.build();
    }
}
