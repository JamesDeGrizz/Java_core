package java_base;

import java.util.Scanner;
import java.util.Random;

public class lesson_3 {
    private static Scanner sc;
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        PrintGreeting();

        while (true) {
            PrintMenu();
            String command = sc.next();

            switch (command) {
                case "start":
                    RunGame();
                    break;
                case "exit":
                    System.exit(0);
                default:
                    PrintError();
                    break;
            }
        }
    }

    private static void PrintGreeting() {
        System.out.println("Good day to you!");
        System.out.println("I wanna play a game");
        System.out.println("I make a number from 1 to 9 and you have to guess this number");
        System.out.println("I will tell you how close you are");
        System.out.println("So, let's start!");
    }

    private static void PrintMenu() {
        System.out.println("Print \"start\" to begin");
        System.out.println("Print \"exit\" to close the program");
    }

    private static void PrintError() {
        System.out.println("I don't understand. Try again.");
    }

    private static void RunGame() {
        Random rand = new Random();
        int maxValue = 8;
        int myNumber = rand.nextInt(maxValue) + 1; // cause we need from 1 to 9

        // !warning! smells like govnocode^^
        while (true) {
            System.out.println("Enter your number. Or type \"stop\" to break a game");
            String userInput = sc.next();

            if (userInput.contentEquals("stop")) {
                return;
            }

            try {
                int userLastNumber = Integer.parseInt(userInput);

                if (userLastNumber == myNumber) {
                    System.out.println("You win!");
                    return;
                }

                System.out.println("Your number is " + (userLastNumber > myNumber ? "bigger " : "smaller ") + "than my");
            }
            catch (NumberFormatException e) {
                PrintError();
            }
        }
    }
}
