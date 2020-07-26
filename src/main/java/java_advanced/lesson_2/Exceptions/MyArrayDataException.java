package java_advanced.lesson_2.Exceptions;

public class MyArrayDataException extends NumberFormatException {
    private int xValue;
    private int yValue;

    public MyArrayDataException(String message, int xCoord, int yCoord) {
        super(message);
        xValue = xCoord;
        yValue = yCoord;
    }

    public void printCoordinatesOfWrongItem() {
        StringBuilder sb = new StringBuilder();
        sb.append("Wrong value in [");
        sb.append(xValue);
        sb.append(", ");
        sb.append(yValue);
        sb.append("] element");
        System.out.println(sb.toString());
    }
}
