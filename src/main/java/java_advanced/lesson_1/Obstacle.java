package java_advanced.lesson_1;

public abstract class Obstacle {
    private int size;
    protected String type;

    public Obstacle(int newSize, String type) throws IllegalArgumentException {
        if (newSize < 0) {
            throw new IllegalArgumentException(type + " size can't be < 0");
        }
        this.type = type;
        size = newSize;
    }

    public int getSize() {
        return size;
    }
}
