package id.or.k4x2.monopoly.ui;

import id.or.k4x2.monopoly.entity.Tile;

import javax.swing.*;
import java.awt.*;

public class TopsideLotPane extends UITile {
    private JPanel panel;
    private JLabel propertyName;
    private JPanel panelColor;

    public TopsideLotPane(Tile tile, String propertyName, Color color) {
        super(tile);
        this.propertyName.setText("<html><center>" + propertyName.replaceAll("\n", "<br>") + "</center></html>");
        this.panelColor.setBackground(color);
    }

    public JPanel getPanel() {
        return panel;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
