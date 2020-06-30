package java_core;

/*
Стандартная задача с собеседований: при помощи метода drawSpiral(int height, int weight) и двумерного массива нарисовать спиральную матрицу:
01 12 11 10
02 13 16 09
03 14 15 08
04 05 06 07
Принцип заполнения: вниз -> вправо -> вверх -> влево
Учтите, что столбцов и строк может быть минимум 1. А если числа разных разрядов, то еще нужно подумать о форматировании (подсказка: printf() поможет)
* */

import java.util.Scanner;

public class lesson_3_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter width: ");
        int width = sc.nextInt();
        System.out.print("Enter heigth: ");
        int heigth = sc.nextInt();

        PrintSpiral(width, heigth);
    }

    private static void PrintSpiral(int width, int heigth) {
        int[][] matrix = new int[heigth][width];
        int value = 0;

        int top = 0;
        int left = 0;

        int bottom = heigth - 1;
        int right = width - 1;

        while (value < (width * heigth)){
            for (int i = top; i <= bottom; i++) {
                matrix[i][left] = ++value;
            }
            ++left;
            if (left > right) {
                break;
            }

            for (int j = left; j <= right; j++) {
                matrix[bottom][j] = ++value;
            }
            --bottom;
            if (bottom < top) {
                break;
            }

            for (int i = bottom; i >= top; i--) {
                matrix[i][right] = ++value;
            }
            --right;
            if (left > right) {
                break;
            }

            for (int j = right; j >= left; j--) {
                matrix[top][j] = ++value;
            }
            ++top;
            if (bottom < top) {
                break;
            }
        }

        System.out.println("\nResult matrix:");
        int counter = 0;
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.printf("%4d", val);
            }
            System.out.println();
        }
    }
}
