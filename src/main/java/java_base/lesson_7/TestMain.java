package java_base.lesson_7;

public class TestMain {
    public static void main(String[] args) {
        Cat cat = new Cat("Martin", 5);
        Plate plate = new Plate(5);

        plate.info();
        cat.eat(plate);
        plate.info();
        plate.addFood(3);
        plate.info();
    }
}
