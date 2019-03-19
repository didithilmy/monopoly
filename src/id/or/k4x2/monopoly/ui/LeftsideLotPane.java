package id.or.k4x2.monopoly.ui;

import javax.swing.*;
import java.awt.*;

public class LeftsideLotPane {
    private JPanel panel;
    private JLabel propertyName;
    private JPanel panelColor;

    public LeftsideLotPane(String propertyName, Color color) {
        this.propertyName.setText(propertyName);
        this.panelColor.setBackground(color);
    }

    public JPanel getPanel() {
        return panel;
    }
}
