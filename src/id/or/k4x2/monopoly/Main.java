package id.or.k4x2.monopoly;

import id.or.k4x2.monopoly.entity.Player;
import id.or.k4x2.monopoly.listeners.ContextListener;
import id.or.k4x2.monopoly.listeners.Listeners;
import id.or.k4x2.monopoly.model.Context;
import id.or.k4x2.monopoly.model.GameManager;
import id.or.k4x2.monopoly.model.Tiles;
import id.or.k4x2.monopoly.ui.BoardWindow;
import id.or.k4x2.monopoly.ui.ButtonPane;
import id.or.k4x2.monopoly.ui.GameWindow;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Tiles.init();
        JFrame frame = new JFrame("Engi's Monopoly");

        GameWindow gameWindow = new GameWindow();
        gameWindow.getBoardPane().add(new BoardWindow().getPanelMain());
        gameWindow.getDicePane().add(new ButtonPane().getPanel());

        frame.setContentPane(gameWindow.getPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(900, 700);

        System.out.println("Check thread");
        List<Player> players = new ArrayList<>();
        players.add(new Player("Player 1", Player.Designation.PLAYER_A));
        players.add(new Player("Player 2", Player.Designation.PLAYER_B));
        players.add(new Player("Player 3", Player.Designation.PLAYER_C));
        //players.add(new Player("Player 4", Player.Designation.PLAYER_D));

        GameManager.getInstance().start(players);
        Context.getInstance().start();

        Listeners.addContextListener(new ContextListener() {
            @Override
            public void onBeginTurn(Player previousPlayer, Player player) {
                // No-op
            }

            @Override
            public void onTurnEnded(Player player) {
                // No-op
            }

            @Override
            public void onWinnerDeclared(Player player) {
                JOptionPane.showMessageDialog(frame,
                        "Selamat kepada " + player.getName() + " karena memenangkan permainan ini!", "Pememang", JOptionPane.INFORMATION_MESSAGE);
            }

            @Override
            public void onDiceRolled(Player player) {
                // No-op
            }
        });
    }
}
