package java_core.lesson_6;

public class Duck extends Animal {
    protected Duck(String name) {
        // duck can't run just for example
        super(name, false, true, true);

        setType(Duck.class.getSimpleName());

        setMaxFlyDistance(1500);
        setMaxSwimDistance(500);
    }
}
