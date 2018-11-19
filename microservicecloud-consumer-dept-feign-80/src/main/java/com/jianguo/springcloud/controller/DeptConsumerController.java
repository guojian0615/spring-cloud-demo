package com.jianguo.springcloud.controller;

import com.jianguo.springcloud.entiry.Dept;
import com.jianguo.springcloud.service.DeptServiceClientFeign;
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
    @Autowired
    private DeptServiceClientFeign deptServiceClientFeign;

    @PostMapping("/add")
    public boolean add(Dept dept) {
        return deptServiceClientFeign.add(dept);
    }

    @GetMapping("/get/{id}")
    public Dept get(@PathVariable("id") long id) {
        return deptServiceClientFeign.get(id);
    }

    @GetMapping("/list")
    public List<Dept> list() {
        return deptServiceClientFeign.list();
    }
}
