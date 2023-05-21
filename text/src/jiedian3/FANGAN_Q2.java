package jiedian3;

import java.util.ArrayList;
import java.util.Arrays;

public class FANGAN_Q2 {
    static ArrayList<Integer> numList=new ArrayList<>(Arrays.asList(109,2020,3, 2021));//初始化list

    public static void main(String[] args) {
        numList.add(2030);
        System.out.println(bigSmall(2020));
        System.out.println(bigSmall(2080));
        System.out.println(bigSmall(3));
    }
    public static boolean bigSmall(int temp){
        int max=Integer.MIN_VALUE;//用于存储当前List的最大值的变量
        for(int i=0;i<numList.size();i++){
            if(max<numList.get(i)) max=numList.get(i);
        }
        System.out.println("当前numList最大值为："+max);
        if(temp>2021) return true;
        else return false;
    }
}
