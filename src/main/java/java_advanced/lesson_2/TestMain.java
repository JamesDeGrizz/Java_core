package java_advanced.lesson_2;

import java_advanced.lesson_2.Exceptions.*;

public class TestMain {
    private static String[][] wrongSizeMatrix;
    private static String[][] wrongDataMatrix;
    private static String[][] anotherWrongDataMatrix;
    private static String[][] theOnlyTrueMatrix;

    private static final int theOnlyTrueSize = 4;

    public static void main(String[] args) {
        initTestData();

        System.out.println("\n\nTesting wrongSizeMatrix");
        try {
            castAndSum(wrongSizeMatrix);
        } catch (MyArraySizeException e) {
            System.out.println("Get MyArraySizeException with message:\n\t" + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("We should not get there");
        } catch (Exception e) {
            System.out.println("Unknown exception " + e.getMessage());
        }

        System.out.println("\n\nTesting wrongDataMatrix");
        try {
            castAndSum(wrongDataMatrix);
        } catch (MyArraySizeException e) {
            System.out.println("We should not get there");
        } catch (MyArrayDataException e) {
            System.out.println("Get MyArrayDataException with message:\n\t" + e.getMessage());
            e.printCoordinatesOfWrongItem();
        } catch (Exception e) {
            System.out.println("Unknown exception " + e.getMessage());
        }

        System.out.println("\n\nTesting anotherWrongDataMatrix");
        try {
            castAndSum(anotherWrongDataMatrix);
        } catch (MyArraySizeException e) {
            System.out.println("We should not get there");
        } catch (MyArrayDataException e) {
            System.out.println("Get MyArrayDataException with message:\n\t" + e.getMessage());
            e.printCoordinatesOfWrongItem();
        } catch (Exception e) {
            System.out.println("Unknown exception " + e.getMessage());
        }

        System.out.println("\n\nTesting theOnlyTrueMatrix");
        try {
            castAndSum(theOnlyTrueMatrix);
        } catch (MyArraySizeException e) {
            System.out.println("We should not get there");
        } catch (MyArrayDataException e) {
            System.out.println("We should not get there");
        } catch (Exception e) {
            System.out.println("Unknown exception " + e.getMessage());
        }
    }

    private static int castAndSum(String[][] matrix) throws MyArraySizeException, MyArrayDataException {
        if (matrix.length != theOnlyTrueSize || matrix[0].length != theOnlyTrueSize) {
            throw new MyArraySizeException("the only true size must be " + theOnlyTrueSize);
        }
        for (int i = 0; i < theOnlyTrueSize; ++i) {
            if (matrix[i].length != theOnlyTrueSize) {
                throw new MyArraySizeException("the only true size must be " + theOnlyTrueSize);
            }
        }

        int sum = 0;
        for (int i = 0; i < theOnlyTrueSize; ++i) {
            for (int j = 0; j < theOnlyTrueSize; ++j) {
                int parsed;
                try {
                    parsed = Integer.parseInt(matrix[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Can't parse to int value " + matrix[i][j], i, j);
                }

                sum += parsed;
            }
        }

        System.out.println("Sum of given matrix is " + sum);
        return sum;
    }

    private static void initTestData() {
        wrongSizeMatrix = new String[theOnlyTrueSize + 1][theOnlyTrueSize + 2];
        wrongDataMatrix = new String[theOnlyTrueSize][theOnlyTrueSize];
        anotherWrongDataMatrix = new String[theOnlyTrueSize][theOnlyTrueSize];
        theOnlyTrueMatrix = new String[theOnlyTrueSize][theOnlyTrueSize];

        for (int i = 0; i < theOnlyTrueSize; ++i) {
            for (int j = 0; j < theOnlyTrueSize; ++j) {
                wrongDataMatrix[i][j] = String.valueOf(i + j);
                anotherWrongDataMatrix[i][j] = String.valueOf(i + j);
                theOnlyTrueMatrix[i][j] = String.valueOf(i + j);
            }
        }

        wrongDataMatrix[2][2] = "abir";
        anotherWrongDataMatrix[3][3] = "12three4";
    }
}
