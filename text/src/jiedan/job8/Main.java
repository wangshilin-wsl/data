package jiedan.job8;

public class Main {
    public static void main(String[] args) {
        double[] sum = new Main().twoSum(2);
        for (double v : sum) {
            System.out.println(v);
        }
      /*  String[] arr={"ab","c","de","fg"};
        List<String> list=new ArrayList<>();
        list.add("");
        for(String s : arr){
            List<String> temp=new ArrayList<>();
            for(int i=0;i<s.length();i++){
                for(String str:list){
                    temp.add(str+s.charAt(i));
                }
            }
            list=new ArrayList<>(temp);
        }
        Collections.sort(list);
        list.forEach(System.out::println);*/
    }
    public double[] twoSum(int n) {
        double[] result=new double[]{1/6d,1/6d,1/6d,1/6d,1/6d,1/6d};
        double[] temp;
        for(int i=2;i<=n;i++){
            temp=new double[i*5+1];
            for(int k=0;k<result.length;k++){
                for(int j=0;j<6;j++){
                    temp[k+j]+=result[k]/6;
                }
            }
            result=temp;
        }
        return  result;
    }
}
