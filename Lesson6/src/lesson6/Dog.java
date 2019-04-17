package lesson6;

public class Dog extends Animal {
    public Dog(String color, String name, int age) {
        super(color, name, age);
        super.maxRunLength = 500;
        super.maxJumpHeight = 0.5f;
        super.maxSwimLength = 10;
    }
}
