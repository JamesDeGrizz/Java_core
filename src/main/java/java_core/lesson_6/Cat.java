package java_core.lesson_6;

public class Cat extends Animal {
    public Cat(String name) {
        super(name, true, false, false);

        setType(Cat.class.getSimpleName());

        setMaxRunDistance(200);
    }
}
