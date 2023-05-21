package jiedan.job2;

import java.text.DecimalFormat;

class Point{
    private double x;
    private double y;

    public Point() {
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
class Circle{
    private Point point;
    private double r;

    public Circle() {
    }

    public Circle(Point point, double r) {
        this.point = point;
        this.r = r;
    }
    public Circle(double x,double y, double r) {
        point=new Point(x,y);
        this.r = r;
    }
    public double getPerimeter(){
        return Math.PI*2*r;
    }
    public double getArea(){
        return Math.PI*r*r;
    }

}

public class Test {
    public static void main(String[] args) {
        Point point = new Point(5, 5);
        Circle circle = new Circle(point, 3);
        DecimalFormat decimalFormat=new DecimalFormat("#0.00");//用于给double计算结果保留两位小数
        System.out.println("圆的周长为："+decimalFormat.format(circle.getPerimeter()));
        System.out.println("圆的面积为："+decimalFormat.format(circle.getArea()));
    }
}
