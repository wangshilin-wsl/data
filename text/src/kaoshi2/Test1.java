package kaoshi2;
class Account{
    private  volatile int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public  int getBalance() {
        return balance;
    }

   public synchronized void quQian(int money){
        this.balance-=money;
   }
}
public class Test1 {
    public static void main(String[] args) throws InterruptedException {
        Account account = new Account(100);
        System.out.println("初始余额为："+account.getBalance());
        new Thread(new Runnable() {
            @Override
            public void run() {
                account.quQian(10);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                account.quQian(20);
            }
        }).start();

        Thread.sleep(3000);//让主线程睡3秒
        System.out.println("剩余余额为："+account.getBalance());
    }
}