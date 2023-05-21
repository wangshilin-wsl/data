package kaoshi2;

public class Test {

    public static void main(String[] args) {
        System.out.println(new Test().interpret("G()(al)"));
    }
    public String interpret(String command) {
     /*   command=command.replaceAll("\\(\\)","o");
        command=command.replaceAll("\\(al\\)","al");*/


        command=command.replace("()","o");
        command=command.replace("(al)","al");
        return command;
    }
    public char findTheDifference(String s, String t) {
        int[] result=new int[26];
        char temp='0';
        for(int i=0;i<s.length();i++){
            result[s.charAt(i)-'a']++;
            result[t.charAt(i)-'a']--;
        }
        result[t.charAt(t.length()-1)-'a']--;
        for(int i=0;i<t.length();i++){
            if(result[t.charAt(i)-'a']==-1) temp= t.charAt(i);
        }
        return temp;
    }
}
