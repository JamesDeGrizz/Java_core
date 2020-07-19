package java_base.lesson_8;

public class Map {
    private int size;
    private FieldItem[][] map;

    public Map(int size) {
        this.size = size;
        initMap();
    }

    private void initMap() {
        map = new FieldItem[size][size];
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                map[x][y] = new EmptyField();
            }
        }
    }

    public void setField(int x, int y, FieldItem item) throws IllegalArgumentException {
        if (x < 0 || x > size) {
            throw new IllegalArgumentException("illegal x");
        }
        if (y < 0 || y > size) {
            throw new IllegalArgumentException("illegal y");
        }

        map[x][y] = item;
    }

    public FieldItem[][] getMap() {
        return map;
    }
}
