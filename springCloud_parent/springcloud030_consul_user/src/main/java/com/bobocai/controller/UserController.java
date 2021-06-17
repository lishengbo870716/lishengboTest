package com.bobocai.controller;

import com.bobocai.feignClient.OrderClient;
import com.bobocai.vo.TestListVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController//这个注解同controller注解一样，只不过RestController相当于给每一个方法上都增加了一个@ResponseBody注解将结果直接以字符串的形式返回了
@RequestMapping(value = "user")
public class UserController {

    private final static Logger log = LoggerFactory.getLogger(UserController.class);


    @Autowired  //服务注册与发现服务对象
    private DiscoveryClient discoveryClient;
    @Autowired  //服务注册与发现服务对象
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    OrderClient orderClient;


    /**
     * 1、通过RestTemplate调用服务
     * 2、通过RestTemplate+Ribbon负载通过consul获取服务对象进行调用服务
     * @return
     */
    @RequestMapping(value = "user")
    public String gitUser(){
        System.out.println("进入user方法");
        /**
         * 四种调用
         * 1、直接resttemplate调用
         * 2、使用DiscoveryClient负载从consul获取调用地址进行调用----》这是服务发现对象（查看服务中有什么可用的服务对象）
         * 3、使用loadBalancerClient负载从consul获取调用地址进行调用---》负载均衡操作的对象
         * 4、封装RestTemplate增加@LoadBalanced注解，通过注解获取RestTemplate对象就已经封装了ribbon组件
         */
//        1、直接通过RestTemplate调用接口
//        RestTemplate restTemplate = new RestTemplate();
//        String url = "http://localhost:8041/gitOrder";
//        ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);
//        System.out.println("返回结果是"+forEntity.toString());
        //使用ribbon + RestTemplate实现调用订单项目
        //ribbon封装三种远程调用

//        2、使用DiscoveryClient负载从consul获取调用地址进行调用
//        List<ServiceInstance> orderservice = discoveryClient.getInstances("ORDERSERVICE");//获取所有的服务列表
//        orderservice.forEach(a->{
//            log.debug("服务地址为:{},端口为：{}，服务地址为：{}",a.getHost(),a.getPort(),a.getUri() );
//            System.out.println("服务地址为:"+a.getHost()+",端口为："+a.getPort()+"，服务地址为："+a.getUri() );
//        });
//        ResponseEntity<String> forEntity1 = restTemplate.getForEntity(orderservice.get(0).getUri() + "/gitOrder", String.class);

//        3、使用loadBalancerClient负载从consul获取调用地址进行调用,,已经给做了负载均衡，默认是轮询策略
//        ServiceInstance orderservice1 = loadBalancerClient.choose("ORDERSERVICE");
//        System.out.println("服务地址为:"+orderservice1.getHost()+",端口为："+orderservice1.getPort()+"，服务地址为："+orderservice1.getUri() );
//        String forObject = restTemplate.getForObject(orderservice1.getUri() + "/gitOrder", String.class); //这里调用uri还是实际地址
//        4、封装RestTemplate增加@LoadBalanced注解，通过注解获取RestTemplate对象就已经封装了ribbon组件
        String forObject = restTemplate.getForObject("http://ORDERSERVICE/gitOrder", String.class);
        return forObject;
    }

    /**
     * 通过OenFeign调用服务
     * @return
     */
    @GetMapping("getOpenFeign")
    public String getOpenFeign(){
        log.info("进入OpenFeige调用");
//        String s = orderClient.gitOrder();

//        String s = orderClient.queryStringPath("张三", 99);

//        String s = orderClient.queryStringVo(new OrderVo(123, "李四", 88, new Date()));

        TestListVo testListVo = new TestListVo();
        TestListVo testListVo1 = orderClient.getTestListVo(testListVo);
//        log.info(testListVo1.toString());
        return "返回数据为："+testListVo1.toString();
    }
    @GetMapping("")
    public String test(){
        return "测试，无路径访问0";
    }

//    public static void main(String[] args) {
////        System.out.println(new Date().getTime());
//
//        TestListVo testListVo = new TestListVo();
//        testListVo.setName("张三");
//        List<TestListVo> list = new ArrayList<>();
//        list.add(testListVo);
//        TestListVo testListVo1 = list.get(0);
//        testListVo1.setName("李四");
//
//        TestListVo testListVo2 = list.get(0);
//        System.out.println(testListVo2.getName());
//
//    }

}
