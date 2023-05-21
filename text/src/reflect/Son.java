package reflect;

/**
 * @author WSL
 * @version 1.0.0
 * @ClassName Son.java
 * @Description TODO
 * @createTime 2022年07月07日 20:51:00
 */
public class Son extends Father{
    static {
        System.out.println("son static");
    }
    public Son() {
        System.out.println("son construct");
    }

    public void hh(){
        System.out.println("son");
    }
}
