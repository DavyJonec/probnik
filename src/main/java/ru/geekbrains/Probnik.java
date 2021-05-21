package ru.geekbrains;

import java.util.Random;
import java.util.Scanner;

public class Probnik {
    private static Random random = new Random();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Пожалуйста, введите своё имя для игры >>>");
        String name = scanner.nextLine();
        System.out.println("Привет " + name + ". Если ты хочешь сыграть в угадай число нажми 1, если в угадай слово нажми 2");
        int user = scanner.nextInt();
        if (user == 1) gameRandomNumber();
        if (user == 2) gameRandomWord();
    }

    private static void gameRandomNumber() {
        do {
            int randomNumber = random.nextInt(10);
            System.out.println("Введите число от 0 до 10:");
            for (int i = 2; i >= 0; i--) {
                int userNumber = scanner.nextInt();
                if (randomNumber == userNumber) {
                    System.out.println("Браво! Вы угадали!");
                    break;
                } else if (i == 0) {
                    System.out.println("К сожалению Вы проиграли. Правильное число было " + randomNumber);
                } else if (randomNumber > userNumber) {
                    System.out.println("Загаданное число больше. У вас осталось " + i + " попытки");
                } else {
                    System.out.println("Загаданное число меньше. У вас осталось " + i + " попытки");
                }
            }
            System.out.println("Сыграть ещё раз? Да - 1, Нет - 0");
        } while (scanner.nextInt() == 1);
    }

    private static void gameRandomWord() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        String answer;
        String wordAI = words[random.nextInt(25)];
        char[] chars = new char[15];

        while (true) {
            System.out.println("Угадайте слово");
            answer = scanner.next();
            if (answer.toLowerCase().equals(wordAI)) {
                System.out.println("Вы победили");
                break;
            }
            filling(chars);
            for (int i = 0; i < answer.length() && i < wordAI.length(); i++) {
                if(answer.charAt(i) == wordAI.charAt(i)) chars[i] = wordAI.charAt(i);
            }
            System.out.println("Вы не угадали слово, но есть похожие буквы");
            System.out.println(new String(chars));
        }
    }

    private static void filling(char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = '#';
        }
    }
}
