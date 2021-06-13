//package com.bobocai.config;
//
//import org.springframework.cloud.gateway.route.RouteLocator;
//import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * 配置网关转发规则，
// * 但是现在大部分直接使用配置文件的方式来实现网关的转发功能
// * 所以这里将会被注释掉，作为了解
// */
//@Configuration
//public class GateWayConfig {
//
//    @Bean
//    public RouteLocator getRouter(RouteLocatorBuilder builder){
//        return builder.routes()
//                .route("user_router",r->r.path("/user/**").uri("http://localhost:8031"))//配置user对象的访问规则,
//                .route("order_rouer",r->r.path("/order/**").uri("http://localhost:8041"))//配置order对象的访问规则,
//                .build();//
//    }
//}
