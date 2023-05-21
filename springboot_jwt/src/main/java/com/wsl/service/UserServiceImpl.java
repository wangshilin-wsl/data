package com.wsl.service;

import com.wsl.dao.UserDao;
import com.wsl.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public User login(User user) {
        User user1=userDao.login(user);
        if(user1!=null){
            return user1;
        }
       throw new RuntimeException("登录失败！！！");
    }
}
