package bishi2.job4;

public class test3 {
    public static void main(String[] args) {
        System.out.println(deCode("ABCDEFGHIJKLMNOPQRSTUVWXYZ908"));
    }
    public static String deCode(String code){
        StringBuilder stringBuilder=new StringBuilder();
        for(int i=0;i<code.length();i++){
            if(code.charAt(i)<='Z'&&code.charAt(i)>='A'){
                char newChar;
                if(code.charAt(i)-5<65){
                    newChar=(char)(90-(65-code.charAt(i)+5)+1);
                }else {
                    newChar=(char)(code.charAt(i)-5);
                }
                stringBuilder.append(newChar);
                continue;
            }
            stringBuilder.append(code.charAt(i));
        }
        return stringBuilder.toString();
    }
}
