import java.text.DecimalFormat;

public class Ornament extends Furniture {
    protected double valuation;

    public Ornament(int x, int y, double value) {
        super(x,y);
        this.valuation =value;
    }

    public double getValuation() {
        return valuation;
    }

    @Override
    public String display() {
        //TODO
        DecimalFormat d=new DecimalFormat("###,##0.00");
        return "An ornament worth $"+d.format(this.valuation);
    }
}
