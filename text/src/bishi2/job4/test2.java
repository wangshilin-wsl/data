package bishi2.job4;

public class test2 {
    public static void main(String[] args) {
        int[] ints = insert(new int[]{1,2,3,4,5,6}, 0);
        for (int anInt : ints) {
            System.out.print(anInt+" ");
        }
    }
    public static int[] insert(int[] temp,int a) {
        int i;
        int[] result=new int[temp.length+1];
        for(i=0;i<temp.length;i++){
            if(temp[i]>a)
                break;
            else
                result[i]=temp[i];
        }
        result[i]=a;
        for(int j=i+1;j<result.length;j++) {
            result[j]= temp[j-1];

        }
        return result;
    }
}
