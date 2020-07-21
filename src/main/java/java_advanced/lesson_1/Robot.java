package java_advanced.lesson_1;

public class Robot extends Creature {
    public Robot(int maxRunDistance, int maxJumpDistance) throws IllegalArgumentException {
        super("Robot", maxRunDistance, maxJumpDistance);
    }
}
