package assignment3.Foods;


import assignment3.Farm.Soil;

public class Vegetable extends Food {
    private int count;
    private double rate;
    public Vegetable(String name, double sellPrice, int daysToMature, int requiredArea) {
        super(name, sellPrice, daysToMature, requiredArea);
        this.preferredSoil = Soil.Loam;
        this.count = 0;
    }

    @Override
    public double grow(Soil soil) {
        double result;
        if(soil == this.preferredSoil){
            result = this.grow();
        }else {
            if(count == 0){
                result = this.grow();
                rate=result;
            }
            result = rate;
            count = (count + 1)%2;
        }
        return result;
    }
}
