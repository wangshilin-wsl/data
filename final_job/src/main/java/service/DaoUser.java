package service;

import dao.UserMapper;
import org.apache.ibatis.session.SqlSession;
import pojo.User;
import utils.MybatisUtils;

public class DaoUser {
    //检查用户是否存在
    public static boolean check(User user) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user1 = null;
        user1 = mapper.getUserByName(user.getName());
        if (user1 == null)
            return false;
            if (user1.getPassword().equals(user.getPassword()))
                return true;
            return false;
    }

    //增加用户
    public static boolean insert(User user){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user1 = null;
        user1 = mapper.getUserByName(user.getName());
        if (user1 != null)
            return false;
        mapper.addUser(user);
        return true;
    }
//删除用户
    public static int delete(String name){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = mapper.delete(name);
        return i;

    }
//更新用户
    public static int update(String name,String password){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = mapper.update(name, password);
        return i;

    }

//查找指定用户
    public static User search(String name){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User i = mapper.getUserByName(name);
        return i;
    }
}
