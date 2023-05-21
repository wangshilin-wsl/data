package com.wsl.mapper;

import com.wsl.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper//这个注解表示了这是一个mybatis的mapper类
@Repository//表示这个类被spring接管了
public interface UserMapper {
    //查找所有的用户信息
    List<User> findAll();
    //保存用户信息
    void save(User user);
    //删除一个用户
    void delete(String id);
    //更新一个用户
    void update(User user);
    //分页查询
    List<User> findByPage(@Param("start")Integer start,@Param("rows") Integer pageSize);
    //查询总条数
    Long findTotals();
}
