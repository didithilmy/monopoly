package id.or.k4x2.monopoly.ui.ContextEvents;

import id.or.k4x2.monopoly.entity.Player;
import id.or.k4x2.monopoly.entity.Properties.Lot;
import id.or.k4x2.monopoly.entity.Property;
import id.or.k4x2.monopoly.model.Context;
import id.or.k4x2.monopoly.model.ContextEvents.GenericEvent;
import id.or.k4x2.monopoly.model.GameManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UILotGroupOwned {
    private JPanel panel;
    private JButton btnBuildHouse;
    private JLabel lblDesc;

    public UILotGroupOwned(Lot lot) {
        int price = (int) (lot.getBasePrice() * Lot.HOUSE_PRICE_FACTOR);
        lblDesc.setText("<html>Bangun rumah impianmu hanya dengan Rp " + price + "</html>");

        Player player = Context.getInstance().getCurrentPlayer();

        if(player.getMoney() < price) {
            btnBuildHouse.setEnabled(false);
            btnBuildHouse.setText("Uang tidak cukup");
        } else if(lot.getNoOfHouses() >= 4) {
            btnBuildHouse.setEnabled(false);
            btnBuildHouse.setText("Rumah sudah maksimal");
        } else {
            btnBuildHouse.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        GameManager.getInstance().constructHouse(player, lot);

                        // Log event
                        Context.getInstance().logEvent(new GenericEvent(player.getName() + " membuat sebuah rumah"));

                        // Recheck buttons
                        if(player.getMoney() < price) {
                            btnBuildHouse.setEnabled(false);
                            btnBuildHouse.setText("Uang tidak cukup");
                        } else if(lot.getNoOfHouses() >= 4) {
                            btnBuildHouse.setEnabled(false);
                            btnBuildHouse.setText("Rumah sudah maksimal");
                        }
                    } catch (Lot.LotException er) {
                        er.printStackTrace();
                    }
                }
            });
        }
    }

    public JPanel getPanel() {
        return panel;
    }
}
