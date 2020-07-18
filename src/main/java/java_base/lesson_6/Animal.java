package java_base.lesson_6;

public abstract class Animal {

    //<editor-fold desc="Private fields">
    private String name;
    private String type;

    private boolean canSwim;
    private int maxSwimDistance;

    private boolean canRun;
    private int maxRunDistance;

    private boolean canFly;
    private int maxFlyDistance;
    //</editor-fold>

    private static int count;

    protected Animal(String name, boolean canRun, boolean canSwim, boolean canFly, int maxRunDistance, int maxSwimDistance, int maxFlyDistance) {
        this.name = name;
        this.canRun = canRun;
        this.canSwim = canSwim;
        this.canFly = canFly;

        if (maxRunDistance < 0) {
            System.out.println("maxRunDistance can't be < 0, set to 0");
            maxRunDistance = 0;
        }
        if (maxSwimDistance < 0) {
            System.out.println("maxRunDistance can't be < 0, set to 0");
            maxSwimDistance = 0;
        }
        if (maxFlyDistance < 0) {
            System.out.println("maxRunDistance can't be < 0, set to 0");
            maxFlyDistance = 0;
        }

        this.maxRunDistance = maxRunDistance;
        this.maxSwimDistance = maxSwimDistance;
        this.maxFlyDistance = maxFlyDistance;

        ++count;
    }

    protected void setType(String type) {
        this.type = type;
    }

    public final void Run(int distance) {
        Activity(canRun, distance, maxRunDistance, "run");
    }

    public final void Swim(int distance) {
        Activity(canSwim, distance, maxSwimDistance, "swim");
    }

    public final void Fly(int distance) {
        Activity(canFly, distance, maxFlyDistance, "fly");
    }

    public static void AnimalsCount() {
        System.out.println("You have " + count + " animals now");
    }

    private final void Activity(boolean isCan, int distance, int maxDistance, String methodName) {
        if (isCan) {
            if (distance < maxDistance) {
                System.out.println("Animal type " + type + " with name " + name + ' ' + methodName + ' ' + distance);
            } else {
                System.out.println("Animal type " + type + " with name " + name + " can " + methodName + " max distance " + maxDistance + ", but you want " + distance);
            }
        } else {
            System.out.println("Animal type " + type + " can't " + methodName + " on any distance");
        }
    }

    @Override
    public String toString() {
        return "Animal type " + type + " with name " + name;
    }
}
