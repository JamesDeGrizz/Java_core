package java_core;

import java.util.Random;
import java.util.Scanner;

public class lesson_4 {

    public static int SIZE = 5;
    public static int DOTS_TO_WIN = 4;
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static char[][] map;
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();
    private static boolean lastTurn = false;

    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkEnd(DOT_X)) {
                break;
            }

            aiTurn();
            printMap();
            if (checkEnd(DOT_O)) {
                break;
            }
        }
        System.out.println("Игра закончена");
    }

    public static boolean checkEnd(char symb) {
        if (checkWin(symb)) {
            System.out.println("Победил " + ((symb == DOT_X) ? "человек" : "искусственный интеллект"));
            return true;
        }
        if (isMapFull()) {
            System.out.println("Ничья");
            return true;
        }
        return false;
    }

    public static boolean checkWin(char symb) {
        return checkDiagonals(symb) || checkColsAndRows(symb);
    }

    private static boolean checkDiagonals(char symb) {
        int mainDiagonalCount = 0;
        int secondaryDiagonalCount = 0;
        for (int i = 0; i < SIZE; ++i) {
            mainDiagonalCount = (map[i][i] == symb) ? (mainDiagonalCount + 1) : 0;
            secondaryDiagonalCount = (map[i][SIZE - i - 1] == symb) ? (secondaryDiagonalCount + 1) : 0;
            if (mainDiagonalCount == DOTS_TO_WIN || secondaryDiagonalCount == DOTS_TO_WIN) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkColsAndRows(char symb) {
        for (int i = 0; i < SIZE; ++i) {
            int inRowSequence = 0;
            int inColSequence = 0;
            for (int j = 0; j < SIZE; ++j) {
                inRowSequence = (map[i][j] == symb) ? (inRowSequence + 1) : 0;
                inColSequence = (map[j][i] == symb) ? (inColSequence + 1) : 0;
                if (inRowSequence == DOTS_TO_WIN || inColSequence == DOTS_TO_WIN) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void aiTurn() {
        int x, y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));
        System.out.println("Компьютер пошел в точку " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_O;
        lastTurn = !lastTurn;
    }

    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[y][x] = DOT_X;
        lastTurn = !lastTurn;
    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        if (map[y][x] == DOT_EMPTY) return true;
        return false;
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        if (lastTurn) {
            System.out.println("Поле после хода игрока:");
        } else {
            System.out.println("Поле после хода ИИ:");
        }
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
