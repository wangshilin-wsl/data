package threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author WSL
 * @version 1.0.0
 * @ClassName TestPool.java
 * @Description 测试线程池
 * @createTime 2022年09月15日 20:02:00
 */
public class TestPool {
    public static void main(String[] args) {
        //参数为线程池大小
        ExecutorService service = Executors.newFixedThreadPool(5);
        service.execute(new MyThread());
        service.execute(new MyThread());
        service.execute(new MyThread());
        service.execute(new MyThread());

        service.shutdown();
    }

}
class MyThread implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
