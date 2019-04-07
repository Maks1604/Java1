package lesson3;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);
    static boolean isStartGame = false;
    static String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

    public static void main(String[] args) {

        System.out.println("Выберите игру");
        System.out.println("1. Угадай число");
        System.out.println("2. Угадать слово");
        System.out.println("0. Выход");
        int munuPoin = scanner.nextInt();
        switch (munuPoin) {
            case 1:
                menuNumbersGame();
                isStartGame = false;
                break;
            case 2:
                menuWordsGame();
                isStartGame = false;
                break;
            case 0:
                return;

            default:
                System.out.println("Вы ввели не правильно");
                break;
        }


    }

    static void menuWordsGame() {
        if (isStartGame) {
            System.out.println("\nПовторить игру еще раз? 1 – да / 0 – нет");
            int menuPoint = scanner.nextInt();

            switch (menuPoint) {
                case 1:
                    compareWords();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Вы ввели не правильно");
                    break;
            }

        } else {
            isStartGame = true;
            compareWords();
        }
        menuWordsGame();
    }

    static void compareWords() {
        int indexWord = random.nextInt(words.length);
        String selectWord = words[indexWord];
        for (; ; ) {
            System.out.println("\nВведите слово");
            String scanWord = scanner.next();
            scanWord = scanWord.toLowerCase();
            if (scanWord.equals(selectWord)) {
                System.out.println("Вы угадвли");
                return;
            } else {
                int minWordLength = Math.min(selectWord.length(), scanWord.length());
                for (int i = 0; i < minWordLength; i++) {
                    if (selectWord.charAt(i) == scanWord.charAt(i)) {
                        System.out.print(selectWord.charAt(i));
                    } else {
                        System.out.print("#");
                    }
                }
                String aggregate = "#".repeat(15 - minWordLength);
                System.out.print(aggregate);
            }

        }

    }


    static void menuNumbersGame() {
        if (isStartGame) {
            System.out.println("\nПовторить игру еще раз? 1 – да / 0 – нет");
            int menuPoint = scanner.nextInt();

            switch (menuPoint) {
                case 1:
                    compareNumbers();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Вы ввели не правильно");
                    break;
            }

        } else {
            isStartGame = true;
            compareNumbers();
        }
        menuNumbersGame();
    }


    static void compareNumbers() {
        int number = random.nextInt(10);

        for (int i = 0; i < 3; i++) {
            System.out.println("Введите число от 0 до 10");
            int scannerNumber = scanner.nextInt();

            if (number == scannerNumber) {
                System.out.println("Вы угадали");
                return;
            } else {
                String bigOrSmall = scannerNumber > number ? "больше" : "меньше";
                System.out.println("Вы ввели число " + bigOrSmall + " загадонного");
            }
        }

        System.out.println("Попытки закончились");
    }

}
