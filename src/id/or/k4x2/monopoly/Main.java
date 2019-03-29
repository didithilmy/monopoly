package id.or.k4x2.monopoly;

import id.or.k4x2.monopoly.entity.Player;
import id.or.k4x2.monopoly.model.Context;
import id.or.k4x2.monopoly.model.GameManager;
import id.or.k4x2.monopoly.model.Tiles;
import id.or.k4x2.monopoly.ui.BoardWindow;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Tiles.init();
        JFrame frame = new JFrame("BoardWindow");
        frame.setContentPane(new BoardWindow().createPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(900, 700);

        System.out.println("Check thread");
        List<Player> players = new ArrayList<>();
        players.add(new Player("Player 1", Player.Designation.PLAYER_A));
        players.add(new Player("Player 2", Player.Designation.PLAYER_B));
        players.add(new Player("Player 3", Player.Designation.PLAYER_C));
        players.add(new Player("Player 4", Player.Designation.PLAYER_D));

        GameManager.getInstance().start(players);
        Context.getInstance().start();
        Context.getInstance().rollDice();
    }
}
