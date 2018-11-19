package com.jianguo.springcloud;

import com.jianguo.myrule.MyruleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
//
/*
 *  如果需要使用自定义的访问策略，需要添加如下注解
 *  MyruleConfig 配置类所在的包路径不能在启动类所在包的子包或者同一级下
 *
 */
//@RibbonClient(name = "microservicecloud-dept", configuration = {MyruleConfig.class})
public class DeptConsumer80 {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer80.class, args);
    }
}
