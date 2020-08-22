package java_professional.lesson_1.Exercise_3;

import java.util.ArrayList;

public class Box <T extends Fruit> {
    private ArrayList<T> fruits = new ArrayList();

    public void add(T f) {
        fruits.add(f);
    }

    public double getWeight() {
        return fruits.size() == 0 ? 0 : fruits.get(0).getWeight() * fruits.size();
    }

    public boolean compare(Box another) {
        if (another == null) {
            throw new NullPointerException("Argument \"another\" is null");
        }
        return getWeight() == another.getWeight();
    }

    public void pour(Box<T> target) {
        if (target == null) {
            throw new NullPointerException("Argument \"target\" is null");
        }
        for (T fruit : fruits) {
            target.add(fruit);
        }
        fruits.clear();
    }
}
