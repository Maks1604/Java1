package lesson2;

import java.util.Arrays;

public class Main {
    //    Задать целочисленный массив, состоящий из элементов 0 и 1.
//    Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и
//    условия заменить 0 на 1, 1 на 0;
    public static void main(String[] args) {
        int[] array = {1, 0, 0, 0, 1, 1, 0, 1, 0};
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] == 1 ? 0 : 1;
        }
        System.out.println(Arrays.toString(array));
        System.out.println();

//Задать пустой целочисленный массив размером 8. С помощью цикла заполнить
// его значениями 0 3 6 9 12 15 18 21;
        int[] arrayMultiplicationThree = new int[8];
        for (int i = 0; i < arrayMultiplicationThree.length; i++) {
            arrayMultiplicationThree[i] = i * 3;
        }
        System.out.println(Arrays.toString(arrayMultiplicationThree));
        System.out.println();
//3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом,
// и числа меньшие 6 умножить на 2;
        int[] arrayNumber = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(arrayNumber));
        for (int i = 0; i < arrayNumber.length; i++) {
            if (arrayNumber[i] < 6) {
                arrayNumber[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(arrayNumber));
        System.out.println();
//Создать квадратный двумерный целочисленный массив (количество строк и столбцов
// одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
        int[][] arrayDiagonal = new int[7][7];
        for (int i = 0; i < arrayDiagonal.length; i++) {
            arrayDiagonal[i][i] = 1;
            arrayDiagonal[i][arrayDiagonal.length - i - 1] = 1;
            System.out.println(Arrays.toString(arrayDiagonal[i]));
        }
        System.out.println();

        //Задать одномерный массив и найти в нем минимальный и максимальный
        // элементы (без помощи интернета);
        int[] arrayMinMax = {8, 4, 5, 6, 7, 1, 56, 77, 32, 9, 3};
        int max = arrayMinMax[0];
        int min = arrayMinMax[0];
        for (int i = 0; i < arrayMinMax.length; i++) {
            if (max < arrayMinMax[i]) {
                max = arrayMinMax[i];
            }
            if (min > arrayMinMax[i]) {
                min = arrayMinMax[i];
            }
        }
        System.out.println("Максимальное число " + max);
        System.out.println("Минимальное число " + min);
        System.out.println();

        int[] arrayBalance = {2, 0, 2, 2, 4,  2};
        System.out.println(checkBalance(arrayBalance));
    }

    static boolean checkBalance(int[] arrayBalance) {
        int sumLeft = arrayBalance[0];
        int i = 1;
        for (; i < arrayBalance.length; i++) {
            if (sumLeft<summ(i,arrayBalance)){
                sumLeft+=arrayBalance[i];
            }else {
                break;
            }
        }
        System.out.println(sumLeft + " ? " + summ(i,arrayBalance));
        return sumLeft==summ(i,arrayBalance);

    }

    static int summ (int i, int[] arrayBalance){
        int sumRight = 0;
        for (; i < arrayBalance.length; i++) {
            sumRight+=arrayBalance[i];
        }
        return sumRight;
    }

}
