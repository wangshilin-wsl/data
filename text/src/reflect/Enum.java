package reflect;

/**
 * @author WSL
 * @version 1.0.0
 * @ClassName Enum.java
 * @Description TODO
 * @createTime 2022年07月07日 20:53:00
 */
public enum Enum {
    SON(1, Son.class),
    FATHER(2, Father.class);


    private Integer id;
    private Class<? extends Father> aClass;

    Enum(Integer id, Class<? extends Father> aClass) {
        this.id = id;
        this.aClass = aClass;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Class<? extends Father> getaClass() {
        return aClass;
    }

    public void setaClass(Class<? extends Son> aClass) {
        this.aClass = aClass;
    }
}
