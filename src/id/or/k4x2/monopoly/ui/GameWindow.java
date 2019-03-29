package id.or.k4x2.monopoly.ui;

import id.or.k4x2.monopoly.entity.Player;
import id.or.k4x2.monopoly.listeners.GameStateListener;
import id.or.k4x2.monopoly.listeners.Listeners;
import id.or.k4x2.monopoly.model.GameManager;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;

public class GameWindow implements GameStateListener {
    private JPanel panel;
    private JPanel playerPane;
    private JPanel boardPane;
    private JPanel dicePane;

    public GameWindow() {
        super();
        Listeners.addGameStateListener(this);

        GridLayout layout = new GridLayout(6, 1);
        layout.setVgap(8);
        playerPane.setLayout(layout);
        playerPane.setBorder(new EmptyBorder(8, 8, 8, 8));
    }

    public JPanel getPanel() {
        return panel;
    }

    public JPanel getPlayerPane() {
        return playerPane;
    }

    public JPanel getBoardPane() {
        return boardPane;
    }

    public JPanel getDicePane() {
        return dicePane;
    }

    public void onGameStart() {
        // Add Player panes
        List<Player> players = GameManager.getInstance().getPlayers();
        for(Player player : players) {
            PlayerDetailPane playerDetailPane = new PlayerDetailPane();
            playerDetailPane.getPlayerName().setText(player.getName());
            playerDetailPane.getPlayerMoney().setText("Rp " + player.getMoney());

            Player.Designation designation = player.getDesignation();
            playerDetailPane.getPaneColor().setBackground(new Color(designation.getColR(), designation.getColG(), designation.getColB()));

            playerPane.add(playerDetailPane.getPanel());
        }
    }

    public void onGameFinished() {

    }
}
