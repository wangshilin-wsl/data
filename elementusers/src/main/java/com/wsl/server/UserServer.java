package com.wsl.server;

import com.wsl.entity.User;

import java.util.List;

public interface UserServer {
    //查询所有的方法
    List<User> findAll();
    //保存用户信息
    void save(User user);
    //删除一个用户
    void delete(String id);
    //更新一个用户
    void update(User user);
    //分页查询
    List<User> findByPage(Integer pageNow, Integer pageSize);
    //查询总条数
    Long findTotals();
}
