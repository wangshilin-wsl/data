package thread;

/**
 * @author WSL
 * @version 1.0.0
 * @ClassName TestThread1.java
 * @Description TODO
 * @createTime 2022年09月13日 21:24:00
 */
public class Race implements Runnable{
    private volatile int ticketNum = 10;
    @Override
    public void run() {


    }

    public static void main(String[] args) {
        Race race = new Race();

        new Thread(race, "兔子").start();
        new Thread(race, "乌龟").start();
    }
}
