package com.rms.dao;

import com.rms.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserDao {
    void save(User user);
    User findByUserName(String username);
}
