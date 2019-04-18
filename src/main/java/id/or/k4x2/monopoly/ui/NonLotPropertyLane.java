package id.or.k4x2.monopoly.ui;

import id.or.k4x2.monopoly.entity.Property;

import javax.swing.*;

public class NonLotPropertyLane {
    private JPanel panel;
    private JLabel lblName;
    private JLabel lblRent;

    public NonLotPropertyLane(Property property) {
        lblName.setText(property.getName());
        lblRent.setText("Harga sewa: Rp"+property.getRentPrice());
    }

    public JPanel getPanel() {
        return panel;
    }


}
