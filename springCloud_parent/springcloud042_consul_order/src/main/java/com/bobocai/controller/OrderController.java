package com.bobocai.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "")
public class OrderController {
    @RequestMapping(value = "gitOrder")
    public String gitOrder(){
        System.out.println("进入订单");
        return "进入订单端口为：8042";
    }
}
