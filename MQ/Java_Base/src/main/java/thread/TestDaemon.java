package thread;

/**
 * @author WSL
 * @version 1.0.0
 * @ClassName TestDaemon.java
 * @Description TODO
 * @createTime 2022年09月14日 21:34:00
 */
public class TestDaemon {

    public static void main(String[] args) {
        God god = new God();
        You you = new You();


        Thread thread1 = new Thread(god);
        //默认是false表示的是用户线程，正常的线程都是用户线程
        thread1.setDaemon(true);
        thread1.start();

        Thread thread2 = new Thread(you);
        thread2.start();
    }
}


class God implements Runnable {

    @Override
    public void run() {
        while (true){
            System.out.println("上帝保佑着你");
        }
    }
}

class You implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.println("您一生都开心的或者");
        }
        System.out.println("bye bye");
    }
}
