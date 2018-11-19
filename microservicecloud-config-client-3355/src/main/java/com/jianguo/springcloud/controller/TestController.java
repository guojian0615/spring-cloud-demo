package com.jianguo.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Value("${userinfo.name}")
    private String username;
    @Value("${userinfo.addr}")
    private String addr;
    @Value("${spring.application.name}")
    private String applicationName;

    @GetMapping("/getInfoFromGit")
    public String getInfoFromGit() {
        System.out.println("username=" + username + " ,addr=" + addr
                + " ,applicationName=" + applicationName);
        return "ok";
    }

}
