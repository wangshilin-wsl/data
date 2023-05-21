package assignment3.Foods;


import assignment3.Farm.Soil;

import java.text.DecimalFormat;

public abstract class Food implements Comparable<Food> {
    private String name;
    private double sellPrice;
    private int daysToMature;
    private int daysSincePotted;
    private int requiredArea;
    protected Soil preferredSoil;

    public Food(String name, double sellPrice, int daysToMature, int requiredArea) {
        this.name = name;
        this.sellPrice = sellPrice;
        this.daysToMature = daysToMature;
        this.requiredArea = requiredArea;
        this.daysSincePotted=0;
    }

    public String getName() {
        return name;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public int getDaysToMature() {
        return daysToMature;
    }

    public int getDaysSincePotted() {
        return daysSincePotted;
    }

    public int getRequiredArea() {
        return requiredArea;
    }

    public Soil getPreferredSoil() {
        return preferredSoil;
    }

    public abstract double grow(Soil soil);
    protected double grow() {
        DecimalFormat df = new DecimalFormat("#.00");
        double rate = (this.getDaysSincePotted()*1.0)/this.getDaysToMature();
        this.daysSincePotted++;
        if (this.getDaysSincePotted() >= this.getDaysToMature()){
            rate = 1.0;
        }
        return Double.valueOf(df.format(rate)).doubleValue();
    }

    @Override
    public int compareTo(Food o) {
        int result;
        if (this.getSellPrice() > o.getSellPrice()){
            result = -1;
        } else if(this.getSellPrice() < o.getSellPrice()){
            result = 1;
        }else {
            result=0;
        }
        return result;
    }

    @Override
    public String toString() {
        return this.getName()+" ("+this.getPreferredSoil()+") - "+
                this.getDaysSincePotted()+"/"+this.getDaysToMature() +"days";
    }
}
