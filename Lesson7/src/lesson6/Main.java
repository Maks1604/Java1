package lesson6;


public class Main {

    public static void main(String[] args) {
        Cat cat = new Cat(50, "Vaska");
        Plate plate = new Plate(49);
        plate.info();
        System.out.println(cat.eat(plate));
        plate.info();


    }
}
