package org.pp.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//读取配置中心指定配置文件的内容，并展示到页面
@RestController
@RefreshScope //为了让动态（手动）的获取最新的git 配置，在添加 actuator 监控加载 RefreshScope，
//发现增加了监控模块和refreshScope还是不能获取最新的配置文件，需要在命令行窗口curl -X POST "http://localhost:3355/actuator/refresh" 才会生效
//在3344项目中以 RabbitMQ 为例，来演示如何使用 Config+Bus 实现配置的动态刷新
public class ConfigClientController {
    @Value("${server.port}")
    private String serverPort;

    @Value("${config.info}")
    private String configInfo;

    @Value("${config.version}")
    private String configVersion;

    @GetMapping(value = "/getConfig")
    public String getConfig() {
        return "info：" + configInfo + "<br/>version：" + configVersion + "<br/>port：" + serverPort;
    }
}