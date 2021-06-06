package com.bobocai.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "")
public class UserController {
    @RequestMapping(value = "user")
    public String gitUser(){
        System.out.println("进入user方法");
        //通过RestTemplate调用接口
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8041/gitOrder";
        ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);
        System.out.println("返回结果是"+forEntity.toString());
        return "返回";
    }
}
