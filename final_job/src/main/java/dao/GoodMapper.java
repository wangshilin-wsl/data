package dao;

import org.apache.ibatis.annotations.*;
import pojo.Good;
import java.util.List;

public interface GoodMapper {
    //查
    @Select("select * from good where detail like #{name}")
    List<Good> getGoodLike(@Param("name") String name);
    //增加
    @Insert("insert into good values(#{id},#{detail},#{number})")
    int addGood(Good good);
    //删除
    @Delete("delete from good where id=#{id}")
    int delete(@Param("id") int id);
    //修改
    @Update("update good set detail=#{detail},number=#{number} where id=#{id}")
    int update(@Param("id") int id,@Param("detail") String detail,@Param("number") int number);
}
