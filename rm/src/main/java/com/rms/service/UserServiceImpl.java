package com.rms.service;

import com.rms.dao.UserDao;
import com.rms.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.Date;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public void register(User user) {
        //根据用户名查询用户名是否存在
        User user1 = userDao.findByUserName(user.getUsername());
        if(user1==null){
            //生成用户的状态
            user.setStatus("已激活");
            //设置用户注册时间
            user.setRegisterTime(new Date());
            userDao.save(user);
        }else{
            throw new RuntimeException("用户名已经存在");
        }

    }

    @Override
    public User login(User user) {
        User user1 = userDao.findByUserName(user.getUsername());
        if(!ObjectUtils.isEmpty(user1)){
            if(user1.getPassword().equals(user.getPassword())){
                return user1;
            }else{
                throw new RuntimeException("密码错误！");
            }
        }else{
            throw new RuntimeException("用户名不存在！");
        }
    }
}
