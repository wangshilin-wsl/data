package jiedan.job2;

abstract class Animal{//动物的接口
    private String category;//动物的类别

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Animal(String category) {
        this.category = category;
    }

    public Animal() {
    }

    public abstract  void run();
}
class Cat extends Animal{//动物类的实现类,陆生生物猫

    @Override
    public void run() {
        System.out.println("猫在陆地跑！！！");
    }
    public Cat() {
        super("陆生生物");
    }

}
class Fish extends Animal{//动物类的实现类,水生生物鱼

    public Fish() {
        super("水生生物");
    }

    @Override
    public void run() {
        System.out.println("鱼在水中游！！！");
    }
}
public class Test12 {
    public static void main(String[] args) {
        Cat cat = new Cat();
        run(cat);
        Fish fish=new Fish();
        run(fish);
    }
    public static void run(Animal animal){
        System.out.println("动物类别："+animal.getCategory());
        animal.run();
    }
}
