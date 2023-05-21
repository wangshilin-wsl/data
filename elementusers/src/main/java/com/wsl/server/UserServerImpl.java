package com.wsl.server;

import com.wsl.entity.User;
import com.wsl.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class UserServerImpl implements UserServer {
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }


    @Override
    public void save(User user) {
        userMapper.save(user);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public void delete(String id) {
        userMapper.delete(id);
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }

    @Override
    public  List<User> findByPage(Integer pageNow, Integer pageSize){
        int start=(pageNow-1)*pageSize;
        return userMapper.findByPage(start,pageSize);
    }

    @Override
    public Long findTotals() {
        return userMapper.findTotals();
    }
}
