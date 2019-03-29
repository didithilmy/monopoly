package id.or.k4x2.monopoly.ui;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class PlayerDetailPane {
    private JPanel panel;
    private JPanel paneColor;
    private JLabel playerName;
    private JLabel playerMoney;

    public PlayerDetailPane() {
        super();

        Border border = BorderFactory.createLineBorder(Color.GRAY, 1);
        Border margin = new EmptyBorder(8, 8, 8, 8);
        panel.setBorder(new CompoundBorder(border, margin));
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
}
