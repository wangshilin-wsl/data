package product_consumer;

/**
 * @author WSL
 * @version 1.0.0
 * @ClassName TestPC.java
 * @Description 生产者-消费者问题-管程法
 * @createTime 2022年09月15日 19:35:00
 */
public class TestPC2 {

    public static void main(String[] args) {
        TV tv = new TV();
        new Player(tv).start();
        new Watcher(tv).start();
    }
}

//生产者
class Player extends Thread {
    TV tv;

    public Player(TV tv) {
        this.tv = tv;
    }
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if(i %2 == 0 ){
                tv.play("快乐大本营" + i);
            }else {
                tv.play("斗鱼" + i);
            }
        }
    }
}

//消费者
class Watcher extends Thread {
    TV tv;

    public Watcher(TV tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
           tv.watch();
        }
    }
}

//产品
class TV{
    String voice;
    boolean flag = true;

    public synchronized void play(String voice){
        if(!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("演员表演了：" + voice);
        //唤醒
        this.notifyAll();
        this.voice = voice;
        this.flag = !this.flag;
    }
    public synchronized void watch(){
        if (flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("观众观看了：" + voice);

        //通知演员表演
        //唤醒
        this.notifyAll();
        this.flag = !this.flag;
    }

}
