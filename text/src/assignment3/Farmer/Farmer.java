package assignment3.Farmer;

import assignment3.Farm.Farm;
import assignment3.Farm.Soil;
import assignment3.Foods.*;

import java.util.ArrayList;
import java.util.List;

public class Farmer {
    private String name;
    private int energy;
    private Farm farm;

    public Farmer(String name) {
        this.name = name;
        this.energy = 100;
    }

    public Farmer(String name, Farm farm) {
        this.name = name;
        this.farm = farm;
        this.energy = 100;
    }

    public String getName() {
        return name;
    }

    public int getEnergy() {
        return energy;
    }
    public Food getFoodFromFarm(int index) {
        Food temp = null;
        if (this.farm != null){
            temp = this.farm.getFood(index);
        }
        return temp;
    }
    public void sleep() {
        this.energy += 35;
        this.energy = this.energy >= 100 ? 100 : this.energy;
        if(this.farm != null){
            this.farm.overnightGrow();
        }
    }
    public boolean seedFood(Food food) {
        boolean result = false;
        int energy=0;
        if (food instanceof Vegetable){
            energy = 30;
        }
        if (food instanceof Fruit){
            energy = 50;
        }
        if (this.farm != null && this.getEnergy() >= energy && farm.seedFood(food)){
            this.energy -= energy;
            result = true;
        }
        return result;
    }
    public boolean buyFarm(Farm farm) {
        boolean result = false;
        if(this.farm == null){
            this.farm = farm;
            result = true;
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.farm == null){
            stringBuilder.append(this.name+" owns no Farm\n");
        }else {
            stringBuilder.append("Farm info:\n");
            stringBuilder.append(this.farm.toString());
        }
        return "Farmer: "+this.name+"\n"+
                "Energy left: "+this.energy+"/100\n"+
                stringBuilder.toString();
    }

    public static void main(String[] args) {
        Farmer farmer = new Farmer("wsl", new Farm(1000, Soil.Loam));
        farmer.sleep();
        Apple apple = new Apple();
        Apple apple1 = new Apple();
        Cabbage cabbage = new Cabbage();
        List<Food> list=new ArrayList<>();


        farmer.seedFood(apple);
        farmer.sleep();
        farmer.seedFood(cabbage);
        farmer.seedFood(apple1);
        System.out.println(farmer.toString());
        System.out.println(farmer.getEnergy());
        System.out.println(apple.grow(Soil.Loam));

    }
}
