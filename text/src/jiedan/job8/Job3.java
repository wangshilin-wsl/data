package jiedan.job8;

import java.util.Stack;

public class Job3 {
    public static void main(String[] args) {
        System.out.println(isValid("([])"));
    }
    public static boolean isValid(String s) {
        Stack<String> left=new Stack<>();
        Stack<String> right=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('||s.charAt(i)=='['||s.charAt(i)=='{'){
                left.push(s.charAt(i)+"");
            }else{
                right.push(s.charAt(i)+"");
            }
        }
        while(!left.isEmpty()&&!right.isEmpty()){
            String left1=left.pop();
            String right1=right.pop();
            System.out.println(left1+"  "+right1);
            if("(".equals(left1)&&!")".equals(right1)){
                return false;
            }
            if("[".equals(left1)&&!"]".equals(right1)){
                return false;
            }
            if("{".equals(left1)&&!"}".equals(right1)){
                return false;
            }
        }
        if(left.isEmpty()&&right.isEmpty()){
            return true;
        }else{
            return false;
        }

    }
}
