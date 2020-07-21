package java_advanced.lesson_1;

public class Course {
    private final int courseSize;
    private Obstacle[] course;

    public Course() {
        courseSize = 6;
        course = new Obstacle[courseSize];

        course[0] = new Treadmill(100);
        course[1] = new Wall(1);
        course[2] = new Treadmill(1000);
        course[3] = new Wall(5);
        course[4] = new Treadmill(10000);
        course[5] = new Wall(10);
    }

    public void doIt(Team tm) throws IllegalArgumentException {
        if (tm == null) {
            throw new IllegalArgumentException("team is null");
        }

        for (Creature creature : tm.getTeam()) {
            for (Obstacle obs : course) {
                if (obs instanceof Wall) {
                    creature.Jump((Wall) obs);
                }
                if (obs instanceof Treadmill) {
                    creature.Run((Treadmill) obs);
                }
            }
        }
    }
}
