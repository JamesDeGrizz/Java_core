package java_professional.lesson_1.Exercise_1_2;

import java.util.ArrayList;
import java.util.Collections;

class TestClass {
    public int index;

    public TestClass(int num) {
        index = num;
    }
}

public class TestMain {
    private static final int arraysSize = 10;

    public static void main(String[] args) {
        TestClass[] testArray = new TestClass[arraysSize];

        for (int i = 0; i < arraysSize; ++i) {
            testArray[i] = new TestClass(i);
        }

        System.out.println("Exercise 1");
        print(testArray);
        change(testArray, 1, 8);
        change(testArray, 4, 6);
        print(testArray);

        System.out.println("\n\nExercise 2");
        ArrayList<TestClass> result = toArrayList(testArray);
        System.out.print("[ ");
        for (TestClass tc : result) {
            System.out.print(tc.index + ", ");
        }
        System.out.println(" ]");
    }

    private static <T> void change(T[] array, int indexFirst, int indexSecond) {
        if (array == null) {
            throw new NullPointerException("Argument named \"array\" is null");
        }
        int arrayLength = array.length;
        if (arrayLength < indexFirst || arrayLength < indexSecond) {
            StringBuilder sb = new StringBuilder();
            sb.append("Array length ")
                .append(arrayLength)
                .append(", but get indexes ")
                .append(indexFirst)
                .append(" and ")
                .append(indexSecond);
            throw new IndexOutOfBoundsException(sb.toString());
        }
        T first = array[indexFirst];
        array[indexFirst] = array[indexSecond];
        array[indexSecond] = first;
    }

    private static <T> ArrayList<T> toArrayList(T[] array) {
        if (array == null) {
            throw new NullPointerException("Argument named \"array\" is null");
        }
        ArrayList<T> list = new ArrayList();
        Collections.addAll(list, array);
        return list;
    }

    private static void print(TestClass[] array) {
        System.out.print("[ ");
        for (TestClass tc : array) {
            System.out.print(tc.index + ", ");
        }
        System.out.println(" ]");
    }
}