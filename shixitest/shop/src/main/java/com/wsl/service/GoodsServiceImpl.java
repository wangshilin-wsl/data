package com.wsl.service;

import com.wsl.dao.GoodsMapper;
import com.wsl.pojo.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper mapper;
    @Override
    public List<Goods> getAll() {
        List<Goods> goods = mapper.selectByExample(null);
        return goods;
    }
}
