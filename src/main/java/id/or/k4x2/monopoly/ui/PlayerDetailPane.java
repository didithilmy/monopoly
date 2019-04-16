package id.or.k4x2.monopoly.ui;

import id.or.k4x2.monopoly.entity.Player;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PlayerDetailPane {
    private JPanel panel;
    private JPanel paneColor;
    private JLabel playerName;
    private JLabel playerMoney;
    private JPanel panelLeft;
    private static Border MARGIN = new EmptyBorder(8, 8, 8, 8);
    private static Border NORMAL_BORDER = new CompoundBorder(BorderFactory.createLineBorder(Color.GRAY, 1), MARGIN);
    private static Border ACTIVE_BORDER = new CompoundBorder(BorderFactory.createLineBorder(Color.BLUE, 3), MARGIN);

    public PlayerDetailPane(Player player) {
        super();
        panel.setBorder(NORMAL_BORDER);
        panelLeft.setOpaque(false);

        panel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new PlayerDetailsWindow(player).show();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    public JPanel getPanel() {
        return panel;
    }

    public JPanel getPaneColor() {
        return paneColor;
    }

    public JLabel getPlayerName() {
        return playerName;
    }

    public JLabel getPlayerMoney() {
        return playerMoney;
    }

    public void setPlayerTurn(boolean isTurn) {
        if(isTurn) {
            panel.setBorder(ACTIVE_BORDER);
        } else {
            panel.setBorder(NORMAL_BORDER);
        }
    }

    public void setBankrupted(boolean bankrupted) {
        panel.setBackground(bankrupted ? Color.LIGHT_GRAY : Color.WHITE);
        playerName.setForeground(bankrupted ? Color.DARK_GRAY : Color.BLACK);
        playerMoney.setForeground(bankrupted ? Color.DARK_GRAY : Color.BLACK);
        playerMoney.setText(bankrupted ? "Bankrupt" : "Rp " + playerMoney);
    }
}
