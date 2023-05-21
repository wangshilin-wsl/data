package com.wsl.service;

import com.wsl.dao.KillGoodsMapper;
import com.wsl.dao.KillOrderInfoMapper;
import com.wsl.dao.OrderInfoMapper;
import com.wsl.pojo.KillGoods;
import com.wsl.pojo.KillOrderInfo;
import com.wsl.pojo.KillOrderInfoExample;
import com.wsl.pojo.OrderInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
@Service
public class KillGoodsServiceImpl implements KillGoodsService {
    @Autowired
    private KillGoodsMapper mapper;
    @Autowired
    private KillOrderInfoMapper killOrderInfoMapper;
    @Autowired
    OrderInfoMapper orderInfoMapper;
    @Override
    public List<KillGoods> getAllKillGoods() {
        return mapper.selectAllKillGoods();
    }

    @Override
    public KillGoods getKillGoodsById(Integer id) {
        return mapper.selectById(id);
    }
    @Transactional
    @Override
    public int kill(Integer userid, Integer killid) {
        //1.根据KillID得到秒杀商品的基本信息
        //2.秒杀状态，秒杀是不是已经开始，
        //3.判断库存
        //4判断当前用户是否已经秒杀过
        //5.创建订单
        //6.减库存
        //7.秒杀成功
        int result=0;
        int orderid=0;
        KillGoods killGoods = mapper.selectById(killid);
        long start = killGoods.getStartdate().getTime();
        long end = killGoods.getEnddate().getTime();
        long now = System.currentTimeMillis();
       if(now<start){
           result=2;//秒杀还没开始
       }else{
           if(now>end){
               result=3;//秒杀已经结束
           }else{
               //判断库存
                if(killGoods.getStockcount()>0){
                    //有库存
                    //该用户是否秒杀过
                    KillOrderInfoExample example=new KillOrderInfoExample();
                    KillOrderInfoExample.Criteria criteria = example.createCriteria();
                    criteria.andUseridEqualTo(userid);
                    criteria.andKillgoodsidEqualTo(killid);
                    long countByExample = killOrderInfoMapper.countByExample(example);
                    if(countByExample>0){
                        result=4;//已经秒杀过了，不能在秒杀
                    }else {
                        //创建基本订单
                        OrderInfo orderInfo = new OrderInfo();
                        orderInfo.setUserid(userid);
                        orderInfo.setCreatedate(new Date());
                        orderInfo.setGoodscount(1);
                        System.out.println(killGoods);
                        orderInfo.setGoodsid(killGoods.getGoodsid());
                        orderInfo.setGoodsname(killGoods.getName());
                        orderInfo.setGoodsprice(killGoods.getKillprice());
                        orderInfo.setOrderstatus(0);
                        orderInfoMapper.insert(orderInfo);
                        orderid=orderInfo.getOrderid();
                        //创建秒杀订单
                        KillOrderInfo killOrderInfo=new KillOrderInfo();
                        killOrderInfo.setKillgoodsid(killid);
                        killOrderInfo.setOrderid(orderInfo.getOrderid());
                        killOrderInfo.setUserid(userid);
                        killOrderInfoMapper.insert(killOrderInfo);
                        //减库存
                        killGoods.setStockcount(killGoods.getStockcount()-1);
                        mapper.updateByPrimaryKey(killGoods);
                       result=1;//秒杀成功
                    }
                }else {
                    result=5;//库存不足
                }
           }
       }
        return orderid;
    }

    @Override
    public OrderInfo getorderByOrderId(Integer orderid) {
        return orderInfoMapper.selectByPrimaryKey(orderid);
    }


}
