package bishi2.job4;


import java.util.Arrays;

public class test1 {
    public static void main(String[] args) {
        int[] temp={2,3,4,1,9,0,5,6,7,8};
        System.out.print("排序之前：");
        for (int i : temp) {
            System.out.print(temp[i]+" ");
        }
        Arrays.sort(temp);
        System.out.println();
        System.out.print("排序之后：");
        for (int i : temp) {
            System.out.print(temp[i]+" ");
        }
    }
}
