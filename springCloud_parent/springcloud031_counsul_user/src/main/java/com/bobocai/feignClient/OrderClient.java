package com.bobocai.feignClient;

import com.bobocai.vo.OrderVo;
import com.bobocai.vo.TestListVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "ORDERSERVICE",qualifier="orderClient")//打开
public interface OrderClient {

    //这个方法需要跟提供服务的方法名保持一直
    @RequestMapping(value = "gitOrder")
    public String gitOrder();

    //调用传参的方法
    @RequestMapping(value = "queryString")
    public String queryString(@RequestParam("name") String name, @RequestParam("age") Integer age);
    //路径传参的方式接收
    @GetMapping("queryString/{name}/{age}")
    public String queryStringPath(@PathVariable("name") String name, @PathVariable("age") Integer age);

    @PostMapping("queryStringVo")
    public String queryStringVo(@RequestBody OrderVo order);
//      一定要主要这里的接口一定要与，提供服务的接口完全一致，并且保证是有该服务的，否则会报找不到OrderClient，这个类就会实例化失败
//    //这是接收form表单的注解方式   上传文件的注解@RequestPart
//    @PostMapping("queryStringForm")
//    public String queryStringForm(@RequestPart OrderVo order);


    @PostMapping("getTestListVo")
    public TestListVo getTestListVo(@RequestBody TestListVo testListVo);
}
