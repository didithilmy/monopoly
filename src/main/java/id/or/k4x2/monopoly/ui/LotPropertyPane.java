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
        lblRent.setText("Harga sewa: Rp"+lot.getRentPrice());
        lblHouse.setText(lot.getNoOfHouses()+" rumah");

        Lot.Group group = lot.getGroup();
        panelColor.setBackground(new Color(group.getR(), group.getG(), group.getB()));
    }

    public JPanel getPanel() {
        return panel;
    }
}
