package lesson6;

import java.util.Random;

public class Cat extends Animal {
    private Random random = new Random();

    public Cat(String color, String name, int age) {
        super(color, name, age);
        super.maxRunLength = random.nextFloat() * 400 + 50;
        super.maxJumpHeight = random.nextFloat() * 2 + 1;
        super.maxSwimLength = -1;
    }


}
