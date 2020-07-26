package java_advanced.lesson_2.Exceptions;

public class MyArraySizeException extends IllegalArgumentException {
    public MyArraySizeException(String message) {
        super(message);
    }
}
