package jiedan.job7;
class Student{
    String id;
    String name;
    double score;

    public Student(String id, String name, double score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }
}
public class StudentInformation {
    static int number=0;
    public Student create(String id,String name, double score){
        number++;
        return new Student(id,name,score);
    }
    public void printlnformation(Student student){
        System.out.println("学生信息: ");
        System.out.println("学号："+student.id+"  姓名："+student.name+"  成绩："+student.score);
    }
    public int showNumber(){
        return number;
    }

    public static void main(String[] args) {
        StudentInformation studentInformation = new StudentInformation();
        Student student1 = studentInformation.create("001", "张三", 90);
        Student student2 = studentInformation.create("002", "李四", 80);
        Student student3 = studentInformation.create("003", "王五", 100);
        studentInformation.printlnformation(student1);
        studentInformation.printlnformation(student2);
        studentInformation.printlnformation(student3);
        System.out.println("当前总学生数："+studentInformation.showNumber());
    }
}
