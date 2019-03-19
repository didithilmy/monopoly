package id.or.k4x2.monopoly.ui;

import javax.swing.*;
import java.awt.*;

public class TopsideLotPane {
    private JLabel propertyName;
    private JPanel panel;
    private JPanel panelColor;

    public TopsideLotPane(String propertyName, Color color) {
        this.propertyName.setText(propertyName);
        this.panelColor.setBackground(color);
    }

    public JPanel getPanel() {
        return panel;
    }
}
