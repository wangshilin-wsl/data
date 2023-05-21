package thread;

/**
 * @author WSL
 * @version 1.0.0
 * @ClassName TheadState.java
 * @Description TODO
 * @createTime 2022年09月14日 21:16:00
 */
public class TheadState {
    public static void main(String[] args) {
        final Thread thread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("//////");
            }
        });
        //NEW
        Thread.State state = thread.getState();
        System.out.println(state);

        //NEW
        thread.start();
        state = thread.getState();
        System.out.println(state);

        while (state != Thread.State.TERMINATED){
            System.out.println(state);
            state = thread.getState();
        }
    }
}
