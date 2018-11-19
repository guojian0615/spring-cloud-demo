package com.jianguo.springcloud.controller;

import com.jianguo.springcloud.entiry.Dept;
import com.jianguo.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
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

    @Autowired
    private DiscoveryClient client;

    @PostMapping("/add")
    public boolean add(Dept dept) {
        return service.add(dept);
    }

    @GetMapping("/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return service.get(id);
    }

    @GetMapping("/list")
    public List<Dept> list() {
        return service.list();
    }

    /**
     * 微服务发现
     *
     * @return
     */
    @GetMapping("/discoveryService")
    public List<String> discoveryService() {
        List<String> services = client.getServices();
        System.out.println("--------------发现的服务列表-------");
        services.stream().forEach(System.out::print);

        System.out.println("------microservicecloud-dept 微服务信息-----");
        List<ServiceInstance> instances = client.getInstances("microservicecloud-dept");
        instances.stream().forEach(serviceInstance -> {
            System.out.println(serviceInstance.getServiceId() + " , "
                    + serviceInstance.getHost() + " , "
                    + serviceInstance.getPort() + " , "
                    + serviceInstance.getUri());
        });
        return services;
    }
}