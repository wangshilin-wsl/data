import java.lang.NullPointerException;
public class Homework05 {
    public static void main(String[] args) {
        //如果try代码有可能有多个异常可以使用多个catch捕获不同异常，相应处理
        //要求子类异常写在前面，父类写在异常后面
        //try ---fianlly 配合使用 相当于没有捕获异常
        try {
            Person person = new Person();
            person = null;
            System.out.println(person.getName());//控指针
            int n1 = 10;
            int n2 = 0;
            int res = n1/n2;//运算错误

        } catch (NullPointerException e){
            System.out.println("空指针异常" + e.getMessage());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {

        }
    }
}
class Person{
    private String name = "jack";
    public  String getName(){
        return name;
    }
}
