package dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.User;
import utils.MybatisUtils;

public class UserMapperTest {
  @Test
    public void test(){
      SqlSession sqlSession= MybatisUtils.getSqlSession();
      UserMapper mapper = sqlSession.getMapper(UserMapper.class);
      mapper.addUser(new User(8,"hello","111"));


        }
}
