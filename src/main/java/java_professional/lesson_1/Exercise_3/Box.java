package java_professional.lesson_1.Exercise_3;

import java.util.ArrayList;

public class Box <T extends Fruit> {
    private ArrayList<T> fruits = new ArrayList();

    public void add(T f) {
        fruits.add(f);
    }

    public double getWeight() {
        throw new UnsupportedOperationException();
    }

    public boolean compare(Box another) {
        if (another == null) {
            throw new NullPointerException("Argument \"another\" is null");
        }
        return getWeight() == another.getWeight();
    }

    public void pour(Box<?> target) {
        throw new UnsupportedOperationException();
    }
}
