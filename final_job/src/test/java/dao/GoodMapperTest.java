package dao;

import org.junit.Test;
import pojo.Good;
import service.DaoGood;
import java.util.List;
public class GoodMapperTest {
    @Test
    //增
    public  void test1(){
        DaoGood.adddGood(new Good(26,"王者荣耀",123));
    }
    @Test
    //删
    public  void test2(){
        DaoGood.deleteGood(26);
    }
    @Test
    //改
    public  void test3(){
DaoGood.update(26,"吃鸡",31);
    }
    @Test
    //查
    public  void test4(){
        List<Good> like = DaoGood.getGoodsLike("腾讯");
        for(Good good:like){
            System.out.println(good);
        }
    }
}
