package sync;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author WSL
 * @version 1.0.0
 * @ClassName UnsafeList.java
 * @Description TODO
 * @createTime 2022年09月14日 22:13:00
 */
public class UnsafeList {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        ReentrantLock lock = new ReentrantLock();
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                lock.lock();
                try {
                    list.add(Thread.currentThread().getName());
                }finally {
                   lock.unlock();
                }
            }).start();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
    }
}
