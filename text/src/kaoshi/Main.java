package kaoshi;

class Bank{
    int rest;

    public Bank(int rest) {
        this.rest = rest;
    }

    public int getRest() {
        return rest;
    }

    public void setRest(int rest) {
        this.rest = rest;
    }

    void deposit(){
        this.rest+=5000;
    }
    void withdraw(){
        this.rest-=2000;
    }
}
public class Main {
    static volatile boolean flag=false;//用于控制取钱先运行
    public static void main(String[] args) {
        Bank bank = new Bank(10000);
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                    synchronized (bank) {
                        while(true){
                            if(!flag) break;
                        }
                        for (int i = 1; i <= 12; i++) {
                            System.out.println("2020." + i + "：+" + 5000);
                            flag=true;
                            bank.deposit();
                            bank.notify();
                            try {
                                bank.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        bank.notifyAll();
                    }

            }
        });

        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                    synchronized (bank) {
                        while(true){
                            if(flag) break;
                            try {
                                bank.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        for (int i = 1; i <= 12; i++) {
                            System.out.println("2020." + i + "：-" + 2000);
                            bank.withdraw();
                            bank.notify();
                            try {
                                bank.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            if(i==12){
                                System.out.println("rest："+bank.rest);
                            }
                        }
                        bank.notifyAll();
                    }


            }
        });
        thread2.start();
        thread1.start();
    }
}