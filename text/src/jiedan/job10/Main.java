package jiedan.job10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Process{
    String name;
    int comeInTime;
    int workTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getComeInTime() {
        return comeInTime;
    }

    public void setComeInTime(int comeInTime) {
        this.comeInTime = comeInTime;
    }

    public int getWorkTime() {
        return workTime;
    }

    public void setWorkTime(int workTime) {
        this.workTime = workTime;
    }

    public Process(String name, int comeInTime, int workTime) {
        this.name = name;
        this.comeInTime = comeInTime;
        this.workTime = workTime;
    }
    public void run(){
        this.workTime--;
        System.out.println("运行进程"+name+"为1,剩余时间"+workTime);
    }
}
public class Main {
    public static void main(String[] args) {
        List<Process> list=new ArrayList<>();
        Scanner scanner=new Scanner(System.in);
        for(int i=0;i<3;i++){
            String name=scanner.next();
            int comeInTime=scanner.nextInt();
            int workTime=scanner.nextInt();
            list.add(new Process(name,comeInTime,workTime));
        }
        int time=0;
        while(true){
            int current=choose(list,time);
            if(current!=-1)
            list.get(current).run();
            if(list.get(0).getWorkTime()==0&&list.get(1).getWorkTime()==0&&list.get(2).getWorkTime()==0) break;
            time++;
        }
    }
    public static int choose(List<Process> list,int time){//用于选择当前运行进程的方法，返回的是当前进程在list中的下标
        System.out.println(time);
        int result=-1;
        int workTime=Integer.MAX_VALUE;
        int inTime=0;
        for(int i=0;i<list.size();i++){
            if(list.get(i).getComeInTime()<=time&&list.get(i).getWorkTime()>0){
                if(list.get(i).getWorkTime()<workTime){
                    workTime=list.get(i).getWorkTime();
                    result=i;
                    inTime=list.get(i).getComeInTime();
                }else if(list.get(i).getWorkTime()==workTime){
                    if(list.get(i).getComeInTime()>inTime){
                        workTime=list.get(i).getWorkTime();
                        result=i;
                        inTime=list.get(i).getComeInTime();
                    }
                }
            }
        }
        return result;
    }
}
