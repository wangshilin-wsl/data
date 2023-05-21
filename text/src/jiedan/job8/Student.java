package jiedan.job8;

public class Student {
    String id;
    String name;
    double score;
    static int number=0;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getScore() {
        return score;
    }
    public void setScore(double score) {
        this.score = score;
    }
    public static void display(Student student){
        System.out.println("学生信息：");
        System.out.println("学号："+student.id+" 姓名："+student.name+" " +
                "成绩："+student.score);
    }
    public  Student(String id, String name, double score) {
        this.id = id;
        this.name = name;
        this.score = score;
        number++;
    }
    public static void main(String[] args) {
        Student student1 = new Student("1", "张三", 89.1);
        Student student2 =new Student("2","李四",90);
        Student student3 =new Student("3","王五",100);
        Student.display(student1);
        Student.display(student2);
        Student.display(student3);
        System.out.println("现在有"+Student.number+"个学生！！");
    }
}
