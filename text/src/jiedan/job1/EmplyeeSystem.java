package jiedan.job1;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

class Employee{
    String id;//职工号
    String name;//姓名
    String sex;//性别
    Date birth;//出生年月
    String degree;//学历
    String work;//职务
    int salary;//工资
    String address;//地址
    String tel;//电话

    @Override
    public String toString() {
        return "职工信息：{" +
                "职工号：'" + id + '\'' +
                ", 姓名：'" + name + '\'' +
                ", 性别：'" + sex + '\'' +
                ", 出生日期：" + new SimpleDateFormat("yyyy-MM-dd").format(birth) +
                ", 学历：'" + degree + '\'' +
                ", 职位：'" + work + '\'' +
                ", 工资：'" + salary + '\'' +
                ", 地址：'" + address + '\'' +
                ", 电话：'" + tel + '\'' +
                '}';
    }

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Employee() {
    }

    public Employee(String id, String name, String sex, Date birth, String degree, String work, int salary, String address, String tel) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.birth = birth;
        this.degree = degree;
        this.work = work;
        this.salary = salary;
        this.address = address;
        this.tel = tel;
    }
}
public class EmplyeeSystem {
   static List<Employee> list=new ArrayList<>();
    public static void main(String[] args) {
        String filename=null;
        int op=0;
        Scanner scanner=new Scanner(System.in);
        menu();
        System.out.print("请输入你的选择：");
        op=scanner.nextInt();
        while(op!=0){
            if(op<0||op>6) System.out.println("无效的选择！！！");
            switch (op){
                case 1:
                    System.out.print("请输入所需要读取文件的名字：");
                    filename=scanner.next();
                    readIn(filename);
                    break;
                case 2:
                    displayAll();
                    break;
                case 3:
                    sortBySalary();
                    break;
                case 4:
                    System.out.print("请输入要删除的职工的职工号：");
                    String id=scanner.next();
                    del(id);
                    break;
                case 5:
                    System.out.print("请输入要修改的职工的职工号：");
                    String id1=scanner.next();
                    update(id1);
                    break;
                case 6:
                    save(filename);
                    break;
            }
            menu();
            System.out.print("请输入你的选择：");
            op=scanner.nextInt();
        }
    }
    public static void menu(){//显示操作菜单
        System.out.println("************************");
        System.out.println("*1.录入职工信息        *");
        System.out.println("*2.查看当前所有职工信息 *");
        System.out.println("*3.按工资排序查看      *");
        System.out.println("*4.删除职工            *");
        System.out.println("*5.修改职工            *");
        System.out.println("*6.保存到读取文件中    *");
        System.out.println("*0.退出系统            *");
        System.out.println("************************");
    }
    public static void readIn(String filename){
        FileReader fileread= null;
        try {
            //C:\Users\王世林\IdeaProjects\text\src\jiedan\job1\Employee.txt
            fileread = new FileReader(filename);
            BufferedReader bufferread=new BufferedReader(fileread);
            String temp;
            while((temp=bufferread.readLine())!=null){
                String[] split = temp.split(" ");
                String id=split[0];//职工号
                String name=split[1];//姓名
                String sex=split[2];//性别
                Date birth=new SimpleDateFormat("yyyy-MM-dd").parse(split[3]);//出生年月
                String degree=split[4];//学历
                String work=split[5];//职务
                int salary=Integer.parseInt(split[6]);//工资
                String address=split[7];//地址
                String tel=split[8];//电话
                Employee employee=new Employee(id,name,sex,birth,degree,work,salary,address,tel);
                list.add(employee);
            }
            System.out.println("读取成功！！！");
        } catch (FileNotFoundException e) {
            System.out.println("抱歉，没找到文件！！！");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
    public static void displayAll(){
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i).toString());
        }
    }
    public static void sortBySalary(){
        List<Employee> temp=new ArrayList<>();
        for(int i=0;i<list.size();i++){
           temp.add(list.get(i));
        }
        temp.sort((o1, o2) -> o1.salary-o2.salary);
        for(int i=0;i<temp.size();i++){
            System.out.println(temp.get(i).toString());
        }
    }
    public static void del(String id){
        int j=0;
        for(int i=0;i<list.size();i++){
            if(list.get(i).id.equals(id)) {
                list.remove(i);
                j++;
            }
        }
        if(j==0){
            System.out.println("不存在该职工！！！");
        }else {
            System.out.println("删除成功！！！");
        }
    }
    public static void update(String id1){
        Scanner scanner=new Scanner(System.in);
        int j=0;
        for(int i=0;i<list.size();i++){
            if(list.get(i).id.equals(id1)) {
                System.out.print("请输入修改后的职工号：");
                String id=scanner.next();//职工号
                for(int k=0;k<list.size();k++){
                    if(k==i) continue;
                    if(list.get(k).getId().equals(id)){
                        System.out.println("职工号不能重复！！！");
                        return;
                    }
                }
                System.out.print("请输入修改后的姓名：");
                String name=scanner.next();//姓名
                System.out.print("请输入修改后的性别：");
                String sex=scanner.next();//性别
                Date birth=null;
                try {
                    System.out.print("请输入修改后的出生年月：");
                     birth=new SimpleDateFormat("yyyy-MM-dd").parse(scanner.next());//出生年月
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                System.out.print("请输入修改后的学历：");
                String degree=scanner.next();//学历
                System.out.print("请输入修改后的职务：");
                String work=scanner.next();//职务
                System.out.print("请输入修改后的工资：");
                int salary=Integer.parseInt(scanner.next());//工资
                System.out.print("请输入修改后的地址：");
                String address=scanner.next();//地址
                System.out.print("请输入修改后的电话：");
                String tel=scanner.next();//电话
                j++;

                list.get(i).id=id;
                list.get(i).name=name;
                list.get(i).sex=sex;
                list.get(i).birth=birth;
                list.get(i).degree=degree;
                list.get(i).work=work;
                list.get(i).salary=salary;
                list.get(i).address=address;
                list.get(i).tel=tel;
                break;
            }
        }
        if(j==0){
            System.out.println("不存在该职工！！！");
        }else {
            System.out.println("修改成功！！！");
        }
    }
    public static void save(String filename){
        try {
            PrintStream p=new PrintStream(new FileOutputStream(filename));
            for(int i=0;i<list.size();i++){
                p.print(list.get(i).id+" ");
                p.print(list.get(i).name+" ");
                p.print(list.get(i).sex+" ");
                p.print(new SimpleDateFormat("yyyy-MM-dd").format(list.get(i).birth)+" ");
                p.print(list.get(i).degree+" ");
                p.print(list.get(i).work+" ");
                p.print(list.get(i).salary+" ");
                p.print(list.get(i).address+" ");
                p.println(list.get(i).tel);
            }
            System.out.println("保存成功！！！");
        } catch (FileNotFoundException e) {
            System.out.println("抱歉，没找到文件！！！");
        }
    }
}
