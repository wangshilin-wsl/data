package com.wsl;

import com.wsl.pojo.User;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.session.Configuration;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author WSL
 * @version 1.0.0
 * @ClassName MetaObjectTest.java
 * @Description TODO
 * @createTime 2022年07月26日 22:35:00
 */
public class MetaObjectTest {
    //直接操作属性
    //操作子属性
    //自动创建属性对象
    //自动查找属性名，支持下划线转驼峰
    //基于索引访问数组(包括list)
    @Test
    public void test1() throws Exception {
        User user1 = new User();
        user1.setId(10);
        final Class<User> userClass = User.class;
        final Method getId = userClass.getDeclaredMethod("getId");
        System.out.println(getId.invoke(user1));


        System.out.println("wsl".substring(0));
        Object user =  new User();
        Configuration configuration = new Configuration();
        //装饰
        MetaObject metaObject = configuration.newMetaObject(user);

        System.out.println(metaObject.getValue("comments[0].user.name"));
    }
}
