package com.wsl.service;

import com.wsl.pojo.KillGoods;
import com.wsl.pojo.OrderInfo;

import java.util.List;

public interface KillGoodsService {
    List<KillGoods> getAllKillGoods();
     KillGoods getKillGoodsById(Integer id);
     int kill(Integer userid,Integer killid);
     OrderInfo getorderByOrderId(Integer orderid);
}
