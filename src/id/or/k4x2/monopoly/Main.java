package id.or.k4x2.monopoly;

import id.or.k4x2.monopoly.model.Tiles;
import id.or.k4x2.monopoly.ui.BoardWindow;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Tiles.init();
        JFrame frame = new JFrame("BoardWindow");
        frame.setContentPane(new BoardWindow().createPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(900, 700);
    }
}
