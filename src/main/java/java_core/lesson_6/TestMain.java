package java_core.lesson_6;

public class TestMain {
    public static void main(String[] args) {
        Animal[] animals = new Animal[6];
        animals[0] = new Cat("Simon", 200, 0, 0);
        animals[1] = new Cat("Garfield", 10, 0, 0);
        animals[2] = new Dog("Milo", 1000, 100, 0);
        animals[3] = new Dog("Goofy", 500, 50, 0);
        animals[4] = new Duck("Donald", 0, 500, 2500);
        animals[5] = new Duck("DarkwingDuck", 0, 1500, 6500);

        for (Animal animal : animals) {
            System.out.println("Greetings " + animal + '!');

            animal.Run(5);
            animal.Run(100);
            animal.Run(300);

            System.out.println();

            animal.Swim(5);
            animal.Swim(200);
            animal.Swim(1000);

            System.out.println();

            animal.Fly(250);
            animal.Fly(3000);
            animal.Fly(10000);

            System.out.println();
        }

        Animal.AnimalsCount();
    }
}
