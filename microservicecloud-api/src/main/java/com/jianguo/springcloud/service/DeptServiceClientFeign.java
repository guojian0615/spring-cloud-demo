package com.jianguo.springcloud.service;

import com.jianguo.springcloud.entiry.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * 该方法其实是对服务提供者restfulapi方法的定义
 */
@FeignClient(value = "microservicecloud-dept/provider/dept",
        fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface DeptServiceClientFeign {
    @PostMapping("/add")
    boolean add(Dept dept);

    @GetMapping("/get/{id}")
    Dept get(@PathVariable("id") Long id);

    @GetMapping("/list")
    List<Dept> list();
}
