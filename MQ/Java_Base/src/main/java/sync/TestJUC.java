package sync;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author WSL
 * @version 1.0.0
 * @ClassName TestJUC.java
 * @Description 测试JUC安全集合
 * @createTime 2022年09月14日 22:33:00
 */
public class TestJUC {
    public static void main(String[] args) {
        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                list.add(Thread.currentThread().getName());
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
