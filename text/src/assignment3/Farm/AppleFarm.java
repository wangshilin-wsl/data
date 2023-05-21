package assignment3.Farm;


import assignment3.Foods.Food;

public class AppleFarm extends Farm {
    public AppleFarm(int totalArea) {
        super(totalArea, Soil.Loam);
    }

    @Override
    public boolean seedFood(Food food) {
        boolean isApple;
        isApple = "Apple".equals(food.getName()) && super.seedFood(food);
        return isApple;
    }
}
