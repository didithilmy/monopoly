package id.or.k4x2.monopoly.ui;

import id.or.k4x2.monopoly.entity.Player;
import id.or.k4x2.monopoly.listeners.GameStateListener;
import id.or.k4x2.monopoly.listeners.Listeners;
import id.or.k4x2.monopoly.listeners.PlayerAttributesListener;
import id.or.k4x2.monopoly.model.GameManager;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameWindow implements GameStateListener, PlayerAttributesListener {
    private JPanel panel;
    private JPanel playerPane;
    private JPanel boardPane;
    private JPanel dicePane;

    private Map<Player.Designation, PlayerDetailPane> windowMap;

    public GameWindow() {
        super();
        Listeners.addGameStateListener(this);
        Listeners.addPlayerAttributesListener(this);

        windowMap = new HashMap<>();

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
            windowMap.put(player.getDesignation(), playerDetailPane);
        }
    }

    public void onGameFinished() {

    }

    /**
     * On money updated
     * @param player Player entity
     * @param oldNominal old nominal
     * @param newNominal new nominal
     */
    public void moneyUpdated(Player player, int oldNominal, int newNominal) {
        PlayerDetailPane pane = windowMap.get(player.getDesignation());
        if(pane != null) {
            pane.getPlayerMoney().setText("Rp " + newNominal);
        }
    }

    /**
     * On player bankrupted
     * @param player Player entity
     */
    public void onPlayerBankrupted(Player player) {

    }
}
