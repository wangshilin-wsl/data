package com.wsl.controller;

import com.wsl.pojo.Goods;
import com.wsl.service.GoodsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Test {
    @Autowired
    private GoodsServiceImpl goodsService;
    @CrossOrigin(origins = "*",maxAge = 3600)
    @RequestMapping("/hh")
    public Goods[] hh(){
        List<Goods> all = goodsService.getAll();
        return all.toArray(new Goods[all.size()]);
    }
}
