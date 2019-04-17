package lesson6;

public abstract class Animal {
    private String color;
    private String name;
    private int age;
    protected float maxRunLength;
    protected float maxSwimLength;
    protected float maxJumpHeight;

    public Animal(String color, String name, int age) {
        this.color = color;
        this.name = name;
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean run(float length) {
        return length <= maxRunLength && length >= 0;
    }

    public boolean swim(float length) {
        return length <= maxSwimLength && length >= 0;
    }

    public boolean jump(float height) {
        return height <= maxJumpHeight && height >= 0;
    }
}
