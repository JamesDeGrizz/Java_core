package java_advanced.lesson_1;

import java.util.HashMap;
import java.util.Map;

public abstract class Creature {
    private final int maxRunDistance;
    private final int maxJumpDistance;
    private final String type;
    private Map<String, Boolean> results;

    public Creature(String type, int maxRunDistance, int maxJumpDistance) throws IllegalArgumentException {
        if (maxRunDistance < 0 || maxJumpDistance < 0) {
            throw new IllegalArgumentException("Any max distance can't be < 0");
        }

        this.type = type;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpDistance = maxJumpDistance;
        results = new HashMap<String, Boolean>();
    }

    public void run(Treadmill mill) {
        StringBuilder bld = new StringBuilder();
        if (mill.getSize() < maxRunDistance) {
            bld.append(type);
            bld.append(" successfully run on ");
            bld.append(mill.getSize());
            bld.append(" distance");
            results.put(bld.toString(), true);
        } else {
            bld.append(type);
            bld.append(" can't run ");
            bld.append(mill.getSize());
            bld.append(" cause it's limit ");
            bld.append(maxRunDistance);
            results.put(bld.toString(), false);
        }
    }

    public void jump(Wall wall) {
        StringBuilder bld = new StringBuilder();
        if (wall.getSize() < maxJumpDistance) {
            bld.append(type);
            bld.append(" successfully jump on ");
            bld.append(wall.getSize());
            bld.append(" distance");
            results.put(bld.toString(), true);
        } else {
            bld.append(type);
            bld.append(" can't jump ");
            bld.append(wall.getSize());
            bld.append(" cause it's limit ");
            bld.append(maxJumpDistance);
            results.put(bld.toString(), false);
        }
    }

    public void showOnlyGoodResults() {
        for (Map.Entry<String, Boolean> result : results.entrySet()) {
            if (result.getValue() == true) {
                System.out.println(result.getKey());
            }
        }
    }

    public void showAllResults() {
        for (Map.Entry<String, Boolean> result : results.entrySet()) {
            System.out.println(result.getKey());
        }
    }
}
