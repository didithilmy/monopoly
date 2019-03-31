package id.or.k4x2.monopoly.ui;

import id.or.k4x2.monopoly.entity.Tile;

import javax.swing.*;

public class GenericTile extends UITile {
    private JLabel propertyName;
    private JPanel panel;

    public GenericTile(Tile tile, String tileName) {
        super(tile);
        this.propertyName.setText("<html><center>" + tileName.replaceAll("\n", "<br>") + "</center></html>");
    }

    public JPanel getPanel() {
        return panel;
    }
}
