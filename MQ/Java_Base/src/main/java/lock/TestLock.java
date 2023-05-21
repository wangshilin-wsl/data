package lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author WSL
 * @version 1.0.0
 * @ClassName TestLock.java
 * @Description 测试lock锁
 * @createTime 2022年09月15日 19:18:00
 */
public class TestLock {
    public static void main(String[] args) {
        TestLock2 testLock2 = new TestLock2();

        new Thread(testLock2).start();
        new Thread(testLock2).start();
        new Thread(testLock2).start();
    }
}

class TestLock2 implements Runnable {
    int ticketNum = 10;
    private final Lock lock = new ReentrantLock();
    @Override
    public void run() {
        while (true){
            lock.lock();
            try {
                if(ticketNum > 0){
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread() + "拿到了" +ticketNum--);
                }else {
                    break;
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }
}
