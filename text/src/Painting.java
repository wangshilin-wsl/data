import java.text.DecimalFormat;

class Painting extends Ornament{
    private String painter;
    private int year;
    public Painting(int x, int y, double value, String painter , int year) {
        super(x, y, value);
        this.painter = painter;
        this.year = year;
    }

    public String getPainter() {
        return painter;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String display() {
        //TODO
        DecimalFormat d=new DecimalFormat("###,###,###.00");
        return "A painting by "+this.painter+" painted in "+this.year+", worth $"+d.format(this.valuation);
    }
}