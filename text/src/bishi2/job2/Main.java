package bishi2.job2;

import java.util.Scanner;

public class Main {
    static int sum=0;//所有海洋的面积
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        char[][] a=new char[n][m];//用于存贮地图的数组
        for(int i=0;i<n;i++){//输入地图
            String temp=scanner.next();
            a[i]=temp.toCharArray();
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(a[i][j]=='@'){//找到所在位置
                    a[i][j]='.';
                    dfs(a,i,j);//进行深度遍历
                    break;
                }
            }
        }
        System.out.println(sum);
    }
    public static void dfs(char[][] a,int i,int j){//深度遍历a把所有‘海’并将海置为‘陆地’
        if(i>=a.length||j>=a[0].length||i<0||j<0||a[i][j]!='.') return;
        sum++;
        a[i][j]='#';
        dfs(a,i+1,j);
        dfs(a,i-1,j);
        dfs(a,i,j+1);
        dfs(a,i,j-1);
    }
}
