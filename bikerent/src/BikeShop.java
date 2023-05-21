import java.util.ArrayList;
import java.util.List;

public class BikeShop {
    int bikeNumber;
    List<BikeOlder> list=new ArrayList<>();

    public int getBikeNumber() {
        return bikeNumber;
    }

    public BikeShop(int bikeNumber) {
        this.bikeNumber = bikeNumber;
    }

    public String  rent(int type, int time, int number){
        if(number<=bikeNumber){
            list.add(new BikeOlder(type,time,number));
            bikeNumber-=number;
            return "Rent succeeded";
        }else {
            return "The number of bicycles is not enough, and the rental fails";
        }
    }
    public void Checkout(){
        double money=0;
        System.out.println("The Order Information:");
        for(int i=0;i<list.size();i++){
            money+=list.get(i).getMoney();
            System.out.println(list.get(i).toString());
        }
        System.out.println("You need pay "+money);
    }
}
