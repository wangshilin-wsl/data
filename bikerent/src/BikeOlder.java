import java.text.SimpleDateFormat;
import java.util.Date;

public class BikeOlder {
    private int type;
    private int time;
    private int number;
    private Date rentDate;
    private double money;

    public BikeOlder(int type, int time,int number) {
        this.type = type;
        this.time = time;
        this.number=number;
        this.rentDate=new Date();
        if(type==1){
            money=50*time*number;
        }else if(type==2){
            money=200*time*number;
        }else if(type==3){
            money=600*time*number;
        }
    }

    public double getMoney() {
        return money;
    }
    @Override
    public String toString() {
        String temp="";
        if(type==1){
           temp="hour";
        }else if(type==2){
           temp="day";
        }else if(type==3){
            temp="week";
        }
        return "rentType: for "+temp+"  rentTime: "+time+" rentNumber: "+number+
                " rentDate: " +new SimpleDateFormat("yyyy-MM-dd HH:mm").format(rentDate)
                +" price: "+money;
    }
}
