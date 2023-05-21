package jiedan.job7;

public class Round {
    private double x ;
    private double y ;
    private double r ;
    public final static double PI = 3.14 ;
    public Round  (double x ,double y ,double r){
        this .x = x ;
        this .y = y ;
        this .r = r ;
    }
    public double getArea () {
        return r * r * PI ;
    }
    public void  getRelation (Round r1) {
        double dist = Math.sqrt((x-r1.getx())*(x-r1.getx())+(y-r1.gety())*(y-r1.gety()));

        if(dist == (r+r1.getr()))
        {
            System.out.println("两个圆外切");
        }
        else if(dist>(r+r1.getr()))
        {
            System.out.println("两个圆外离");
        }
        else if(dist<Math.abs(r-r1.getr()))
        {
            System.out.println("两个圆内含");
        }
        else if(dist>Math.abs(r-r1.getr())&&dist<(r+r1.getr()))
        {
            System.out.println("两个圆相交");
        }
        else if(dist==Math.abs(r-r1.getr())){
            System.out.println("两个圆内切");
        }
    }
    public double getx(){
        return x;
    }
    public double gety() {
        return y ;
    }
    public double getr() {
        return r;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Round r1= new Round(0,0,5);
        Round r2= new Round(0,4,1);
        System.out.println("圆的面积是："+r1.getArea());
        r1.getRelation(r2);


    }
}
