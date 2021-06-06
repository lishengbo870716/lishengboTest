package com.bobocai.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "")
public class UserController {
    @RequestMapping(value = "user")
    public String gitUser(){
        System.out.println("进入user方法");
        return "返回";
    }
}
