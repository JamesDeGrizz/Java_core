package java_core;

public class lesson_2 {

    public static void main(String[] args) {
        int[] testArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] testArr2 = {-11, -2, -3, -4, 5, 6, 7, 8, 9, 10};
        int[] testArr3 = {11, 22, 33, 44, 55, 56, 47, 38, 29, 110};
        int[] testArr4 = {11, 22, 33, 0};

        // exercise 1
        System.out.println("\n\nExercise 1");
        int[] testArrEx1 = {1, 1, 0, 0, 1, 0, 1, 0, 1, 1};
        int[] testArrEx1_1 = {1, 1, 1, 1, 0, 0, 0, 0, 1, 0};
        exercise_1(testArrEx1);
        exercise_1(testArrEx1_1);

        // exercise 2
        System.out.println("\n\nExercise 2");
        exercise_2();

        // exercise 3
        System.out.println("\n\nExercise 3");
        exercise_3();

        // exercise 4
        System.out.println("\n\nExercise 4");
        exercise_4(3);
        exercise_4(8);

        // exercise 5
        System.out.println("\n\nExercise 5");
        exercise_5(testArr);
        exercise_5(testArr2);
        exercise_5(testArr3);

        // exercise 6
        System.out.println("\n\nExercise 6");
        exercise_6(testArr);
        exercise_6(testArr2);
        exercise_6(testArr4);

        // exercise 7
        System.out.println("\n\nExercise 7");
        exercise_7(testArr, 3);

        for (int c : testArr) {
            System.out.print(c + ", ");
        }
    }

    public static void exercise_1(int[] arr_in) {
        System.out.print("Given array [");
        String resultMessage = "Result array [";

        for (int i = 0; i < arr_in.length; ++i) {
            System.out.print(arr_in[i]);

            if (arr_in[i] == 0) {
                arr_in[i] = 1;
            } else {
                arr_in[i] = 0;
            }

            resultMessage += arr_in[i];

            if (i != arr_in.length - 1) {
                System.out.print(", ");
                resultMessage += ", ";
            }
        }
        System.out.print("]\n");
        resultMessage += "]\n";
        System.out.println(resultMessage);
    }

    public static void exercise_2() {
        int[] arr = new int[8];

        for (int i = 0, j = 0; j < arr.length; i += 3, ++j) {
            arr[j] = i;
        }

        PrintArray(arr);
    }

    public static void exercise_3() {
        System.out.println("Given array [1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1]");
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
        }

        PrintArray(arr);
    }

    public static void exercise_4(int size_in) {
        int[][] arr = new int[size_in][size_in];

        for (int i = 0; i < size_in; ++i) {
            int j = size_in - i - 1;
            arr[i][i] = 1;
            arr[i][j] = 1;
        }

        System.out.println("Result matrix " + size_in + "x" + size_in + "size: ");
        for (int i = 0; i < size_in; ++i) {
            System.out.print("[");
            for (int j = 0; j < size_in; ++j) {
                System.out.print(arr[i][j]);
                if (j != size_in - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    }

    public static void exercise_5(int[] arr_in) {
        System.out.print("Searching maximum in array [");
        int min = arr_in[0];
        int max = arr_in[0];

        for (int current : arr_in) {
            System.out.print(current);
            if (current != arr_in[arr_in.length - 1]) {
                System.out.print(", ");
            }
            if (min > current) {
                min = current;
            }
            if (max < current) {
                max = current;
            }
        }

        System.out.print("]\n");
        System.out.println("Minimum is " + min);
        System.out.println("Maximum is " + max);
    }

    public static boolean exercise_6(int[] arr_in) {
        System.out.print("Searching if an array balanced in array [");
        int sum = 0, sum_of_previous = 0;
        boolean result = false;
        for (int current : arr_in) {
            sum += current;
            System.out.print(current);
            if (current != arr_in[arr_in.length - 1]) {
                System.out.print(", ");
            }
        }
        System.out.println(']');

        for (int i = 0; i < arr_in.length; ++i) {
            sum -= arr_in[i];
            sum_of_previous += arr_in[i];

            if (sum == sum_of_previous) {
                result = true;
                break;
            }
        }

        System.out.print("Array is ");
        if (result) {
            System.out.println("balanced");
        } else {
            System.out.println("not balanced");
        }

        return result;
    }

    public static void exercise_7(int[] arr_in, int shift) {
        for (int j = 0; j < shift; j++) {
            int tmp = arr_in[0];
            int i;
            if (shift > 0) {
                for (i = 0; i < arr_in.length - 1; i++) {
                    arr_in[i] = arr_in[i + 1];
                }
            } else {
                for (i = arr_in.length - 1; i > 0; i--) {
                    arr_in[i] = arr_in[i - 1];
                }
            }

            arr_in[i] = tmp;
        }
    }

    private static void PrintArray(int[] arr) {
        System.out.print("Result array [");
        for (int i = 0; i < arr.length; ++i) {
            System.out.print(arr[i]);
            if (i != arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]\n");
    }
}
