import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BikeShop bikeShop = new BikeShop(100);
        int op,number,time;
        Scanner scanner=new Scanner(System.in);
        menu();
        System.out.print("Choose Your option:");
        op=scanner.nextInt();
        while(op!=0){
            switch (op){
                case 1: {
                    System.out.print("Please input the amount you want rent:");
                    number = scanner.nextInt();
                    System.out.print("How many hours do you want to rent:");
                    time = scanner.nextInt();
                    System.out.println(bikeShop.rent(1, time, number));
                    break;
                }
                case 2: {
                    System.out.print("Please input the amount you want rent:");
                    number = scanner.nextInt();
                    System.out.print("How many days do you want to rent:");
                    time = scanner.nextInt();
                    System.out.println(bikeShop.rent(2, time, number));
                    break;
                }
                case 3: {
                    System.out.print("Please input the amount you want rent:");
                    number = scanner.nextInt();
                    System.out.print("How many weeks do you want to rent:");
                    time = scanner.nextInt();
                    System.out.println(bikeShop.rent(3, time, number));
                    break;
                }
                case 4: {
                    System.out.println("The number of bicycles currently available is: " + bikeShop.getBikeNumber());
                    break;
                }
                case 5: {
                    int people;
                    System.out.println("Please enter the number of people");
                    people = scanner.nextInt();
                    if (people >= 3 && people <= 5) {
                        if (people <= bikeShop.getBikeNumber()) {
                            for (int i = 1; i <= people; i++) {
                                int temp;
                                menu1();
                                System.out.print("Choose the " + i + "st type you choose:");
                                temp = scanner.nextInt();
                                System.out.print("How many time do you want to rent:");
                                time = scanner.nextInt();
                                bikeShop.rent(temp, time, 1);
                            }
                        } else {
                            System.out.println("The number of bicycles is not enough");
                        }
                    } else {
                        System.out.println("The error number of people");
                    }
                    break;
                }
                case 6: {
                    bikeShop.Checkout();
                    break;
                }
            }//switch
            menu();
            System.out.print("Choose Your option:");
            op=scanner.nextInt();
        }//whille
    }
    public static void menu(){
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("********Welcome to the bicycle rental system*********");
        System.out.println("*1.Rent by the hour(50/h)  2.Rent by the day(200/d) *");
        System.out.println("*3.Rent by the week(600/w) 4.View available bicycles*");
        System.out.println("*5.Rent for the family(3-5people)   6.Checkout      *");
        System.out.println("*0.exit                                             *");
        System.out.println("*****************************************************");
        System.out.println("-------------------------------------------------------------------------------");
    }
    public static void menu1(){
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("********Please choose the type you want rent*********");
        System.out.println("*1.Rent by the hour(50/h)  2.Rent by the day(200/d) *");
        System.out.println("*3.Rent by the week(600/w) 0.exit                   *");
        System.out.println("*****************************************************");
        System.out.println("-------------------------------------------------------------------------------");
    }
}
