package jiedan2;
interface Swim{
    void backstroke();//仰泳
    void butterflystroke();//蝶泳
    void breaststroke();//蛙泳
    void freestyle();//自由泳
}
interface Run{
    void sprint();//短跑
    void longRun();//长跑
    void runAtFullSpeed();//全速跑
}
interface Playball{
    void playBasketball();//打篮球
    void playFootball();//踢足球
    void playBadminton();//打羽毛球
    void playTableTennis();//打乒乓球
}
class Player implements Swim,Run,Playball{

    @Override
    public void backstroke() {
        System.out.println("运动员仰泳！！！");
    }

    @Override
    public void butterflystroke() {
        System.out.println("运动员蝶泳！！！");
    }

    @Override
    public void breaststroke() {
        System.out.println("运动员蛙泳！！！");
    }

    @Override
    public void freestyle() {
        System.out.println("运动员自由泳！！！");
    }

    @Override
    public void sprint() {
        System.out.println("运动员短跑！！！");
    }

    @Override
    public void longRun() {
        System.out.println("运动员长跑！！！");
    }

    @Override
    public void runAtFullSpeed() {
        System.out.println("运动员全速跑！！！");
    }

    @Override
    public void playBasketball() {
        System.out.println("运动员打篮球！！！");
    }

    @Override
    public void playFootball() {
        System.out.println("运动员踢足球！！！");
    }

    @Override
    public void playBadminton() {
        System.out.println("运动员打羽毛球！！！");
    }

    @Override
    public void playTableTennis() {
        System.out.println("运动员打乒乓球！！！");
    }
}
public class Test1 {
    public static void main(String[] args) {
        Player player = new Player();
        player.butterflystroke();
        player.longRun();
        player.playBasketball();
    }
}
