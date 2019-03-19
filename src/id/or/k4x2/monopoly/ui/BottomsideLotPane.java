package id.or.k4x2.monopoly.ui;

import javax.swing.*;
import java.awt.*;

public class BottomsideLotPane {
    private JPanel panel;
    private JLabel propertyName;
    private JPanel panelColor;

    public BottomsideLotPane(String propertyName, Color color) {
        this.propertyName.setText(propertyName);
        this.panelColor.setBackground(color);
    }

    public JPanel getPanel() {
        return panel;
    }
}
