package jiedan.job5;
class Bullet{
    int id;
    Bullet next;

    public Bullet(int id) {
        this.id = id;
    }

    public Bullet getNext() {
        return next;
    }

    public void setNext(Bullet next) {
        this.next = next;
    }
}
class Magazine{
    Bullet bullet;//第一个子弹前有一个头节点,用的头插法进入子弹
    Boolean pushBullet(Bullet b){
        if(bullet==null){
            bullet=new Bullet(-1);
        }
       int length=getLength();
        if(length>=6){
            System.out.println("弹夹已满！！！");
            return false;
        }else{
            Bullet temp=bullet.next;
            bullet.next=b;
            b.next=temp;
            return true;
        }
    }
    Boolean popBullet(){
        int length=getLength();
        if(length<=0){//弹夹没有子弹了
            System.out.println("弹夹为空！！！");
            return false;
        }else{
            bullet.next=bullet.next.next;
            return true;
        }

    }
    int getLength(){
        int result=0;//弹夹当前的子弹的数量
        Bullet temp=bullet;
        while(temp!=null){
            result++;
            temp=temp.next;
        }
        return result-1;//出去头节点
    }
}
class Pistol{
    Magazine magazine;
    Boolean shoot(){
        Bullet temp=magazine.bullet.next;
        if(magazine.popBullet()){
            System.out.println("打出"+temp.id+"号子弹!!!");
            return true;
        }else {
            return false;
        }
    }
    void setMagazine(Magazine m){
        this.magazine=m;
    }
}
public class Test {
    public static void main(String[] args) {
        Bullet bullet1 = new Bullet(1);
        Bullet bullet2 = new Bullet(2);
        Bullet bullet3 = new Bullet(3);
        Bullet bullet4 = new Bullet(4);
        Bullet bullet5 = new Bullet(5);
        Bullet bullet6 = new Bullet(6);
        Bullet bullet7 = new Bullet(7);
        Bullet bullet8 = new Bullet(8);
        Bullet bullet9 = new Bullet(9);
        Bullet bullet10 = new Bullet(10);
        Bullet bullet11 = new Bullet(11);
        Bullet bullet12 = new Bullet(12);
        Magazine magazine = new Magazine();
        Magazine magazine1 = new Magazine();
        magazine.pushBullet(bullet1);
        magazine.pushBullet(bullet2);
        magazine.pushBullet(bullet3);
        magazine.pushBullet(bullet4);
        magazine.pushBullet(bullet5);
        magazine.pushBullet(bullet6);
        magazine1.pushBullet(bullet7);
        magazine1.pushBullet(bullet8);
        magazine1.pushBullet(bullet9);
        magazine1.pushBullet(bullet10);
        magazine1.pushBullet(bullet11);
        magazine1.pushBullet(bullet12);
        Pistol pistol = new Pistol();
        pistol.setMagazine(magazine);
        while(pistol.shoot());
        pistol.setMagazine(magazine1);
        while(pistol.shoot());
    }
}
