package java_advanced.lesson_1;

public class Human extends Creature {

    public Human(int maxRunDistance, int maxJumpDistance) throws IllegalArgumentException {
        super("Human", maxRunDistance, maxJumpDistance);
    }
}
