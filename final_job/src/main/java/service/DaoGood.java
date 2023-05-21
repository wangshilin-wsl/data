package service;

import dao.GoodMapper;
import org.apache.ibatis.session.SqlSession;
import pojo.Good;
import utils.MybatisUtils;

import java.util.List;

public class DaoGood {
//增
    public static int adddGood(Good good){
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        GoodMapper mapper = sqlSession.getMapper(GoodMapper.class);
        int i = mapper.addGood(good);
        return i;
    }

    //删
    public static int deleteGood(int id){
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        GoodMapper mapper = sqlSession.getMapper(GoodMapper.class);
        int i = mapper.delete(id);
        return i;
    }

    //改
    public static int update(int id,String detail,int number){
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        GoodMapper mapper = sqlSession.getMapper(GoodMapper.class);
        int i = mapper.update(id, detail, number);
        return i;
    }
    //查
    public static List<Good> getGoodsLike(String detail){
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        GoodMapper mapper = sqlSession.getMapper(GoodMapper.class);
        List<Good> like = mapper.getGoodLike("%"+detail+"%");
        return like;
    }
}
