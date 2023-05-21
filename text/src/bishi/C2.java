package bishi;

import java.util.Date;

class PersonB{
    String name;
    int age;
    public PersonB() {
        System.out.println("PersonB()被调用");
    }
    public PersonB(String newName) {
        name=newName;
        System.out.println("PersonB(String newName)被调用");
    }
    public void introduce(){
        System.out.println("我是"+name+" ，今年"+age+"岁");
    }
}
class StudentB extends PersonB{
    public StudentB() {
        System.out.println("StudentB()被调用");
    }

    public StudentB(String newName,int newAge) {
        super(newName);
        age=newAge;
    }
}
public class C2 {
    public static void main(String[] args) {
        System.out.println(new Date());

    }
}
