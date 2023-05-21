package jiedan2;
class RException extends RuntimeException{
    public RException() {
        super("半径小于等于0！！！");
    }
}
class Round{
    private double r;
    private double pi=3.14;
    public Round(double r) {
        if(r<=0) throw new RException();
        else
        this.r = r;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        if(r<=0) throw new RException();
        else
        this.r = r;
    }
    public double getDiameter(){
        return 2*r;
    }
    public double getArea(){
        return pi*r*r;
    }
}
class Ball {
    private double r;
    private double pi = 3.14;

    public Ball(double r) {
        if(r<=0) throw new RException();
        else
        this.r = r;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        if(r<=0) throw new RException();
        else
        this.r = r;
    }
    public double getArea(){
        return 4*pi*r*r;
    }
    public double getVolume(){
        return (4/3d)*pi*r*r*r;
    }
}
public class Test3 {
    public static void main(String[] args) {
        Round round = new Round(0);
        Ball ball = new Ball(0);
    }

}
