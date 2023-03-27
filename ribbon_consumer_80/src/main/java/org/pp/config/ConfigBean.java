package org.pp.config;

import com.netflix.loadbalancer.IRule;

import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import org.pp.config.myrule.MyRandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
// 配置类注解
@Configuration
public class ConfigBean {

    @Bean //将 RestTemplate 注入到容器中
    @LoadBalanced //在客户端使用 RestTemplate 请求服务端时，开启负载均衡（Ribbon）
    //Ribbon 可以与 RestTemplate（Rest 模板）配合使用，以实现微服务之间的调用
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    public IRule myRule() {  //Ribbon实现客户端负载均衡默认使用的是轮询策略
        // RandomRule 为随机策略
//        return new RandomRule();

        //自定义 Ribbon 负载均衡策略
        return new MyRandomRule(); //自定义，随机选择某一个微服务，执行三次
    }
}