package java_advanced.lesson_1;

import java.util.List;

public abstract class Creature {
    private final int maxRunDistance;
    private final int maxJumpDistance;
    private final String type;
    private List<String> events;

    public Creature(String type, int maxRunDistance, int maxJumpDistance) throws IllegalArgumentException {
        if (maxRunDistance < 0 || maxJumpDistance < 0) {
            throw new IllegalArgumentException("Any max distance can't be < 0");
        }

        this.type = type;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpDistance = maxJumpDistance;
    }

    public void Run(Treadmill mill) {
        if (mill.getSize() < maxRunDistance) {
            events.add(type + " successfully run " + mill.getSize());
        } else {
            events.add(type + " can't run " + mill.getSize() + " cause it's limit " + maxRunDistance);
        }
    }

    public void Just(Wall wall) {
        if (wall.getSize() < maxJumpDistance) {
            events.add(type + " successfully jump " + wall.getSize());
        } else {
            events.add(type + " can't jump " + wall.getSize() + " cause it's limit " + maxRunDistance);
        }
    }
}
