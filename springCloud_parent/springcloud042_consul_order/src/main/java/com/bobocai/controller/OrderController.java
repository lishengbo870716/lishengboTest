package com.bobocai.controller;

import com.bobocai.vo.OrderVo;
import com.bobocai.vo.TestListVo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "order")
public class OrderController {

    @Value("${server.port}")
    private String post;


    @RequestMapping(value = "gitOrder")
    public String gitOrder(){
        System.out.println("进入订单");
        return "进入订单端口为：8041";
    }
    @GetMapping("queryString")
    public String queryString(String name,Integer age){
        return "输入的名称是："+name+"\n年龄是："+age+"\n对应的端口是："+post;
    }

    @GetMapping("queryString/{name}/{age}")
    public String queryStringPath(@PathVariable("name") String name, @PathVariable("age") Integer age){
        return "输入的名称是："+name+"\n年龄是："+age+"\n对应的端口是："+post;
    }
    @PostMapping("queryStringVo")
    public String queryStringVo(@RequestBody OrderVo order){
        return order.toString()+"\n对应的端口是："+post;
    }

    @PostMapping("getTestListVo")
    @HystrixCommand(fallbackMethod = "fallbackMethod",defaultFallback = "morenfangfa")//这个注解fallbackMethod它指向的是针对这个方法的具体返回异常信息，defaultFallback他执行的是类上的默认异常返回对象
    public TestListVo getTestListVo(TestListVo testListVo){
        System.out.println("进入："+post);
        testListVo.setName("李四");
        List<String> list = new ArrayList<>();
        list.add("4");
        list.add("5");
        testListVo.setList(list);
        return testListVo;
    }

    public TestListVo fallbackMethod(TestListVo testListVo){
        testListVo.setName("服务已经熔断");
        return testListVo;
    }
    public TestListVo morenfangfa(TestListVo testListVo){
        testListVo.setName("默认执行的方法");
        return testListVo;
    }

}
