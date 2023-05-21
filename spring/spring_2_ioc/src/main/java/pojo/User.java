package pojo;

public class User {
    private String name;
    public User(){
        System.out.println("无参构造方法");
    }
    public User(String name){
        this.name=name;
        System.out.println("有参构造方法");
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void show(){
        System.out.println("name="+name);
    }
}
