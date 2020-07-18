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
        try {
            StringBuilder bld = new StringBuilder("Cat ");
            bld.append(this.name);
            bld.append(" try to eat ");
            bld.append(this.appetite);
            bld.append(" food");
            System.out.println(bld.toString());
            doEat(plate);
            satiety = true;
        }
        catch (IllegalArgumentException e) {
            StringBuilder bld = new StringBuilder("Cat ");
            bld.append(this.name);
            bld.append(" get this exception:\n ");
            bld.append(e.getMessage());
            System.out.println(bld.toString());
        }
    }

    private void doEat(Plate plate) {
        plate.decreaseFood(appetite);
    }
}
