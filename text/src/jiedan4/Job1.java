package jiedan4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Job1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String op="yes";//用户输入操作的存储变量
        double  sum=0;//总的猜的次数
        int min=Integer.MAX_VALUE;//最小的一次游戏次数
        List<Integer> list=new ArrayList<>();//用于存储所有游戏次数
        while(op.startsWith("y")||op.startsWith("Y")){
            System.out.println("I'm thinking of a number between 1 and 100..");
           // int number=(int)(Math.random()*100+1);//随机生成猜的数
            int number=26;//固定一个猜的数
            int guesses;//用户猜的数
            int cishu=0;//用于存储每一次游戏猜的次数
            while(true){
                cishu++;
                System.out.print("Your guess?");
                guesses=scanner.nextInt();
                if(guesses>number){
                    System.out.println("It's higher.");
                }else if(guesses<number){
                    System.out.println("It's lower.");
                }else{
                    break;
                }
            }
            if(cishu<min) min=cishu;//min存储的是最小的值
            list.add(cishu);
            sum+=cishu;
            System.out.println("You got it right in "+cishu+" guesses!");
            System.out.print("Do you want to play again?");
            op=scanner.next();
            System.out.println();
        }
        System.out.println("Overall results:");
        System.out.println("Total games    = "+list.size());
        System.out.println("Total guesses  = "+(int)sum);
        System.out.println("Guesses/game   = "+sum/list.size());
        System.out.println("Best game      = "+min);
    }
}
