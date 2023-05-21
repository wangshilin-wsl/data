package com.wsl.mapper;

import com.wsl.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper//这个注解表示了这是一个mybatis的mapper类
@Repository//表示这个类被spring接管了
public interface UserMapper{
    User queryUserById(int id);
}
