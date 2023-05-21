package com.wsl.dao;


import com.wsl.pojo.Userinfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface UserinfoMapper {
    Userinfo find(@Param("_parameter") Integer id);
    Userinfo selectByUsername(String username);
    List<Userinfo> selectAll();
    int selectCount();
    List<Userinfo> selectByPage(Map map);

    int insertUser(Userinfo userinfo);

    int updateById(Userinfo userinfo);

    int deleteById(Integer id);

}
