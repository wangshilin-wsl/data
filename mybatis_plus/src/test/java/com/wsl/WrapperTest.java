package com.wsl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wsl.mapper.UserMapper;
import com.wsl.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

/**
 * @author WSL
 * @version 1.0.0
 * @ClassName WrapperTest.java
 * @Description TODO
 * @createTime 2022年03月15日 21:18:00
 */
@SpringBootTest
public class WrapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        // 查询name不为空并且邮箱不为空且年龄大于12岁的的用户
        QueryWrapper<User> wrapper = new QueryWrapper<User>();
        wrapper
                .isNotNull("name")
                .isNotNull("email")
                .ge("age", 12);

        List<User> users = userMapper.selectList(wrapper);// 和map对比下
        users.forEach(System.out::println);
    }

    @Test
    void test2() {
        // 查询name为Tom的
        QueryWrapper<User> wrapper = new QueryWrapper<User>();
        wrapper.eq("name", "Tom");
        // 查询一个数据，出现多个结果使用list或者map
        User user = userMapper.selectOne(wrapper);
        System.out.println(user);
    }

    @Test
    void test3() {
        // 年龄在20到30之间的用户
        QueryWrapper<User> wrapper = new QueryWrapper<User>();
        //区间
        wrapper.between("age",20,30);
        Long num = userMapper.selectCount(wrapper);
        System.out.println(num);
    }

    //模糊查询
    @Test
    void test4() {
        // 名字里面不包含Jac
        QueryWrapper<User> wrapper = new QueryWrapper<User>();
        // 左和右， %m%
        wrapper.notLike("name", "Jac")
                .likeRight("name", "Bil");//Bil%
        final List<Map<String, Object>> maps = userMapper.selectMaps(wrapper);
        maps.forEach(System.out::println);
    }

    //模糊查询
    @Test
    void test5() {
        QueryWrapper<User> wrapper = new QueryWrapper<User>();
       //id 在子查询中查出来的
        wrapper.inSql("id", "select id from user where id<3");
        final List<Object> objects = userMapper.selectObjs(wrapper);
        objects.forEach(System.out::println);
    }

    //排序
    @Test
    void test6() {
        QueryWrapper<User> wrapper = new QueryWrapper<User>();
        //通过id进行排序
        wrapper.orderByDesc("id");
        final List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }

/***************************Mybatis 源码阅读*****************************/
    @Test
    void test7() {
        userMapper.selectById(1);
    }
    
}
