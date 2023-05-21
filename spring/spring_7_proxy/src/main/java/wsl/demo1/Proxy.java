package wsl.demo1;

public class Proxy implements Rent{
    private Host host;

    public Proxy(Host host) {
        this.host = host;
    }

    public Proxy() {
    }

    @Override
    public void rent() {
        seeHouse();
        host.rent();
        heTong();
        fare();
    }
    //看房
    public void seeHouse(){
        System.out.println("中介带你去看房");
    }
    // 收费
    public void fare(){
        System.out.println("收中介费");
    }
    //签合同
    public void heTong(){
        System.out.println("签租赁合同");
    }
}
