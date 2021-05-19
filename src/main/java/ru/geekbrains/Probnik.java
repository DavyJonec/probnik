package ru.geekbrains;

import java.util.Random;
import java.util.Scanner;

public class Probnik {
    private static Random random = new Random();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Please enter your name for the game >>>");
        String name = scanner.nextLine();
        System.out.println("Hello " + name);
        gameRandomNumber();
    }

    private static void gameRandomNumber() {
        do {
            int counter = 3;
            int gamer = 0;
            int randomNumber = random.nextInt(10);
            while(counter > 0 && gamer != randomNumber) {
                System.out.println("Пожалуйста введите число от 0 до 10 включительно");
                gamer = scanner.nextInt();
                if(gamer != randomNumber) {
                    counter--;
                    System.out.println("Ваше число " + (gamer < randomNumber ? "меньше нужного \n" : "больше нужного. \n") + "У вас осталось всего " + counter + " попытки.");
                }
            }
            System.out.println("Вы " + (gamer == randomNumber ? "победили!" : "проиграли."));
            System.out.println("Сыграть ещё раз? Да - 1, Нет - 0");
        } while (scanner.nextInt() == 1);
    }
}

