package com.wsl.controller;

import com.wsl.pojo.KillGoods;
import com.wsl.pojo.OrderInfo;
import com.wsl.pojo.Userinfo;
import com.wsl.service.KillGoodsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/killgoods/")
public class KillGoodsController {
    @Autowired
    KillGoodsServiceImpl service;
    @RequestMapping("list")
    public String list(){
        return "goods_list";
    }
    @RequestMapping("searchKillGoods")
    @ResponseBody
    public List<KillGoods> searchKillGoods(){
        List<KillGoods> killGoods = service.getAllKillGoods();
        return killGoods;
    }
    @RequestMapping("view/{killid}")
    public String view(@PathVariable("killid")Integer killid,HttpServletRequest request){
        request.setAttribute("killid",killid);
        return "goods_view";
    }
    @RequestMapping("goodsview")
    @ResponseBody
        public Map<String,Object> goodsview(Integer killid){
        Map<String,Object> map=new HashMap<>();
        KillGoods killGoods = service.getKillGoodsById(killid);
        map.put("goods",killGoods);
        //  System.out.println(killGoods);
        long remainSeconds=0;
        long start = killGoods.getStartdate().getTime();
        long end = killGoods.getEnddate().getTime();
        long now = System.currentTimeMillis();
        Integer killStatus=0;//秒杀还没开始
        if(now<start){
            remainSeconds=(start-now)/1000;
        }else if(now>=end){
            killStatus=2;//秒杀结束
        }else {
            killStatus=1;//秒杀正在进行
        }
        long startToEnd=end-now;
        map.put("startToEnd",startToEnd);
        map.put("remainSeconds",remainSeconds);
        map.put("killStatus",killStatus);
        return map;
        }
    @RequestMapping("tokill")
    public String tokill(HttpServletRequest request, HttpServletResponse response, Integer killid) throws IOException {
        Userinfo loginuser =(Userinfo) request.getSession().getAttribute("loginuser");
        int i = service.kill(loginuser.getUserid(), killid);
        System.out.println(i);
        request.setAttribute("orderinfoid",i);
        if(i!=0){
            return "order_view";
        }else {
            response.getWriter().write("<script>alert('秒杀失败!!！');history.go(-1);</script>");
            return null;
        }
    }
    @RequestMapping("kill")
    @ResponseBody
    public OrderInfo kill(Integer orderinfoid){
        OrderInfo orderInfo = service.getorderByOrderId(orderinfoid);
        return orderInfo;
    }
}
