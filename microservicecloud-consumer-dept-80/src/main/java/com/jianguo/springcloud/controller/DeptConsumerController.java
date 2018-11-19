package com.jianguo.springcloud.controller;

import com.jianguo.springcloud.entiry.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/consumer/dept")
public class DeptConsumerController {
    public static final String URL_PREFIX = "http://microservicecloud-dept/provider/dept/";
    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/add")
    public boolean add(Dept dept) {
        return restTemplate.postForObject(URL_PREFIX + "add", dept, Boolean.class);
    }

    @GetMapping("/get/{id}")
    public Dept get(@PathVariable("id") long id) {
        return restTemplate.getForObject(URL_PREFIX + "get/" + id, Dept.class);
    }

    @GetMapping("/list")
    public List<Dept> list() {
        return restTemplate.getForObject(URL_PREFIX + "list", List.class);
    }
}
