package bishi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

abstract class Person{
    private String name;//姓名
    private String id;//身份证号
    private String gender;//性别
    private Date birthday;//出生日期

    public Person(String name, String id, String gender, Date birthday) {
        this.name = name;
        this.id = id;
        this.gender = gender;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + new SimpleDateFormat("yyyy-MM-dd").format(birthday) +
                '}';
    }
}
class Student extends Person{
    private String studentNo;//学号
    private String schoolName;//学校
    private String classIn;//班级

    @Override
    public String toString() {
        return super.toString()+"Student{" +
                "studentNo='" + studentNo + '\'' +
                ", schoolName='" + schoolName + '\'' +
                ", classIn='" + classIn + '\'' +
                '}';
    }

    public Student(String name, String id, String gender, Date birthday, String studentNo, String schoolName, String classIn) {
        super(name, id, gender, birthday);
        this.studentNo = studentNo;
        this.schoolName = schoolName;
        this.classIn = classIn;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getClassIn() {
        return classIn;
    }

    public void setClassIn(String classIn) {
        this.classIn = classIn;
    }
}
class Teacher extends Person{
    private String teacherNo;//教师编号
    private String schoolName;//学校名字
    private String department;//部门

    @Override
    public String toString() {
        return super.toString()+"Teacher{" +
                "teacherNo='" + teacherNo + '\'' +
                ", schoolName='" + schoolName + '\'' +
                ", department='" + department + '\'' +
                '}';
    }

    public Teacher(String name, String id, String gender, Date birthday, String teacherNo, String schoolName, String department) {
        super(name, id, gender, birthday);
        this.teacherNo = teacherNo;
        this.schoolName = schoolName;
        this.department = department;
    }

    public String getTeacherNo() {
        return teacherNo;
    }

    public void setTeacherNo(String teacherNo) {
        this.teacherNo = teacherNo;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
class UnderGraduate extends Student{
    private String major;//专业

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public UnderGraduate(String name, String id, String gender, Date birthday, String studentNo, String schoolName, String classIn, String major) {
        super(name, id, gender, birthday, studentNo, schoolName, classIn);
        this.major = major;
    }

    @Override
    public String toString() {
        return super.toString()+"UnderGraduate{" +
                "major='" + major + '\'' +
                '}';
    }
}
class Graduate extends Student{
    private String direction;//研究方向
    private String adviserName;//导师姓名

    @Override
    public String toString() {
        return super.toString()+"Graduate{" +
                "direction='" + direction + '\'' +
                ", adviserName='" + adviserName + '\'' +
                '}';
    }

    public Graduate(String name, String id, String gender, Date birthday, String studentNo, String schoolName, String classIn, String direction, String adviserName) {
        super(name, id, gender, birthday, studentNo, schoolName, classIn);
        this.direction = direction;
        this.adviserName = adviserName;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getAdviserName() {
        return adviserName;
    }

    public void setAdviserName(String adviserName) {
        this.adviserName = adviserName;
    }
}
public class Job2 {//测试类
    static List<UnderGraduate> underGraduates=new ArrayList<>();//本科生
    static List<Graduate> graduates=new ArrayList<>();//研究生
    static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) throws ParseException {
        int op;
        menu();
        System.out.print("请输入你的选择(0~8)：");
        op=scanner.nextInt();
        while(op!=0){
            switch (op){
                case 1:
                    addUnderGraduates();
                    break;
                case 2:
                    delUnderGraduates();
                    break;
                case 3:
                    updateUnderGraduates();
                    break;
                case 4:
                    displayAllUnderGraduates();
                    break;
                case 5:
                    addGraduates();
                    break;
                case 6:
                    delGraduates();
                    break;
                case 7:
                    updateGraduates();
                    break;
                case 8:
                    displayAllGraduates();
                    break;
            }
            menu();
            System.out.print("请输入你的选择(0~8)：");
            op=scanner.nextInt();
        }
    }
    public static void menu(){
        System.out.println("********************************");
        System.out.println("*1.本科生的增加  2.本科生的删除* ");
        System.out.println("*3.本科生的修改  4.本科生的查询*");
        System.out.println("*5.研究生的增加  6.研究生的删除*");
        System.out.println("*7.研究生的修改  8.研究生的查询*");
        System.out.println("*0.退出                        *");
        System.out.println("********************************");
    }
    public static void addUnderGraduates() throws ParseException {
        System.out.println("请输入本科生的：姓名、身份证号、性别、生日（格式：yyyy-MM-dd）、学号、学校名字、班级、专业");
        String name=scanner.next();
        String id=scanner.next();
        String gender=scanner.next();
        Date birth=new SimpleDateFormat("yyyy-MM-dd").parse(scanner.next());
        String studentId=scanner.next();
        String schoolName=scanner.next();
        String classIn=scanner.next();
        String major=scanner.next();
        underGraduates.add(new UnderGraduate(name,id,gender,birth,studentId,schoolName,classIn,major));
    }
    public static void delUnderGraduates(){
        String studentId;
        System.out.println("请输入要删除本科生的学号:");
        studentId=scanner.next();
        for(int i=0;i<underGraduates.size();i++){
            if(underGraduates.get(i).getStudentNo().equals(studentId)){
                underGraduates.remove(i);
            }
        }
    }
    public static void updateUnderGraduates(){
        String studentId;
        System.out.println("请输入要修改本科生的学号:");
        studentId=scanner.next();
        for(int i=0;i<underGraduates.size();i++){
            if(underGraduates.get(i).getStudentNo().equals(studentId)){
                System.out.println("请输入修改后的班级，专业");
                underGraduates.get(i).setClassIn(scanner.next());
                underGraduates.get(i).setMajor(scanner.next());
            }
        }
    }
    public static void displayAllUnderGraduates(){
        for(int i=0;i<underGraduates.size();i++){
            System.out.println(underGraduates.get(i).toString());
        }
    }


    public static void addGraduates() throws ParseException {
        System.out.println("请输入研究生的：姓名、身份证号、性别、生日（格式：yyyy-MM-dd）、学号、学校名字、班级、研究方向、导师名字");
        String name=scanner.next();
        String id=scanner.next();
        String gender=scanner.next();
        Date birth=new SimpleDateFormat("yyyy-MM-dd").parse(scanner.next());
        String studentId=scanner.next();
        String schoolName=scanner.next();
        String classIn=scanner.next();
        String direction=scanner.next();
        String adviserNmae=scanner.next();
        graduates.add(new Graduate(name,id,gender,birth,studentId,schoolName,classIn,direction,adviserNmae));
    }
    public static void delGraduates(){
        String studentId;
        System.out.println("请输入要删除研究生的学号:");
        studentId=scanner.next();
        for(int i=0;i<graduates.size();i++){
            if(graduates.get(i).getStudentNo().equals(studentId)){
                graduates.remove(i);
            }
        }
    }
    public static void updateGraduates(){
        String studentId;
        System.out.println("请输入要修改研究生的学号:");
        studentId=scanner.next();
        for(int i=0;i<graduates.size();i++){
            if(graduates.get(i).getStudentNo().equals(studentId)){
                System.out.println("请输入修改后的班级，研究方向");
                graduates.get(i).setClassIn(scanner.next());
                graduates.get(i).setDirection(scanner.next());
            }
        }

    }
    public static void displayAllGraduates(){
        for(int i=0;i<graduates.size();i++){
            System.out.println(graduates.get(i).toString());
        }
    }
}
