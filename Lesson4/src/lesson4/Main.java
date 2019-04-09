package lesson4;

import java.util.Random;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    static int size_x;
    static int size_y;
    static int row_lenght;
    static char empty_cell = ' ';
    static char cross_cell = 'X';
    static char zero_cell = '0';
    static char arr[][];

    static void createGrid() {
        System.out.println("Ввдите число клеток по диогонали");
        size_x = scanner.nextInt();
        size_y = size_x;
        arr = new char[size_y][size_x];
        for (int i = 0; i < size_y; i++) {
            for (int j = 0; j < size_x; j++) {
                arr[i][j]=empty_cell;
            }
        }
    }

    static void paintGrid() {
        System.out.println("-".repeat(size_x * 2 + 1));
        for (int i = 0; i < size_y; i++) {
            System.out.print("|");
            for (int j = 0; j < size_x; j++) {
                System.out.print(arr[i][j] + "|");
            }
            System.out.println("\n" + "-".repeat(size_x * 2 + 1));
        }
    }



    public static void main(String[] args) {
        createGrid();
        paintGrid();
    }
}
