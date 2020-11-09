package machine;

import java.util.Scanner;

public class CoffeeMachine {

    final static Scanner sc = new Scanner(System.in);

    static int water = 400;
    static int milk = 540;
    static int coffee = 120;
    static int cups = 9;
    static int money = 550;
    static String action;

    public static void main(String[] args) {
        do {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            action = sc.next();
            System.out.println();

            switch (action) {
                case "buy":
                    buy();
                    break;
                case "fill":
                    fill();
                    break;
                case "take":
                    take();
                    break;
                case "remaining":
                    printState();
                    break;
            }
        } while (!action.equals("exit"));
        System.exit(0);
    }

    public static void printState() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(coffee + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println("$" + money + " of money");
        System.out.println();
    }

    public static void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        String coffeeType = sc.next();

        switch (coffeeType) {
            case "1" :
                makeCoffee(250, 0, 16, 4);
                break;
            case "2" :
                makeCoffee(350, 75, 20, 7);
                break;
            case "3" :
                makeCoffee(200, 100, 12, 6);
                break;
            case "back":
                break;
        }

        System.out.println();
    }

    public static void makeCoffee(int requiredWater, int requiredMilk, int requiredCoffee, int paidMoney) {
        if (water >= requiredWater && milk >= requiredMilk && coffee >= requiredCoffee) {
            System.out.println("I have enough resources, making you a coffee!");
            cups -= 1;
            water -= requiredWater;
            milk -= requiredMilk;
            coffee -= requiredCoffee;
            money += paidMoney;
        } else {
            System.out.println("Sorry, not enough resources");
        }
    }

    public static void fill() {
        System.out.println("how many ml of water do you want to add:");
        water += sc.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        milk += sc.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        coffee += sc.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        cups += sc.nextInt();
        System.out.println();
    }

    public static void take() {
        System.out.println("I gave you $"+ money);
        money = 0;
        System.out.println();
    }
}
