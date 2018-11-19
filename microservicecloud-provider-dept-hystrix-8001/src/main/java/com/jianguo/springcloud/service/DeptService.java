package com.jianguo.springcloud.service;

import com.jianguo.springcloud.entiry.Dept;

import java.util.List;

public interface DeptService {
    boolean add(Dept dept);

    Dept get(Long id);

    List<Dept> list();
}
