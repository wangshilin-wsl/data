package assignment3.Farm;

import assignment3.Foods.Food;

import java.util.ArrayList;
import java.util.Collections;

public class Farm {
    private int totalArea;
    private ArrayList<Food> foods;
    private Soil farmSoil;

    public Farm(int totalArea, Soil farmSoil) {
        this.totalArea = totalArea;
        this.farmSoil = farmSoil;
        this.foods = new ArrayList<>();
    }

    public int getTotalArea() {
        return totalArea;
    }

    public Soil getFarmSoil() {
        return farmSoil;
    }

    public int getFoodQuantity() {
        return this.foods.size();
    }

    public Food getFood(int index) {
        if (index >= getFoodQuantity() || index <0){
            return null;
        }
        return this.foods.get(index);
    }

    public double getTotalFarmValue() {
        double result=0.0;
        for (Food food : this.foods) {
            result += food.getSellPrice();
        }
        return result;
    }

    public double getReadyToHarvestValue() {
        double result=0.0;
        for (Food food : this.foods) {
            if (food.getDaysToMature() <= food.getDaysSincePotted()){
                result+=food.getSellPrice();
            }
        }
        return result;
    }
    public boolean seedFood(Food food) {
        boolean result = false;
        if (food != null && this.totalArea >= food.getRequiredArea()){
            result=true;
            this.foods.add(food);
            this.totalArea -= food.getRequiredArea();
        }
        return result;
    }
    public Food harvestFood(int index) {
        if (index >= getFoodQuantity() || index <0 ||
        this.getFood(index).getDaysToMature() > this.getFood(index).getDaysSincePotted()){
            return null;
        }
        this.foods.remove(index);
        return this.foods.get(index);
    }
    public void overnightGrow() {
        for (Food food : this.foods) {
            food.grow(this.farmSoil);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder =  new StringBuilder();
        //从高往低排序
        Collections.sort(this.foods);
        for (int i = 0; i < this.foods.size(); i++) {
            stringBuilder.append(i+"-"+this.foods.get(i).toString()+"\n");
        }
        return "Total Farm value: "+this.getTotalFarmValue()+"\n"+
                "Ready to harvest value: "+this.getReadyToHarvestValue()+"\n"+
                stringBuilder.toString();
    }
}
