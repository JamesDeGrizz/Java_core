package java_base.lesson_8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Scanner;

class Window extends JFrame {
    private Container pane;
    private JButton[][] map;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem newGame;
    private JMenuItem quit;

    private final int SIZE = 5;
    private final int DOTS_TO_WIN = 4;

    private final String DOT_EMPTY = "•";
    private final String DOT_X = "X";
    private final String DOT_O = "O";
    private boolean hasWinner = false;

    private Random rand = new Random();

    public Window() {
        super();
        setTitle("Tic Tac Toe");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        pane = getContentPane();
        pane.setLayout(new GridLayout(SIZE, SIZE));

        initMenu();
        initMap();
        resetMap();
        setVisible(true);
    }

    private void initMenu() {
        menuBar = new JMenuBar();
        menu = new JMenu("Menu");
        newGame = new JMenuItem("New game");
        newGame.addActionListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                      resetMap();
                  }
              }
        );
        quit = new JMenuItem("Quit");
        quit.addActionListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                      System.exit(0);
                  }
              }
        );
        menu.add(newGame);
        menu.add(quit);
        menuBar.add(menu);
        setJMenuBar(menuBar);
    }

    private boolean checkEnd(String symb) {
        if (checkWin(symb)) {
            JOptionPane.showMessageDialog(null, "Winner is " + ((symb == DOT_X) ? "human" : "AI"));
            return true;
        }
        if (isMapFull()) {
            JOptionPane.showMessageDialog(null, "Draw");
            return true;
        }
        return false;
    }

    private boolean checkWin(String s) {
        return checkDiagonals(s) || checkColsAndRows(s);
    }

    private boolean checkDiagonals(String symb) {
        int mainDiagonalCount = 0;
        int secondaryDiagonalCount = 0;
        for (int i = 0; i < SIZE; ++i) {
            mainDiagonalCount = (map[i][i].getText().equals(symb)) ? (mainDiagonalCount + 1) : 0;
            secondaryDiagonalCount = (map[i][SIZE - i - 1].getText().equals(symb)) ? (secondaryDiagonalCount + 1) : 0;
            if (mainDiagonalCount == DOTS_TO_WIN || secondaryDiagonalCount == DOTS_TO_WIN) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColsAndRows(String symb) {
        for (int i = 0; i < SIZE; ++i) {
            int inRowSequence = 0;
            int inColSequence = 0;
            for (int j = 0; j < SIZE; ++j) {
                inRowSequence = (map[i][j].getText().equals(symb)) ? (inRowSequence + 1) : 0;
                inColSequence = (map[j][i].getText().equals(symb)) ? (inColSequence + 1) : 0;
                if (inRowSequence == DOTS_TO_WIN || inColSequence == DOTS_TO_WIN) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j].getText().equals(DOT_EMPTY)) {
                    return false;
                }
            }
        }
        return true;
    }

    private void aiTurn() {
        int x, y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));
        map[y][x].setText(DOT_O);
    }

    private boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
            return false;
        }
        if (map[y][x].getText().equals(DOT_EMPTY)) {
            return true;
        }
        return false;
    }

    private void initMap() {
        map = new JButton[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                JButton btn = new JButton();
                map[i][j] = btn;
                btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (!((JButton) e.getSource()).getText().equals(DOT_EMPTY) || hasWinner == true) {
                            return;
                        }
                        if (((JButton) e.getSource()).getText().equals(DOT_EMPTY) && hasWinner == false) {
                            btn.setText(DOT_X);
                        }
                        hasWinner = checkEnd(DOT_X);
                        if (hasWinner) {
                            return;
                        }
                        aiTurn();
                        hasWinner = checkEnd(DOT_O);
                    }
                });
                btn.setText(DOT_EMPTY);
                pane.add(btn);
            }
        }
    }

    private void resetMap() {
        hasWinner = false;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j].setText(DOT_EMPTY);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Window w = new Window();
    }
}
