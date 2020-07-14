package java_core.lesson_6;

public abstract class Animal {

    //<editor-fold desc="Private fields">
    private String name;
    private String type;

    private boolean canSwim;
    private int maxSwimDistance;
    private int minSwimDistance;
    private int userSetSwimDistance;

    private boolean canRun;
    private int maxRunDistance;
    private int minRunDistance;
    private int userSetRunDistance;

    private boolean canFly;
    private int maxFlyDistance;
    private int minFlyDistance;
    private int userSetFlyDistance;
    //</editor-fold>

    private static int count;

    protected Animal(String name, boolean canRun, boolean canSwim, boolean canFly) {
        this.name = name;
        this.canRun = canRun;
        this.canSwim = canSwim;
        this.canFly = canFly;
        ++count;
    }

    //<editor-fold desc="Getters&Setters">
    protected String getType() {
        return type;
    }

    protected void setType(String type) {
        this.type = type;
    }

    protected int getMinSwimDistance() {
        return minSwimDistance;
    }

    protected void setMinSwimDistance(int minSwimDistance) {
        this.minSwimDistance = minSwimDistance;
    }

    protected int getUserSetSwimDistance() {
        return userSetSwimDistance;
    }

    protected void setUserSetSwimDistance(int userSetSwimDistance) {
        this.userSetSwimDistance = userSetSwimDistance;
    }

    protected int getMinRunDistance() {
        return minRunDistance;
    }

    protected void setMinRunDistance(int minRunDistance) {
        this.minRunDistance = minRunDistance;
    }

    protected int getUserSetRunDistance() {
        return userSetRunDistance;
    }

    protected void setUserSetRunDistance(int userSetRunDistance) {
        this.userSetRunDistance = userSetRunDistance;
    }

    protected int getMinFlyDistance() {
        return minFlyDistance;
    }

    protected void setMinFlyDistance(int minFlyDistance) {
        this.minFlyDistance = minFlyDistance;
    }

    protected int getUserSetFlyDistance() {
        return userSetFlyDistance;
    }

    protected void setUserSetFlyDistance(int userSetFlyDistance) {
        this.userSetFlyDistance = userSetFlyDistance;
    }

    protected int getMaxSwimDistance() {
        return maxSwimDistance;
    }

    protected void setMaxSwimDistance(int maxSwimDistance) {
        this.maxSwimDistance = maxSwimDistance;
    }

    protected int getMaxRunDistance() {
        return maxRunDistance;
    }

    protected void setMaxRunDistance(int maxRunDistance) {
        this.maxRunDistance = maxRunDistance;
    }

    protected int getMaxFlyDistance() {
        return maxFlyDistance;
    }

    protected void setMaxFlyDistance(int maxFlyDistance) {
        this.maxFlyDistance = maxFlyDistance;
    }
    //</editor-fold>

    public final void Run(int distance) {
        if (canRun) {
            if (distance < maxRunDistance) {
                System.out.println("Animal type " + type + " with name " + name + " ran " + distance);
            } else {
                System.out.println("Animal type " + type + " can run max distance " + maxRunDistance + ", but you want " + distance);
            }
        } else {
            System.out.println("Animal type " + type + " can't run");
        }
    }

    public final void Swim(int distance) {
        if (canSwim) {
            if (distance < maxSwimDistance) {
                System.out.println("Animal type " + type + " with name " + name + " swam " + distance);
            } else {
                System.out.println("Animal type " + type + " can swim max distance " + maxSwimDistance + ", but you want " + distance);
            }
        } else {
            System.out.println("Animal type " + type + " can't swim");
        }
    }

    public final void Fly(int distance) {
        if (canFly) {
            if (distance < maxFlyDistance) {
                System.out.println("Animal type " + type + " with name " + name + " flew " + distance);
            } else {
                System.out.println("Animal type " + type + " can fly max distance " + maxSwimDistance + ", but you want " + distance);
            }
        } else {
            System.out.println("Animal type " + type + " can't fly");
        }
    }

    public static void AnimalsCount() {
        System.out.println("You have " + count + " animals now");
    }
}
