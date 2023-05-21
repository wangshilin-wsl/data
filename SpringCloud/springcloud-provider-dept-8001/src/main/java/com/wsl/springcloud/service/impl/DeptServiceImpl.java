package com.wsl.springcloud.service.impl;

import com.wsl.springcloud.dao.DeptDao;
import com.wsl.springcloud.pojo.Dept;
import com.wsl.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author WSL
 * @version 1.0.0
 * @ClassName DeptServiceImpl.java
 * @Description TODO
 * @createTime 2022年04月03日 14:16:00
 */
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptDao deptDao;
    @Override
    public boolean addDept(Dept dept) {
        return deptDao.addDept(dept);
    }

    @Override
    public Dept queryById(Long id) {
        return deptDao.queryById(id);
    }

    @Override
    public List<Dept> queryAll() {
        return deptDao.queryAll();
    }
}
