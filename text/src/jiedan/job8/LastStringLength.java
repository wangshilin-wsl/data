package jiedan.job8;

import java.util.Stack;

public class LastStringLength {
    public static void main(String[] args) {
        System.out.println(isValid("{}({)}"));
    }
    public static boolean isValid(String s) {
        Stack<String> left=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('||s.charAt(i)=='['||s.charAt(i)=='{'){
                left.push(s.charAt(i)+"");
            }else {
                if(!left.isEmpty()){
                    if(!equ(left.pop(),s.charAt(i)+"")){
                        return false;
                    }
                }else {
                    return false;
                }
            }
        }
        if(left.isEmpty()){
            return true;
        }else {
            return false;
        }

    }
    public static boolean equ(String a,String b){
        if("{".equals(a)&&"}".equals(b)||"[".equals(a)&&"]".equals(b)||"(".equals(a)&&")".equals(b)){
            return true;
        }
        return false;
    }
}
