package teach.medium;

public class StringCompressor {

    /**
     * <p>This method perform basic string compression using the count of repeated characters.
     * For example, the string {@code "aabcccccaaa"} will become {@code "a2b1c5a3"}</p>.
     *
     * <p>If the compressed string cannot be smaller than the original input. This method will
     * return the original input.</p>
     *
     * @param text The input string.
     * @return The compressed string or the original input string if the compressed string length
     *   is larger than or equal to the original string length. If the input string is {@code null}
     *   then the returned string will be {@code null}.
     */
    public static String compress(String text) {
        // TODO: Please implement the method.
        // <-start-
        if(text==null)
            return null;
        if(text.equals(""))
            return "";
         StringBuilder stringBuilder=new StringBuilder();
        int num=0;
        char temp=text.charAt(0);
        for(int i=0;i<text.length();i++){
            if(text.charAt(i)==temp){
                num++;
            }else {
                stringBuilder.append(temp);
                stringBuilder.append(num);
                temp=text.charAt(i);
                num=0;
                i--;
            }
        }
        stringBuilder.append(temp);
        stringBuilder.append(num);
        if(stringBuilder.length()>=text.length())
            return text;
        else
            return stringBuilder.toString();
        // --end->
    }

    // TODO: You can add additional helper method if you want.
    // <-start-
    public static void main(String[] args) {
        System.out.println(compress("abcdefg"));
    }
    // --end->
}
