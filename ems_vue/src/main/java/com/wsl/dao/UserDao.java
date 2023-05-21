package com.wsl.dao;

import com.wsl.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserDao {
    void save(User user);
    User findByUserName(String username);
}
