package com.bobocai.config;


import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration  //代表这是一个springboot的配置类
public class BeansConfig {

    @Bean//将对象交给spring来管理，使用的时候直接加注解获取即可
    @LoadBalanced//开启ribbon负载均衡效果，加上这个注解，通过spring来实例化的RestTemplate对象将自动触发负载均衡效果
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
