package reflect;

/**
 * @author WSL
 * @version 1.0.0
 * @ClassName Father.java
 * @Description TODO
 * @createTime 2022年07月07日 20:50:00
 */
public class Father {
    static {
        System.out.println("father static");
    }

    public Father() {
        System.out.println("father construct");
    }
    public void hh(){
        System.out.println("father");
    }
}
