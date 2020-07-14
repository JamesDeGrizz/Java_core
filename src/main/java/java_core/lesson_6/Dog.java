package java_core.lesson_6;

public class Dog extends Animal {
    public Dog(String name) {
        super(name, true, true, false);

        setType(Dog.class.getSimpleName());

        setMaxRunDistance(500);
        setMaxSwimDistance(10);
    }
}
