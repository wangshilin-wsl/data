package reflect;

/**
 * @author WSL
 * @version 1.0.0
 * @ClassName Reflect.java
 * @Description TODO
 * @createTime 2022年07月07日 20:35:00
 */
public class Reflect {
    public static void main(String[] args) throws Exception {
//        final Father father = Enum.SON.getaClass().newInstance();
//        final Father father1 = Enum.SON.getaClass().newInstance();
//        father.hh();
//        final Class<Son> sonClass = Son.class;
        final Class<?> aClass = Class.forName("reflect.Son");
        //Son.class.newInstance();       
    }
    public void hh(Integer integer){
        System.out.println(integer);
    }
}
