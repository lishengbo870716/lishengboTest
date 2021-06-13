package com.bobocai.feignClient.Impl;

import com.bobocai.feignClient.OrderClient;
import com.bobocai.vo.OrderVo;
import com.bobocai.vo.TestListVo;
import org.springframework.stereotype.Component;

/**
 * 这个实现类是给hystrix做熔断降级的时候，调用接口异常不可用的情况而执行的这个方法
 */
@Component //这个需要加载时候时候创建对象，也可以使用@service、@Configuration来创建对象都可以
public class OrderClientImpl implements OrderClient {
    @Override
    public String gitOrder() {
        return null;
    }

    @Override
    public String queryString(String name, Integer age) {
        return null;
    }

    @Override
    public String queryStringPath(String name, Integer age) {
        return null;
    }

    @Override
    public String queryStringVo(OrderVo order) {
        return null;
    }

    @Override
    public TestListVo getTestListVo(TestListVo testListVo) {
        return null;
    }
}
