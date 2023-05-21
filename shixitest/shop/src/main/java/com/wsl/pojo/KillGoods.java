package com.wsl.pojo;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class KillGoods extends Goods{
    private Integer killid;

    private Integer goodsid;

    private Integer stockcount;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date startdate;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date enddate;

    private Integer killprice;

    public Integer getKillid() {
        return killid;
    }

    public void setKillid(Integer killid) {
        this.killid = killid;
    }

    public Integer getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Integer goodsid) {
        this.goodsid = goodsid;
    }

    public Integer getStockcount() {
        return stockcount;
    }

    public void setStockcount(Integer stockcount) {
        this.stockcount = stockcount;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public Integer getKillprice() {
        return killprice;
    }

    public void setKillprice(Integer killprice) {
        this.killprice = killprice;
    }

    @Override
    public String toString() {
        return "KillGoods{" +
                "killid=" + killid +
                ", goodsid=" + goodsid +
                ", stockcount=" + stockcount +
                ", startdate=" + startdate +
                ", enddate=" + enddate +
                ", killprice=" + killprice +
                '}';
    }
}