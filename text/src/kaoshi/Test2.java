package kaoshi;

import java.util.Scanner;

interface Soundable{
    void voice();
    void adjustmentVoice();
}
class  Radio implements Soundable{

    @Override
    public void voice() {
        System.out.println("Radio发声！！！");
    }

    @Override
    public void adjustmentVoice() {

    }
}
class Walkman implements Soundable{

    @Override
    public void voice() {
        System.out.println("Walkman发声！！！");
    }

    @Override
    public void adjustmentVoice() {

    }
}
class Mobilephone implements Soundable{

    @Override
    public void voice() {
        System.out.println("Mobilephone发声！！！");
    }

    @Override
    public void adjustmentVoice() {

    }
}
public class Test2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("请输入设备名字：");
        String name=scanner.next();
        if("Radio".equals(name)){
            new Radio().voice();
        }else if("Walkman".equals(name)){
            new Walkman().voice();
        }else if("Mobilephone".equals(name)){
            new Mobilephone().voice();
        }else{
            System.out.println("无效输入！！！");
        }
    }
}
