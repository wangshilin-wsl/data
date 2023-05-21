package com.wsl.springcloud.service;

import com.wsl.springcloud.pojo.Dept;

import java.util.List;

/**
 * @author WSL
 * @version 1.0.0
 * @ClassName DeptService.java
 * @Description TODO
 * @createTime 2022年04月03日 14:15:00
 */
public interface DeptService {
    public boolean addDept(Dept dept);

    public Dept queryById(Long id);

    public List<Dept> queryAll();
}
