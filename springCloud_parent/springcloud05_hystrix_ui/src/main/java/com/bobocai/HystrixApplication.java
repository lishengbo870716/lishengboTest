package com.bobocai;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;

@SpringBootApplication//springboot启动器
@EnableDiscoveryClient//注册使用的注解
@EnableHystrixDashboard//开启hystrix的Dashboard组件主要就是ui展示，各组件状态是否正常
public class HystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixApplication.class);
    }

}
