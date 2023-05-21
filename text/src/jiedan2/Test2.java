package jiedan2;

import java.util.Scanner;

class Calculation{
    //加、减、乘、除、判断大小、圆面积
    private static double PI=3.1415;
    public static double add(double a,double b){
        return a+b;
    }
    public static double minus(double a,double b){
        return a-b;
    }
    public static double multiplication(double a,double b){
        return a*b;
    }
    public static double division(double a,double b){
        return a/b;
    }
    public static String judge(double a,double b){
        if(a!=b)
        return (a>=b?a:b)+">"+(a>=b?b:a);
        else
            return a+"="+b;
    }
    public static double getArea(double r){
        return r*r*PI;
    }
}
class Calculator{
    public void executeCalculations(int op){
        Scanner scanner=new Scanner(System.in);
        switch (op){
            case 1:{
                double  a,b;
                System.out.print("请输入相加的两个数：");
                a=scanner.nextDouble();
                b=scanner.nextDouble();
                System.out.println("结果为："+Calculation.add(a,b));
                break;
            }
            case 2:{
                double  a,b;
                System.out.print("请输入相减的两个数：");
                a=scanner.nextDouble();
                b=scanner.nextDouble();
                System.out.println("结果为："+Calculation.minus(a,b));
                break;
            }
            case 3:{
                double  a,b;
                System.out.print("请输入相乘的两个数：");
                a=scanner.nextDouble();
                b=scanner.nextDouble();
                System.out.println("结果为："+Calculation.multiplication(a,b));
                break;
            }
            case 4:{
                double  a,b;
                System.out.print("请输入相除的两个数：");
                a=scanner.nextDouble();
                b=scanner.nextDouble();
                if(b==0){
                    System.out.println("除数不能为0!!!");
                }else{
                    System.out.println("结果为："+Calculation.division(a,b));
                }
                break;
            }
            case 5:{
                double  a,b;
                System.out.print("请输入需要比较的两个数：");
                a=scanner.nextDouble();
                b=scanner.nextDouble();
                System.out.println(Calculation.division(a,b));
                break;
            }
            case 6:{
                double a;
                System.out.print("请输入圆的半径：");
                a=scanner.nextDouble();
                if(a<=0){
                    System.out.println("圆的半径不能小于等于0");
                }else{
                    System.out.println("圆的面积为："+Calculation.getArea(a));
                }
                break;
            }
        }
    }
}
public class Test2 {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.executeCalculations(1);
        calculator.executeCalculations(4);
        calculator.executeCalculations(4);
        calculator.executeCalculations(6);
        calculator.executeCalculations(6);

    }
}
