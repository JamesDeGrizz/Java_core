package java_base.lesson_7;

public class Cat {
    protected final String name;
    private int appetite;
    private boolean satiety;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public String getName() {
        return name;
    }

    public int getAppetite() {
        return appetite;
    }

    public void eat (Plate plate) {
        if (plate.getFood() >= appetite) {
            satiety = true;
            doEat(plate);
        }
        else {

        }
    }

    public void doEat(Plate plate) {
        plate.decreaseFood(appetite);
    }
}
