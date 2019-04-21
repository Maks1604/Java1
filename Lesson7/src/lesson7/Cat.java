package lesson6;

public class Cat {

    private int appetite;
    private String name;

    public Cat(int appetite, String name) {
        this.appetite = appetite;
        this.name = name;
    }

    public int getAppetite() {
        return appetite;
    }

    public void setAppetite(int appetite) {
        this.appetite = appetite;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean eat(Plate p) {
        return p.decreaseFood(appetite);
    }

}
