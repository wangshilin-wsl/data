package com.wsl.controller;

import com.wsl.pojo.Goods;
import com.wsl.service.GoodsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/admin/goods/")
public class GoodsController {
    @Autowired
    private GoodsServiceImpl goodsService;
    @RequestMapping("getall")
    @ResponseBody//将返回值转成json输出,需要在springmvc配置文件中配置json转化器
    public List<Goods> getGoods(){
        return goodsService.getAll();
    }
}
