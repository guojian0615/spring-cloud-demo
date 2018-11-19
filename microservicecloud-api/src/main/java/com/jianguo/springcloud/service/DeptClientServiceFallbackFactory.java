package com.jianguo.springcloud.service;

import com.jianguo.springcloud.entiry.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptServiceClientFeign> {
    @Override
    public DeptServiceClientFeign create(Throwable throwable) {
        return new DeptServiceClientFeign() {
            @Override
            public boolean add(Dept dept) {
                return false;
            }

            @Override
            public Dept get(Long id) {
                return new Dept().setDeptno(id).setDname("该服务暂停服务");
            }

            @Override
            public List<Dept> list() {
                return null;
            }
        };
    }
}
