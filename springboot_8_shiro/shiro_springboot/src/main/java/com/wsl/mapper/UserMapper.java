package com.wsl.mapper;

import com.wsl.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {
     User queryUserByName(String name);
}
