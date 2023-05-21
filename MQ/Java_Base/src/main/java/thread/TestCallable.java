package thread;

import java.util.concurrent.*;

/**
 * @author WSL
 * @version 1.0.0
 * @ClassName TestCallable.java
 * @Description TODO
 * @createTime 2022年09月13日 21:42:00
 */
public class TestCallable implements Callable<Boolean> {
    @Override
    public Boolean call() throws Exception {
        System.out.println("312");
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(3);

        Future<Boolean> r1 = service.submit(new TestCallable());
        System.out.println(r1.get());
    }
}
