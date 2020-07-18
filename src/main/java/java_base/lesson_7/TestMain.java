package java_base.lesson_7;

public class TestMain {
    public static void main(String[] args) {
        Cat[] cats = new Cat[5];
        cats[0] = new Cat("Martin", 5);
        cats[1] = new Cat("Garfield", 10);
        cats[2] = new Cat("Simon", 5);
        cats[3] = new Cat("Tom", 3);
        cats[4] = new Cat("Cat", 7);

        Plate plate = new Plate(21);

        for (Cat cat : cats) {
            cat.eat(plate);
        }
    }
}
