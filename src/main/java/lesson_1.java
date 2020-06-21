
public class lesson_1 {

    public static void main(String[] args) {
        System.out.println("Started here");

        // exercise 2
        byte b = 1;
        short s = 12000;
        int i = 140000;
        long l = 18000000L;
        float f = 14.88f;
        double d = 14.88;
        char c = 'c';
        boolean bl = true;

        // exercise 3
        System.out.println("third exercise:");
        System.out.println(exercise_3(1.05f, 10.28f, 7.3f, 2.1f));

        // exercise 4
        System.out.println("fourth exercise");
        System.out.println("10 + 4 is 14. Function returns " + exercise_4(10, 4));
        System.out.println("20 + 10 is 30. Function returns " + exercise_4(20, 10));

        // exercise 5
        System.out.println("fifth exercise");
        exercise_5(-5);
        exercise_5(10);

        // exercise 6
        System.out.println("sixth exercise");
        System.out.println("-5 < 0 is " + exercise_6(-5));
        System.out.println("5 < 0 is " + exercise_6(5));

        // exercise 7
        System.out.println("seventh exercise");
        System.out.println("Greetings for Alex");
        exercise_7("Alex");

        // exercise 8
        System.out.println("eighth exercise");
        exercise_8(2048);
        exercise_8(2020);
        exercise_8(2018);
    }

    private static float exercise_3(float a, float b, float c, float d) {
        if (d == 0) {
            return 0.f;
        }
        return a * (b + (c / d));
    }

    private static boolean exercise_4(int lhs, int rhs) {
        int sum = lhs + rhs;
        if (sum < 20 && sum > 10) {
            return true;
        }
        return false;
    }

    private static void exercise_5(int in) {
        if (in > 0) {
            System.out.println(in + " is greater than 0");
        } else {
            System.out.println(in + " is smaller than 0");
        }
    }

    private static boolean exercise_6(int in) {
        return in < 0;
    }

    private static void exercise_7(String name) {
        System.out.println("Hello, " + name + "!");
    }

    private static void exercise_8(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    System.out.println("Year " + year + " is leap");
                } else {
                    System.out.println("Year " + year + " is not leap");
                }
            } else {
                System.out.println("Year " + year + " is leap");
            }

        } else {
            System.out.println("Year " + year + " is not leap");
        }
    }
}
