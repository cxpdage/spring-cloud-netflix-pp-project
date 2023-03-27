package org.pp.controller;

import org.pp.entity.Dept;
import org.pp.service.DeptFeignService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.List;

@RestController
public class DeptController_Consumer {

    @Resource
    private DeptFeignService deptFeignService;

    @RequestMapping(value = "/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Integer id) {
        return deptFeignService.get(id);
    }

    //访问到内容，说明OpenFeign 实现远程服务调用
    @RequestMapping(value = "/consumer/dept/list")
    public List<Dept> list() {
        return deptFeignService.list();
    }

    @RequestMapping(value = "/consumer/dept/feign/timeout")
    public String DeptFeignTimeout() {
        // openFeign-ribbon 客户端一般默认等待一秒钟，超过该时间就会报错
        return deptFeignService.DeptFeignTimeout();
    }
}