package org.pp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class HystrixConsumeApp9002 {

    public static void main(String[] args) {
        SpringApplication.run(HystrixConsumeApp9002.class, args);
    }
}