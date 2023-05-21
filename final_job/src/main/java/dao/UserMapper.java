package dao;

import org.apache.ibatis.annotations.*;
import pojo.User;

public interface UserMapper {
    //查找
    @Select("select * from user where name=#{name}")
    User getUserByName(@Param("name") String name);

    //增加
    @Insert("insert into user values(#{name},#{password})")
    int addUser(User user);
    //删除
    @Delete("delete from user where name=#{name}")
    int delete(@Param("name") String name);
    //修改
    @Update("update user set password=#{password} where name=#{name}")
    int update(@Param("name") String name,@Param("password") String password);
}
