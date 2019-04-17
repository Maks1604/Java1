package lesson6;

public class Main {

    public static void main(String[] args) {
        Cat cat = new Cat("Black", "Барсик", 10);
        Dog dog = new Dog("White", "Рекс", 5);
        System.out.println("run cat " + cat.run(50));
        System.out.println("jump cat " + cat.jump(2.5f));
        System.out.println("swing cat " + cat.swim(1));
        System.out.println("run cat " + cat.run(800));
        System.out.println("jump cat " + cat.jump(0.8f));
        System.out.println("swing cat " + cat.swim(5));
        additionHomeWork();
    }

    static void additionHomeWork() {
        String str1 = " Предложение один    Теперь предложение два     Предложение три";
        System.out.println(str1);

        String str2 = str1.replaceAll(" +", " ");
        System.out.println(str2);

        StringBuilder stringBuilder = new StringBuilder(str2);

        for (int i = 2; i < stringBuilder.length(); i++) {
            if (stringBuilder.charAt(i) >= 'A' && stringBuilder.charAt(i) <= 'Я') {
                stringBuilder.setCharAt(i - 1, '.');
                stringBuilder.insert(i, ' ');
                i += 2;
            }
        }
        stringBuilder.append('.');

        System.out.println(stringBuilder.toString());
    }
}
