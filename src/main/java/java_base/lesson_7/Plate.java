package java_base.lesson_7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public Plate() {
        this(0);
    }

    public void addFood(int food) {
        this.food += food;
    }

    public void info() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Plate{" +
                "food=" + food +
                '}';
    }

    public int getFood() {
        return food;
    }

    public void decreaseFood(int food) throws IllegalArgumentException {
        if (this.food - food < 0) {
            StringBuilder bld = new StringBuilder("Plate has ");
            bld.append(this.food);
            bld.append(" food, but you want to decrease food to ");
            bld.append(food);
            throw new IllegalArgumentException(bld.toString());
        }

        this.food -= food;
    }
}
