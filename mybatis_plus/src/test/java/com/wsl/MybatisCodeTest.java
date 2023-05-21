package com.wsl;

import com.wsl.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import javax.annotation.Resource;

/**
 * @author WSL
 * @version 1.0.0
 * @ClassName WrapperTest.java
 * @Description TODO
 * @createTime 2022年03月15日 21:18:00
 */
@SpringBootTest
public class MybatisCodeTest {
    @Resource
    private SqlSessionFactory sqlSessionFactory;

    private UserMapper userMapper;

/***************************Mybatis 源码阅读*****************************/
    @Test
    void test1() {
        final SqlSession sqlSession = sqlSessionFactory.openSession();
        userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.getUser(1);
    }
    
}
