package java_base.lesson_6;

public class Cat extends Animal {
    public Cat(String name, int maxRunDistance, int maxSwimDistance, int maxFlyDistance) {
        super(name, true, false, false, maxRunDistance, maxSwimDistance, maxFlyDistance);
        setType(Cat.class.getSimpleName());
    }
}
