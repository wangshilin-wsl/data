package jiedan.job8;

import java.util.Scanner;

public class Job4 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int size=scanner.nextInt();
        display(size);
    }
    public static void display(int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<3*n;j++){
                System.out.print(" ");
            }
            System.out.println("||");
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<3*(n-i-1);j++){
                System.out.print(" ");
            }
            System.out.print("__/");
            for(int j=1;j<=3*i;j++){
                System.out.print(":");
            }
            System.out.print("||");
            for(int j=1;j<=3*i;j++){
                System.out.print(":");
            }
            System.out.println("\\__");
        }


        System.out.print("|");
        for(int i=0;i<6*n;i++) System.out.print("\"");
        System.out.println("|");

        for(int i=0;i<n;i++){
            for(int j=0;j<2*i;j++){
                System.out.print(" ");
            }
            System.out.print("\\_");
            for(int j=0;j<(6*n-2)/2-i*2;j++){
                System.out.print("/\\");
            }
            System.out.println("_/");
        }


        for(int i=0;i<n;i++){
            for(int j=0;j<3*n;j++){
                System.out.print(" ");
            }
            System.out.println("||");
        }


        for(int i=0;i<n*n;i++){
            for(int j=0;j<3*n+1-n;j++){
                System.out.print(" ");
            }
            System.out.print("|");
            for(int j=0;j<n-2;j++){
                System.out.print("%");
            }
            System.out.print("||");
            for(int j=0;j<n-2;j++){
                System.out.print("%");
            }
            System.out.println("|");
        }


        for(int i=0;i<n;i++){
            for(int j=0;j<3*(n-i-1);j++){
                System.out.print(" ");
            }
            System.out.print("__/");
            for(int j=1;j<=3*i;j++){
                System.out.print(":");
            }
            System.out.print("||");
            for(int j=1;j<=3*i;j++){
                System.out.print(":");
            }
            System.out.println("\\__");
        }


        System.out.print("|");
        for(int i=0;i<6*n;i++) System.out.print("\"");
        System.out.println("|");

    }
}
