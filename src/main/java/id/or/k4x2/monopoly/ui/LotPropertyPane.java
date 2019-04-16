package id.or.k4x2.monopoly.ui;

import id.or.k4x2.monopoly.entity.Properties.Lot;

import javax.swing.*;
import java.awt.*;

public class LotPropertyPane {
    private JLabel lblLotName;
    private JLabel lblRent;
    private JLabel lblHouse;
    private JPanel panelColor;
    private JPanel panel;

    public LotPropertyPane(Lot lot) {
        lblLotName.setText(lot.getName());
        lblRent.setText("Rp"+lot.getRentPrice());
        lblHouse.setText(lot.getNoOfHouses()+" Rumah");
        //panelColor.setBackground(color);
    }

    public JPanel getPanel() {
        return panel;
    }
}
