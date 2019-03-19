package id.or.k4x2.monopoly;

import id.or.k4x2.monopoly.ui.BoardWindow;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("BoardWindow");
        frame.setContentPane(new BoardWindow().getPanelMain());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(900, 700);
    }
}
