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
        System.out.println("Введите число клеток для выигрыша");
        row_lenght = scanner.nextInt();
        System.out.println("Ввдите число клеток по диогонали");
        size_x = scanner.nextInt();
        if (size_x >= row_lenght && row_lenght > 2) {
            if (size_x > 2) {
                size_y = size_x;
                arr = new char[size_y][size_x];
                for (int i = 0; i < size_y; i++) {
                    for (int j = 0; j < size_x; j++) {
                        arr[i][j] = empty_cell;
                    }
                }
            } else {
                System.out.println("Введите положительное число и больше 2");
                createGrid();
            }
        } else {
            System.out.println("Число клеток выиграша больше чем клеток по диогонали");
            createGrid();
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

    static int[] movePlayer() {
        System.out.println("Введите координаты");
        System.out.print("x = ");
        int x = scanner.nextInt() - 1;
        System.out.print("y = ");
        int y = scanner.nextInt() - 1;
        int[] coordinats= null;
        if (isCellValid(x, y)) {
            arr[y][x] = cross_cell;
            coordinats =new int[]{x, y};
        } else {
            System.out.println("Вы не можете походить в эту клетку");
            coordinats=movePlayer();
        }
        return coordinats;
    }

    static int[] moveAI() {
        int x = random.nextInt(size_x);
        int y = random.nextInt(size_y);
        int[] coordinats= null;
        if (isCellValid(x, y)) {
            arr[y][x] = zero_cell;
            coordinats =new int[]{x, y};
        } else {
            System.out.println("Координаты заняты уже");
            coordinats=moveAI();
        }
        return coordinats;
    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= size_x || y < 0 || y >= size_y) return false;
        if (arr[y][x] == empty_cell) return true;
        return false;
    }

    static boolean isWin(int[] coordinats) {
        return isWinLineHorizontal(coordinats) ||
                isWinLineVertical(coordinats) ||
                isWinLineMainDiagonal(coordinats) ||
                isWinLineAdditionDiagonal(coordinats);

    }

    static boolean isWinLineHorizontal(int[] coordinats) {
        int count_cells = 0;
        int x = coordinats[0];
        int y = coordinats[1];
        char symbol = arr[y][x];
        for (int i = x; i < size_x && symbol == arr[y][i]; i++) {
            count_cells++;
        }
        for (int i = x - 1; i >= 0 && symbol == arr[y][i]; i--) {
            count_cells++;
        }
        return count_cells >= row_lenght;
    }

    static boolean isWinLineVertical(int[] coordinats) {
        int count_cells = 0;
        int x = coordinats[0];
        int y = coordinats[1];
        char symbol = arr[y][x];
        for (int i = y; i < size_y && symbol == arr[i][x]; i++) {
            count_cells++;
        }
        for (int i = y - 1; i >= 0 && symbol == arr[i][x]; i--) {
            count_cells++;
        }
        return count_cells >= row_lenght;
    }

    static boolean isWinLineMainDiagonal(int[] coordinats) {
        int count_cells = 0;
        int x = coordinats[0];
        int y = coordinats[1];
        char symbol = arr[y][x];
        for (int i = y, j = x; i < size_y && j < size_x && symbol == arr[i][j]; i++, j++) {
            count_cells++;
        }
        for (int i = y - 1, j = x - 1; i >= 0 && j >= 0 && symbol == arr[i][j]; i--, j--) {
            count_cells++;
        }
        return count_cells >= row_lenght;
    }

    static boolean isWinLineAdditionDiagonal(int[] coordinats) {
        int count_cells = 0;
        int x = coordinats[0];
        int y = coordinats[1];
        char symbol = arr[y][x];
        for (int i = y, j = x; i >= 0 && j < size_x && symbol == arr[i][j]; i--, j++) {
            count_cells++;
        }
        for (int i = y, j = x - 1; i < size_y && j >= 0 && symbol == arr[i][j]; i++, j--) {
            count_cells++;
        }
        return count_cells >= row_lenght;
    }

    static void Run() {
        int count_move = 0;
        createGrid();
        paintGrid();
        int max_move = size_x * size_y;
        while (true) {

            count_move++;

            if (isWin(movePlayer())) {
                paintGrid();
                System.out.println("Выиграл игрок");
                break;
            }

            if (count_move == max_move) {
                paintGrid();
                System.out.println("Ничья");
                break;
            }

            count_move++;

            if (isWin(moveAI())) {
                paintGrid();
                System.out.println("Выиграл компьютер");
                break;
            }

            if (count_move == max_move) {
                paintGrid();
                System.out.println("Ничья");
                break;
            }
            paintGrid();
        }


    }


    public static void main(String[] args) {
        Run();
    }


}
