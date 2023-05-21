package bishi;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.*;

class Ticket{//班次信息
    private int id;//班次
    private Date clock;//发车时间
    private String start;//起点站
    private String end;//终点站
    private double time;//行车时间
    private int sum_peo;//额定载量
    private int peo;//已订票人数

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getClock() {
        return clock;
    }

    public void setClock(Date clock) {
        this.clock = clock;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public int getSum_peo() {
        return sum_peo;
    }

    public void setSum_peo(int sum_peo) {
        this.sum_peo = sum_peo;
    }

    public int getPeo() {
        return peo;
    }

    public void setPeo(int peo) {
        this.peo = peo;
    }

    public boolean ticketSales(){//买票
        if(peo<sum_peo&&new Date().getTime()<clock.getTime()){
            peo++;
            return true;
        }else{
            return false;
        }
    }
    public boolean refundForTicket(){//退票
        if(new Date().getTime()<clock.getTime()){
            peo--;
            return true;
        }else{
            return false;
        }
    }
    @Override
    public String toString() {
        return "班次信息：" +
                "班次=" + id +
                "  发车时间=" + new SimpleDateFormat("yyyy-MM-dd HH:mm").format(clock) +
                "  起点站='" + start + '\'' +
                "  终点站='" + end + '\'' +
                "  行车时间=" + time +
                "  额定载量=" + sum_peo +
                "  以订票人数=" + peo;
    }

    public Ticket(int id, Date clock, String start, String end, double time, int sum_peo, int peo) {
        this.id = id;
        this.clock = clock;
        this.start = start;
        this.end = end;
        this.time = time;
        this.sum_peo = sum_peo;
        this.peo = peo;
    }
}
public class Job3 {
    static List<Ticket> list=new ArrayList<>();//用于装售票信息的链表
    static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args)  {
        int op;
        menu();
        System.out.print("请输入你的选择(0~8)：");
        op=scanner.nextInt();
        while(op!=0){
            switch (op){
                case 1:
                    add();
                    break;
                case 2:
                    save();
                    break;
                case 3:
                    browre();
                    break;
                case 4:
                    search();
                    break;
                case 5:
                    del();
                    break;
                case 6:
                    sort();
                    break;
                case 7:
                    refundForTicket();
                    break;
                case 8:
                    ticketSales();
                    break;
            }
            menu();
            System.out.print("请输入你的选择(0~8)：");
            op=scanner.nextInt();
        }
    }
    public static void menu(){
        System.out.println("**************************");
        System.out.println("*1.增加数据   2.导出数据 *");
        System.out.println("*3.浏览数据   4.查询数据 *");
        System.out.println("*5.删除数据   6.排序     *");
        System.out.println("*7.退票       8.售票     *");
        System.out.println("*0.退出                  *");
        System.out.println("**************************");
    }
    //增加一条记录
    public static void add()  {
        try {
            System.out.println("请输入班次信息：班次、发车时间（格式为：yyyy-MM-dd-HH:mm）、起点站、终点站、行车时间、额定载量、已订票人数");
            int id=scanner.nextInt();
            Date clock=new SimpleDateFormat("yyyy-MM-dd-HH:mm").parse(scanner.next());
            String start=scanner.next();
            String end=scanner.next();
            double time=scanner.nextDouble();
            int sum=scanner.nextInt();
            int done=scanner.nextInt();
            Ticket ticket = new Ticket(id,clock,start,end,time,sum,done);
            list.add(ticket);
            System.out.println("添加成功！！！");
        }catch (Exception e){
            System.out.println("输入错误，添加失败!!!");
        }
    }
    //保存文件
    public static void save(){
        try{
            PrintStream stream = new PrintStream(new FileOutputStream("data.txt"));//用的是绝对路径
            for(int i=0;i<list.size();i++){
                stream.println(list.get(i).getId()+" "+
                        new SimpleDateFormat("yyyy-MM-dd HH:mm").format(list.get(i).getClock())+" "+
                        list.get(i).getStart()+" "+
                        list.get(i).getEnd()+" "+
                        list.get(i).getTime()+" "+
                        list.get(i).getSum_peo()+" "+
                        list.get(i).getPeo());
            }
            System.out.println("保存文件成功！！！");
        }catch (Exception E){
            System.out.println("保存文件失败!!!");
        }
    }
    //浏览所有数据
    public static void browre(){
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i).toString());
        }
    }
    //查询数据
    public static void search(){
        System.out.print("请输入要查询班次的班次号或者终点站：");
        String temp=scanner.next();
        for(int i=0;i<list.size();i++){

            if(Integer.toString(list.get(i).getId()).equals(temp)||list.get(i).getEnd().equals(temp)){
                System.out.println(list.get(i).toString());
            }
        }
    }
    //删除一条数据
    public static void del(){
        int id;
        System.out.print("请输入班次的编号:");
        id=scanner.nextInt();
        for(int i=0;i<list.size();i++){
            if(list.get(i).getId()==id){
                list.remove(i);
                System.out.println("删除成功！！！");
                return;
            }
        }
        System.out.println("不存在该班次列车！！！");

    }
    //根据发车时间排序
    public static void sort(){
        list.sort((a,b)->{
            return a.getClock().getTime()-b.getClock().getTime()>0?1:-1;
        });
        browre();
    }
    //退票
    public static void refundForTicket(){
        System.out.print("请输入要退票的班次号：");
        int id=scanner.nextInt();

        for(int i=0;i<list.size();i++){
            if(list.get(i).getId()==id){
                if(list.get(i).refundForTicket()){
                    System.out.println("退票成功！！！");
                }else{
                    System.out.println("时间已过不能退票！！！");
                }
            }
        }
    }
    //订票
    public static void ticketSales(){
        System.out.print("请输入要定票的班次号：");
        int id=scanner.nextInt();

        for(int i=0;i<list.size();i++){
            if(list.get(i).getId()==id){
                if(list.get(i).ticketSales()){
                    System.out.println("订票成功！！！");
                }else{
                    System.out.println("不好意思，票已经卖完啦或者时间已过！！！");
                }
            }
        }
    }
}
