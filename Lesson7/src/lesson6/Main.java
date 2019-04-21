package lesson6;


import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

       lotCats();
    }

    static void lotCats() {

        System.out.println("Введите количество котов");
        int countCat = scanner.nextInt();
        System.out.println("Введите количество еды на тарелке");
        int countPlate = scanner.nextInt();
        Plate plate = new Plate(countPlate);
        Cat[] cat = new Cat[countCat];

        for (int i = 0; i < countCat; i++) {
            System.out.println("Введите аппетит " + (i + 1) + " кота");
            int appetite = scanner.nextInt();
            System.out.println("Введите имя " + (i + 1) + " кота");
            String name = scanner.next();
            cat[i] = new Cat(appetite, name);
        }

        for (int i = 0; i <countCat ; i++) {
            System.out.println("Сытость " + (i+1) + " кота " + cat[i].eat(plate));
        }
        System.out.println("Укажиле количество добавления еды в тарелку");
        plate.addFood(scanner.nextInt());
        System.out.println("Еды в тарелке ");
        plate.info();
    }
}
