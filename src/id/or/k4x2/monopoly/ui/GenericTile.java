package id.or.k4x2.monopoly.ui;

import javax.swing.*;

public class GenericTile {
    private JLabel propertyName;
    private JPanel panel;

    public GenericTile(String tileName) {
        this.propertyName.setText(tileName);
    }

    public JPanel getPanel() {
        return panel;
    }
}
