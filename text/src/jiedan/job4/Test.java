package jiedan.job4;

import java.text.DecimalFormat;

abstract class Shape{//抽象父类，表示形状
    String name;//将形状的名字封装到spape类
    public abstract double getArea();//抽象方法，得到形状的面积

    public Shape(String name) {
        this.name = name;
    }//一个参数的构造函数

    public String getName() {//因为对name进行了封装，getname为该类对外界提供的接口
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
class Round extends Shape{//形状的子类圆，完成继承
    int r;//圆的属性，半径
    public Round(int r) {
        super("圆形");//调用父类的构造函数
        this.r=r;
    }

    @Override
    public double getArea() {//复写父类的抽象方法，从而实现多态
        return Math.PI*r*r;
    }
}
class Rectangle extends Shape{//形状的子类矩形，完成继承
    int len;//矩形的属性，长与宽
    int wid;

    public Rectangle(int len, int wid) {
        super("矩形");//调用父类的构造函数
        this.len = len;
        this.wid = wid;
    }

    @Override
    public double getArea() {//计算矩形的面积
        return len*wid;
    }
}
public class Test {
    public static void main(String[] args) {//测试
        Rectangle rectangle = new Rectangle(4, 3);//创建一个长为4，宽为3的矩形
        Round round = new Round(3);//创建一个半径为3的圆
        getArea(round);//该方法会得出不同的结果，表现出多态
        getArea(rectangle);

    }
    public static void  getArea(Shape shape){//该方法的参数为抽象类，传入对应的子类进行计算，从而实现多态
        DecimalFormat decimalFormat=new DecimalFormat("#0.00");//让输出的结果保留两位小数
        System.out.println(shape.getName()+"的面积："+decimalFormat.format(shape.getArea()));//调用得到面积的方法，子类进行了复写，所以会根据传入参数的不同计算出对应的面积
    }
}
