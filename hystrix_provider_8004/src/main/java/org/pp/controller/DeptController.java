package org.pp.controller;

import org.pp.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;
    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/dept/hystrix/ok/{id}")
    public String deptInfo_Ok(@PathVariable("id") Integer id) {
        String result = deptService.deptInfo_Ok(id);
        return result + "，   端口号：" + serverPort;
    }

    // Hystrix 服务超时降级
    //通常情况下，我们都会在客户端进行服务降级，当客户端调用的服务端的服务不可用时，
    //客户端直接进行服务降级处理，避免其线程被长时间、不必要地占用。
    @RequestMapping(value = "/dept/hystrix/timeout/{id}")  //Hystrix 服务降级
    public String deptInfo_Timeout(@PathVariable("id") Integer id) {
        String result = deptService.deptInfo_Timeout(id);
        return result + "，   端口号：" + serverPort;
    }

    // Hystrix 服务熔断
    @RequestMapping(value = "/dept/hystrix/circuit/{id}")
    public String deptCircuitBreaker(@PathVariable("id") Integer id){
        return deptService.deptCircuitBreaker(id);
    }
}