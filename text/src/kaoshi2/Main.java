package kaoshi2;
enum Color{
    RED("红色", 1), GREEN("绿色", 2), WHITE("白色", 3), YELLO("黄色", 4);
    // 成员变量
    private String name;
    private int index;
    // 构造方法

      Color(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    //覆盖方法
    @Override
    public String toString() {
        return this.index+"_"+this.name;
    }
}
public class Main {
    public static void main(String[] args) {
        System.out.println("名字："+Color.RED.getName()+" 编号为："+Color.RED.getIndex());
        System.out.println(Color.GREEN.toString());
    }
}
