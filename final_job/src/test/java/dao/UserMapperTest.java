package dao;

import org.junit.Test;
import pojo.User;
import service.DaoUser;

public class UserMapperTest {
    //增加
    @Test
    public void test1(){
        User user=new User("王世林","111");
        DaoUser.insert(user);
    }
    //删除
    @Test
    public void test2(){
        DaoUser.delete("王世林");
    }
    //修改
    @Test
    public void test3(){
        DaoUser.update("王世林","123");
    }
    //查询
    @Test
    public void test4(){
        User user = DaoUser.search("王世林");
        System.out.println(user);
    }
}
