package com.wsl;

import com.wsl.mapper.UserMapper;
import org.springframework.boot.test.context.SpringBootTest;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author WSL
 * @version 1.0.0
 * @ClassName WrapperTest.java
 * @Description TODO
 * @createTime 2022年03月15日 21:18:00
 */
@SpringBootTest
public class JdkProxyTest {

    public static void main(String[] args) {
        final UserMapper userMapper = (UserMapper)Proxy.newProxyInstance(JdkProxyTest.class.getClassLoader(),
                new Class[]{UserMapper.class}, new MyInvocationHandler());

        userMapper.selectById(1);
    }
}
class MyInvocationHandler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("wsl  " + method.getName());
        return null;
    }
}
