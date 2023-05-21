package jiedan.job9;

abstract class Animal{
    public abstract void  getName();
    public abstract void cry();
}
class Dog extends Animal{

    @Override
    public void getName() {
        System.out.print("dog   ");
    }

    @Override
    public void cry() {
        System.out.println("wangwang");
    }
}
class Cat extends Animal{
    @Override
    public void getName() {
        System.out.print("cat   ");
    }
    @Override
    public void cry() {
        System.out.println("miaomiao");
    }
}
class Simulator{
    void playDogSound(Dog dog){
        dog.getName();
        dog.cry();
    }
    void playCatSound(Cat cat){
        cat.getName();
        cat.cry();
    }
}
public class Test {
    public static void main(String[] args) {
        Simulator simulator=new Simulator();
        simulator.playDogSound(new Dog());
        simulator.playCatSound(new Cat());
    }
}
