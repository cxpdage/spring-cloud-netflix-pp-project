package org.pp.service;

import org.springframework.stereotype.Component;

/**
 * Hystrix 服务降级
 * 解耦回退逻辑
 */
@Component
//在DeptHystrixService类中增加了fallback的配置，以下实现的方法相当于降级方法了
public class DeptHystrixFallBackService implements DeptHystrixService {
    @Override
    public String deptInfo_Ok(Integer id) {
        return "--------------------萍萍提醒您，系统繁忙，请稍后重试！（解耦回退方法触发）-----------------------";
    }

    @Override
    public String deptInfo_Timeout(Integer id) {
        return "--------------------萍萍提醒您，系统繁忙，请稍后重试！（解耦回退方法触发）-----------------------";
    }
}