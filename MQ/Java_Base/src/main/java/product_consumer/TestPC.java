package product_consumer;

/**
 * @author WSL
 * @version 1.0.0
 * @ClassName TestPC.java
 * @Description 生产者-消费者问题-管程法
 * @createTime 2022年09月15日 19:35:00
 */
public class TestPC {

    public static void main(String[] args) {
        SyncContainer container = new SyncContainer();

        new Producer(container).start();
        new Consumer(container).start();
    }
}

//生产者
class Producer extends Thread {
    SyncContainer container;

    public Producer(SyncContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("生产第" + i + "只鸡");
            container.push(new Chicken(i));
        }
    }
}

//消费者
class Consumer extends Thread {
    SyncContainer container;

    public Consumer(SyncContainer container) {
        this.container = container;
    }
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            Chicken chicken = container.pop();
            System.out.println("消费第" + chicken.getId() + "只鸡");
        }
    }
}

//产品
class Chicken{
    int id;

    public Chicken(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
//缓冲区
class SyncContainer{
    Chicken[] chickens = new Chicken[10];
    int count = 0;

    public synchronized void push(Chicken chicken){
        //如果容器满了，就需要等待消费者消费
        if(count == chickens.length){
            //通知消费者消费，生产者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        chickens[count++] = chicken;
        this.notifyAll();
    }

    public synchronized Chicken pop(){
        //如果容器满了，就需要等待消费者消费
        if(count == 0){
            //等待生产者生产，消费者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notifyAll();
       return chickens[--count];
    }
}
