package java_advanced.lesson_5;

import java.util.Arrays;

public class TestMain {
    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;
    static float[] arr = new float[SIZE];

    private static void testMethod() {
        Arrays.fill(arr, 1.f);
        long started = System.currentTimeMillis();
        for (int i = 0; i < SIZE; ++i) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println(System.currentTimeMillis() - started);
    }

    private static void testMethodAsync() {
        Arrays.fill(arr, 1.f);
        long started = System.currentTimeMillis();

        float[] firstHalf = new float[HALF];
        float[] secondHalf = new float[HALF];

        System.arraycopy(arr, 0, firstHalf, 0, HALF);
        System.arraycopy(arr, HALF, secondHalf, 0, HALF);

        Thread t1 = new Thread(() -> calc(firstHalf));
        Thread t2 = new Thread(() -> calc(secondHalf));

        t1.start();
        t2.start();

        while (t1.isAlive() || t2.isAlive());

        System.arraycopy(firstHalf, 0, arr, 0, HALF);
        System.arraycopy(secondHalf, 0, arr, HALF, HALF);

        System.out.println(System.currentTimeMillis() - started);
    }

    private static void calc(float[] arr) {
        for (int i = 0; i < HALF; ++i) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

    public static void main(String[] args) {
        testMethod();
        testMethodAsync();
    }
}
