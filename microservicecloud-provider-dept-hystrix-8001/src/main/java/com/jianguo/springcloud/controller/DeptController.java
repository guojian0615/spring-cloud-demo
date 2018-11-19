package com.jianguo.springcloud.controller;

import com.jianguo.springcloud.entiry.Dept;
import com.jianguo.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/provider/dept")
public class DeptController {
    @Autowired
    private DeptService service;

    @PostMapping("/add")
    public boolean add(Dept dept) {
        return service.add(dept);
    }

    @GetMapping("/get/{id}")
    @HystrixCommand(fallbackMethod = "returnErrorInfo")
    public Dept get(@PathVariable("id") Long id) {
        Dept dept = service.get(id);
        if (null == dept) {
            throw new RuntimeException("该ID：" + id + "没有没有对应的信息");
        }
        return dept;
    }

    @GetMapping("/list")
    public List<Dept> list() {
        return service.list();
    }


    /*
     *
     *
     */
    public Dept returnErrorInfo(@PathVariable("id") Long id) {
        System.out.println("id = " + id);
        Dept dept = new Dept().setDeptno(id).setDname("该记录不存在")
                .setDb_source("HystrixCommand error");
        return dept;
    }


}