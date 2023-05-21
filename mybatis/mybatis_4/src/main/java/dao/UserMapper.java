package dao;

import pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    //根据id查询用户
    User getUserById(int id);
    //分页用limit实现
    List<User> getUserByLimit(Map<String,Integer> map);
    //分页用RowBounds实现
    List<User> getUserByRowBounds();
}
