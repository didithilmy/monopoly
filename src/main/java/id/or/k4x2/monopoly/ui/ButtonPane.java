package id.or.k4x2.monopoly.ui;

import id.or.k4x2.monopoly.entity.Dice;
import id.or.k4x2.monopoly.entity.Player;
import id.or.k4x2.monopoly.listeners.ContextListener;
import id.or.k4x2.monopoly.listeners.Listeners;
import id.or.k4x2.monopoly.model.Context;
import id.or.k4x2.monopoly.model.GameManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonPane implements ContextListener {
    private JPanel panel;
    private JButton rollDiceButton;
    private JButton endTurnButton;
    private JLabel die1;
    private JLabel die2;
    private JButton viewLogButton;

    public JPanel getPanel() {
        Listeners.addContextListener(this);

        endTurnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // End turn
                Context.getInstance().endTurn();

                // Disable button
                endTurnButton.setEnabled(false);
            }
        });

        rollDiceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Context.getInstance().rollDice();

                rollDiceButton.setEnabled(false);
            }
        });

        viewLogButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showLogWindow();
            }
        });

        return panel;
    }

    public JButton getRollDiceButton() {
        return rollDiceButton;
    }

    public JButton getEndTurnButton() {
        return endTurnButton;
    }


    /**
     * On begin turn
     * @param oldPlayer Player entity
     * @param player Player entity
     */
    public void onBeginTurn(Player oldPlayer, Player player) {
        endTurnButton.setEnabled(false);
        rollDiceButton.setEnabled(true);
    }

    /**
     * On turn ended
     * @param player Player entity
     */
    public void onTurnEnded(Player player) {
        endTurnButton.setEnabled(false);
    }

    /**
     * On winner declared
     * @param player Player entity
     */
    public void onWinnerDeclared(Player player) {
        //nothing
    }

    /**
     * On dice rolled
     * @param player Player entity
     */
    public void onDiceRolled(Player player) {
        rollDiceButton.setEnabled(false);
        endTurnButton.setEnabled(true);

        // Update UI
        Dice dice = Context.getInstance().getDice();

        die1.setText(String.valueOf(dice.getDie1()));
        die2.setText(String.valueOf(dice.getDie2()));
    }

    /**
     * Show log window
     */
    private void showLogWindow() {
        LogWindow window = new LogWindow(GameManager.getInstance().getPlayerLog());
        window.show();
    }
}
