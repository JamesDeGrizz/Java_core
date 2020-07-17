package java_base.lesson_6;

public class Dog extends Animal {
    public Dog(String name, int maxRunDistance, int maxSwimDistance, int maxFlyDistance) {
        super(name, true, true, false, maxRunDistance, maxSwimDistance, maxFlyDistance);
        setType(Dog.class.getSimpleName());
    }
}
