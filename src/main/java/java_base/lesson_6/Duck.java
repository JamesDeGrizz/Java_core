package java_base.lesson_6;

public class Duck extends Animal {
    public Duck(String name, int maxRunDistance, int maxSwimDistance, int maxFlyDistance) {
        // duck can't run just for example
        super(name, false, true, true, maxRunDistance, maxSwimDistance, maxFlyDistance);
        setType(Duck.class.getSimpleName());
    }
}
