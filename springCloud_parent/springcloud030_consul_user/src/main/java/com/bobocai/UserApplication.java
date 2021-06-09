package com.bobocai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication //springboot启动注解
@EnableDiscoveryClient//开启服务注册，consul的注解---这是一个spring提供的通用注册使用的注解，
@EnableFeignClients//开启openfign的的 服务调用  openfeign的jar报囊括了ribbon做负载
@EnableCircuitBreaker//开启hystrix注解
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class);
    }
}
