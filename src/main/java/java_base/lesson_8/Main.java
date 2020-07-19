package java_base.lesson_8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class MainWindow extends JFrame {
    private Map map;
    private int mapSize = 5;


    public MainWindow() {
        setBounds(500, 500, 400, 300);
        setTitle("Tic-Tac-Toe");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        map = new Map(mapSize);

        setLayout(new GridLayout(mapSize, mapSize));

        for (int x = 0; x < mapSize; x++) {
            for (int y = 0; y < mapSize; y++) {
                add(map.getMap()[x][y].getItem());
            }
        }

//        JPanel pan = new JPanel();
//        add(pan);
//        pan.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseReleased(MouseEvent e) {
//                System.out.println("MousePos: " + e.getX() + " " + e.getY());
//            }
//        });
        setVisible(true);

    }
}

public class Main {
    public static void main(String[] args) {
        MainWindow w = new MainWindow();
    }
}
