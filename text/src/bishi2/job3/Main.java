package bishi2.job3;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static final int MAX_VALUE = 100;

    public static void main (String[] args) {
        Scanner console = new Scanner(System.in);
        Random rand = new Random();
        String op = "yes";
        double guesses = 0;
        int games = 0;
        int min = 1000;

        //here comes the games
        while (op.startsWith("y") || op.startsWith("Y")) {
            int times = playGames(console, rand);
            if (min > times) {
                min = times;
            }
            guesses += times;
            games++;
            System.out.print("Do you want to play again? ");
            op = console.next();
            System.out.println();
        }

        //here comes the results of the game
        doCalc (guesses, games, min);
    }

    //this method produces a single game
    public static int playGames(Scanner console, Random rand) {
        System.out.println("I'm thinking of a number between 1 and " + MAX_VALUE +"...");
        int answer = rand.nextInt(MAX_VALUE)+1;
        System.out.println(answer);
        int guess = 0;
        int times = 0;
        while (guess != answer) {
            System.out.print("Your guess? ");
            guess = console.nextInt();

            if (guess > answer) {
                System.out.println("It\'s higher.");
                times++;
            } else if (guess < answer) {
                System.out.println("It\'s lower.");
                times++;
            } else {
                times++;
                System.out.println("You got it right in " + times + " guesses!");
            }
        }
        return times;
    }

    //this method does the calculation of the results
    public static void doCalc (double guesses, int games, int min) {
        System.out.println("Overall results:");
        System.out.println("Total games   = " + games);
        System.out.println("Total guesses = " + guesses);
        System.out.println("Guesses/game  = " + guesses/games);
        System.out.println("Best game     = " + min);
    }
}
