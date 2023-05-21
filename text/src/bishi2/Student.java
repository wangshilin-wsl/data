package bishi2;

import java.io.*;

public class Student {
    private String name;
    private int age;
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void main(String[] args) throws IOException {



        //三个学生的信息
        Student student1 = new Student("张三", 21);
        Student student2 = new Student("李四", 20);
        Student student3 = new Student("王五", 20);
        //用的绝对路径
        PrintStream p=new PrintStream(new FileOutputStream("data.txt"));//用于写出的流
        p.println(student1.getName()+" "+student1.getAge());
        p.println(student2.getName()+" "+student2.getAge());
        p.println(student3.getName()+" "+student3.getAge());
        BufferedReader reader = new BufferedReader(new FileReader("data.txt"));//用于读取文件
        String temp;
        while((temp=reader.readLine())!=null){
            System.out.println(temp);
        }
    }
}
