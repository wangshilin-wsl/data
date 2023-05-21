package dao;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;
import pojo.User;
import utils.MybatisUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {
   static Logger logger = Logger.getLogger(UserMapperTest.class);
    @Test
    public void test1(){
        //获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //方式一：执行SQL
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);
    }
    //log4j的使用
    @Test
    public void test2(){
        logger.info("info:进入了testLog4j");
        logger.debug("debug:进入了test4j");
        logger.error("error:进入了test4j");
    }
    @Test
    public void test3(){
        //获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //方式一：执行SQL
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String,Integer> map=new HashMap<>();
        map.put("startIndex",1);
        map.put("pageSize",2);
        List<User> user = mapper.getUserByLimit(map);
        for (User u:user) {
            System.out.println(u);
        }
    }
    @Test
    public void test4(){
        SqlSession sqlSession=MybatisUtils.getSqlSession();
        //RowBounds实现
        RowBounds rowBounds = new RowBounds(1,2);
        //通过java代码实现分页
        List<User> list = sqlSession.selectList("dao.UserMapper.getUserByRowBounds",null,rowBounds);
        for (User u:list) {
            System.out.println(u);
        }
    }
}
