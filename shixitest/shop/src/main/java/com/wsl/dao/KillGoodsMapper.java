package com.wsl.dao;

import com.wsl.pojo.KillGoods;
import com.wsl.pojo.KillGoodsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface KillGoodsMapper {
    long countByExample(KillGoodsExample example);

    int deleteByExample(KillGoodsExample example);

    int deleteByPrimaryKey(Integer killid);

    int insert(KillGoods record);

    int insertSelective(KillGoods record);

    List<KillGoods> selectByExample(KillGoodsExample example);

    KillGoods selectByPrimaryKey(Integer killid);

    int updateByExampleSelective(@Param("record") KillGoods record, @Param("example") KillGoodsExample example);

    int updateByExample(@Param("record") KillGoods record, @Param("example") KillGoodsExample example);

    int updateByPrimaryKeySelective(KillGoods record);

    int updateByPrimaryKey(KillGoods record);
    List<KillGoods> selectAllKillGoods();
    KillGoods selectById(Integer killid);
}