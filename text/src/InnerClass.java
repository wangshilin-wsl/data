/**
 * @author WSL
 * @version 1.0.0
 * @ClassName InnerClass.java
 * @Description TODO
 * @createTime 2022年02月26日 11:25:00
 */
public class InnerClass {
    public static void main(String[] args) {

       hh(() -> System.out.println("fsdf"));
    }


   public static void hh(B b){
        b.hh();
   }
}
