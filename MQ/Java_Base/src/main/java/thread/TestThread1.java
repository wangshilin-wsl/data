package thread;

/**
 * @author WSL
 * @version 1.0.0
 * @ClassName TestThread1.java
 * @Description TODO
 * @createTime 2022年09月13日 21:24:00
 */
public class TestThread1 implements Runnable{
    private volatile int ticketNum = 10;
    @Override
    public void run() {
        while (true){
            if(ticketNum <= 0){
                break;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() +"拿到了" + ticketNum-- + "票");
        }

    }

    public static void main(String[] args) {
        TestThread1 thread1 = new TestThread1();

        new Thread(thread1, "小明").start();
        new Thread(thread1, "老师").start();
        new Thread(thread1, "黄牛").start();
    }
}
