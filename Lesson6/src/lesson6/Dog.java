package lesson6;

import java.util.Random;

public class Dog extends Animal {
    private Random random = new Random();

    public Dog(String color, String name, int age) {
        super(color, name, age);
        super.maxRunLength = random.nextFloat() * 900 + 100;
        super.maxJumpHeight = random.nextFloat();
        super.maxSwimLength = random.nextFloat() * 9 + 1;
    }
}
