package jiedan4;

class Round{//圆类，用于封装圆的一些属性，包括圆心的坐标，
    private int r;//圆的半径,
    int x;//圆的三维坐标
    int y;
    int z;
    public Round(int x, int y, int z,int r) {
        this.r=r;
        this.x=x;
        this.y=y;
        this.z=z;
    }
    public double getArea() {//圆类的方法
        return Math.PI*r*r;
    }
    public double getLen(){
        return Math.PI*2*r;
    }

    public int getR() {//给外界一个访问r的接口
        return r;
    }
}
class Ball extends Round{//球类，继承圆类
    public Ball(int x, int y, int z, int r) {
        super(x, y, z, r);
    }
    @Override
    public double getArea() {//复写父类的方法
        return 4*Math.PI*super.getR()*super.getR();
    }
    public double getVolume(){//得到球的体积
        return 4/3d*(Math.PI*super.getR()*super.getR()*super.getR());
    }
}
class Cylinder extends Round{//圆柱体类
    private int h;
    public Cylinder(int x, int y, int z, int r, int h) {
        super(x, y, z, r);
        this.h = h;
    }
    @Override
    public double getArea() {//复写父类的方法
        return super.getArea()*2+super.getLen()*h;
    }
    public double getVolume(){//自己独有的方法
        return super.getArea()*h;
    }
}
public class Job2 {//测试类
    public static void main(String[] args) {
        Round round = new Round(0, 0, 0, 5);
        Ball ball = new Ball(0, 0, 0, 5);
        Cylinder cylinder = new Cylinder(0, 0, 0, 5,6);
        System.out.println("圆的相关信息：");
        System.out.println("圆的周长："+round.getLen());
        getArea(round);
        System.out.println();

        System.out.println("球的相关信息：");
        System.out.println("球的体积："+ball.getVolume());
        getArea(ball);
        System.out.println();

        System.out.println("圆柱体的相关信息：");
        System.out.println("圆柱体的体积："+cylinder.getVolume());
        getArea(cylinder);
        System.out.println();
    }
    public static void getArea(Round round){//测试多态
        System.out.println("该图形的面积为："+round.getArea());
    }
}
