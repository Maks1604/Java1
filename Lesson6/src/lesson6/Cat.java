package lesson6;

public class Cat extends Animal {
    public Cat(String color, String name, int age) {
        super(color, name, age);
        super.maxRunLength = 200;
        super.maxJumpHeight = 2;
        super.maxSwimLength = -1;
    }


}
