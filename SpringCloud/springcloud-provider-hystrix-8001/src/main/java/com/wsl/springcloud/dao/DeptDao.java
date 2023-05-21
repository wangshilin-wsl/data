package com.wsl.springcloud.dao;

import com.wsl.springcloud.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author WSL
 * @version 1.0.0
 * @ClassName DeptDao.java
 * @Description TODO
 * @createTime 2022年04月03日 14:03:00
 */
@Repository
@Mapper
public interface DeptDao {
    public boolean addDept(Dept dept);

    public Dept queryById(@Param("id") Long id);

    public List<Dept> queryAll();
}
