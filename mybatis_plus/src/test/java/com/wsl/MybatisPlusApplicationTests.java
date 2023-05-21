package com.wsl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wsl.mapper.UserMapper;
import com.wsl.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
class MybatisPlusApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Test
    void contextLoads() {
        List<User> users = userMapper.selectList(null);
        for (User user : users) {
            System.out.println(user);
        }
    }
    //测试插入
    @Test
    public void testInsert(){
        //自动生成id
        User user = new User();
        user.setName("wsl");
        user.setAge(10);
        user.setEmail("908129@qq.com");
        int insert = userMapper.insert(user);
        System.out.println(insert);
        System.out.println(user);
    }

    //测试更新
    @Test
    public void testUpdate(){
        //自动生成id
        User user = new User();
        user.setId(7);
        user.setName("wsl修改");
        user.setAge(100);
        user.setEmail("908124349@qq.com");
        //int insert = userMapper.updateById(user);
        //System.out.println(insert);
        System.out.println(user);
        Wrapper<User> wrapper = new QueryWrapper<User>()
                .eq("name","wsl");
        userMapper.update(user,wrapper);
    }

    //测试乐观锁成功
    @Test
    public void testOptimisticLocker(){
        //1、查询用户信息
        User user = userMapper.selectById(1);
        //2、修改用户信息
        user.setName("wangshiln");
        user.setEmail("2634909409@qq.com");
        //3、执行更新操作
        userMapper.updateById(user);
    }

    //测试乐观锁失败,多线程下
    @Test
    public void testOptimisticLocker2(){
        //线程1
        User user = userMapper.selectById(1);
        user.setName("wangshiln111");
        user.setEmail("2634909409@qq.com");

        //模拟另外一个线程执行了插队操作
        User user1 = userMapper.selectById(1);
        user1.setName("wangshiln222");
        user1.setEmail("2634909409@qq.com");
        userMapper.updateById(user1);

        //线程1去更新,如果没有乐观锁就会覆盖插队线程的值
        //自旋锁来多次尝试操作
        userMapper.updateById(user);
    }

    //测试单条查询
    @Test
    public void testSelectById(){
        User user = userMapper.selectById(5);
        System.out.println(user);
    }
    //测试批量查询
    @Test
    public void testSelectByBatchId(){
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1,2,3));
        users.forEach(System.out::println);
    }
    //测试条件查询 map
    @Test
    public void testSelectByBatchIds(){
        HashMap<String, Object> map = new HashMap<>();
        //自定义查询条件
        map.put("name", "wsl修改");
        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);
    }

    //测试分页查询
    @Test
    public void testPage(){
        //  参数1：当前页
        //  参数2：页面大小
        Page<User> page = new Page<>(2,5);
        Page<User> userPage = userMapper.selectPage(page, null);
        userPage.getRecords().forEach(System.out::println);
    }

    //测试根据id删除
    @Test
    public void testDeleteById(){
        userMapper.deleteById(9);
    }

    // 通过id批量删除
    @Test
    public void testDeleteBatchId(){
        userMapper.deleteBatchIds(Arrays.asList(7,8));
    }
    // 通过map批量删除
    @Test
    public void testDeleteMap(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "wsl修改");
        userMapper.deleteByMap(map);
    }
    //逻辑删除
    @Test
    public void testDelete(){
        userMapper.deleteById(5);
    }
}
