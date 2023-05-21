import java.util.Scanner;

/**
 * @author WSL
 * @version 1.0.0
 * @ClassName houzichitao.java
 * @Description TODO
 * @createTime 2021年12月31日 18:51:00
 */



public class houzichitao {

    public static  void main(String[] args) {
        // TODO 自动生成的方法存
        Scanner scanner = new Scanner(System.in);
        T t1 = new houzichitao().new T();
        int  n = scanner.nextInt();
        int res = t1.fibonacci(n);
        if (res!= -1) {
            System.out.print("当n=" + n + "对应的斐波拉契=" + res);

        }
    }


    class T{
        public int  fibonacci(int n) {
            if(n>=1) {
                if(n==1||n==2) {
                    return 1;
                }else {
                    return fibonacci(n-1)+fibonacci(n-2);
                }
            }else {
                System.out.print("要求输入的数n>=1的整数");
                return -1;
            }

        }
    }

}

