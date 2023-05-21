package dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import pojo.User;

import java.util.List;

public interface UserMapper {
    @Select("select * from user")
    List<User> getUsers();
    @Select("select * from user where id=#{id}")
    User getUserById(@Param("id") int id);//多个参数的时候一定要加上@Param,引用类型不用加
    @Insert("insert into user values(#{id},#{name},#{password})")
    int addUser(User user);

}
