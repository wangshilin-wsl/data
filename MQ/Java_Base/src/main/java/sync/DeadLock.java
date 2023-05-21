package sync;

/**
 * @author WSL
 * @version 1.0.0
 * @ClassName DeadLock.java
 * @Description TODO
 * @createTime 2022年09月15日 19:05:00
 */
public class DeadLock {

    public static void main(String[] args) {
        new Makeup(0, "小红").start();
        new Makeup(1, "小兰").start();
    }
}

//口红
class Lipstick {

}

//镜子
class Mirror {

}

class Makeup extends Thread {
    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();

    int choice;
    String girlName;

    public Makeup(int choice, String girlName) {
        this.choice = choice;
        this.girlName = girlName;
    }

    @Override
    public void run() {
        makeup();
    }

    private void makeup() {
        if (choice == 0) {
            //获取口红的锁
            synchronized (lipstick) {
                System.out.println(this.girlName + "获得口红的锁");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //想获得镜子
                synchronized (mirror) {
                    System.out.println(this.girlName + "获得镜子的锁");
                }
            }
        }else {
            //获取口红的锁
            synchronized (mirror) {
                System.out.println(this.girlName + "获得镜子的锁");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //想获得镜子
                synchronized (lipstick) {
                    System.out.println(this.girlName + "获得口红的锁");
                }
            }
        }
    }
}
