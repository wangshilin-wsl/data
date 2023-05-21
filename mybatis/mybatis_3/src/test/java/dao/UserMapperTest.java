package dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.User;
import utils.MybatisUtils;

import java.util.List;

public class UserMapperTest {

    @Test
    public void test(){
        //获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //方式一：执行SQL
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();

        for (User u:userList) {
            System.out.println(u);
        }
        sqlSession.close();
    }
    @Test
    public void test1(){
        //获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //方式一：执行SQL
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);
    }
    @Test
    public void test2(){
        //获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //方式一：执行SQL
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user =new User(4,"wang","111");
        int i = mapper.addUser(user);
        //增删改需要事务处理
        if(i>0){
            System.out.println("插入成功！！！");
        }
        //提交事务
       sqlSession.commit();
        System.out.println(i);
    }
 
    @Test
    public void test3(){
        //获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //方式一：执行SQL
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user =new User(4,"hehe","123");
        int i = mapper.updateUser(user);
        //增删改需要事务处理
        if(i>0){
            System.out.println("修改成功！！！");
        }
        //提交事务
        sqlSession.commit();
        System.out.println(i);
    }
    @Test
    public void test4(){
        //获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //方式一：执行SQL
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int i = mapper.deleteUser(8);
        //增删改需要事务处理
        if(i>0){
            System.out.println("删除成功！！！");
        }
        //提交事务
        sqlSession.commit();
        System.out.println(i);
    }

}
