package sync;

/**
 * @author WSL
 * @version 1.0.0
 * @ClassName UnsafeBuyTicket.java
 * @Description TODO
 * @createTime 2022年09月14日 21:50:00
 */

public class UnsafeBuyTicket implements Runnable {
    private  int ticketNum = 10;
    boolean flag = true;
    @Override
    public void run() {
        while (flag){
            try {
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private synchronized void buy() throws InterruptedException {
        if (ticketNum <= 0){
            flag = false;
            return ;
        }
        Thread.sleep(100);
        System.out.println(Thread.currentThread().getName() + "拿到"+ ticketNum--);
    }

    public static void main(String[] args) {
        UnsafeBuyTicket thread1 = new UnsafeBuyTicket();

        new Thread(thread1, "小明").start();
        new Thread(thread1, "老师").start();
        new Thread(thread1, "黄牛").start();
    }
}
