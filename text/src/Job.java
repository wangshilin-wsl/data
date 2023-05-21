import java.util.Scanner;

public class Job {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String a=scanner.nextLine();
        StringBuilder stringBuilder=new StringBuilder();
        for(int i=0;i<a.length();i++) {
            stringBuilder.append(hh(a.charAt(i)));
        }
        System.out.println(stringBuilder.toString());
    }
    public static char hh(char start){
        char temp;
        if(Character.isUpperCase(start)){
            temp=(char) ('Z'-(start-'A'));
        }else if(Character.isLowerCase(start)){
            temp=(char) ('Z'-(start-32-'A'));
        }else {
            temp=start;
        }
        return temp;
    }
}
