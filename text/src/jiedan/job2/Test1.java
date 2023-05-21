package jiedan.job2;

import java.text.DecimalFormat;

class Member{
    private String name;
    private String sex;
    private int number;
    private String category;

    public Member(String name, String sex, int number, String category) {
        this.name = name;
        this.sex = sex;
        this.number = number;
        this.category = category;
    }

    public Member() {
    }
    public double getPrice(int price){
        double result=0;
        if("初级会员".equals(category)){
            result=price-(price/100)*10;
        }else if("中级会员".equals(category)){
            result=0.9*price;
        }else if("高级会员".equals(category)){
            if(price<=500)
                result=0.9*price;
            else result=0.8*price;
        }
        return result;
    }
}

public class Test1 {
    public static void main(String[] args) {
        Member member = new Member("张三", "男", 100, "初级会员");
        Member member1 = new Member("李四", "女", 80, "中级会员");
        Member member2 = new Member("王五", "男", 90, "高级会员");
        DecimalFormat decimalFormat=new DecimalFormat("#0.0");//用于给double计算结果保留一位小数
        System.out.println("初级会员购买150元商品需要付款："+decimalFormat.format(member.getPrice(150))+"元");
        System.out.println("中级会员购买150元商品需要付款："+decimalFormat.format(member1.getPrice(150))+"元");
        System.out.println("高级会员购买150元商品需要付款："+decimalFormat.format(member2.getPrice(150))+"元 购买550元商品需要付款："+decimalFormat.format(member2.getPrice(550))+"元");
    }
}
