package java_core.lesson_6;

public class TestMain {
    public static void main(String[] args) {
        Animal[] animals = new Animal[3];
        animals[0] = new Cat("Simon");
        animals[1] = new Dog("Baskerville");
        animals[2] = new Duck("Donald");

        for (Animal animal : animals) {
            animal.Run(100);
            animal.Run(300);
            animal.Swim(5);
            animal.Swim(200);
            animal.Fly(250);
            animal.Fly(2500);
        }

        Animal.AnimalsCount();
    }
}
