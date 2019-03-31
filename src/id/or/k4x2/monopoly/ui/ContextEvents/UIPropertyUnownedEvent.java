package id.or.k4x2.monopoly.ui.ContextEvents;

import id.or.k4x2.monopoly.entity.Player;
import id.or.k4x2.monopoly.entity.Property;
import id.or.k4x2.monopoly.model.Context;
import id.or.k4x2.monopoly.model.ContextEvents.GenericEvent;
import id.or.k4x2.monopoly.model.GameManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UIPropertyUnownedEvent {
    private JPanel panel;
    private JButton btnBuy;
    private JLabel lblPropertyName;
    private JLabel lblDesc;
    private Property property;

    public UIPropertyUnownedEvent(Property property) {
        super();
        this.property = property;

        lblPropertyName.setText(property.getName());
        lblDesc.setText("<html>Beli " + property.getName() + " seharga Rp " + property.getBasePrice() + "</html>");
        btnBuy.setText("Beli " + property.getName());

        Player player = Context.getInstance().getCurrentPlayer();
        // Check if player money is sufficient
        if(player.getMoney() < property.getBasePrice()) {
            btnBuy.setEnabled(false);
            btnBuy.setText("Uang tidak cukup");
        } else {
            btnBuy.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    btnBuy.setEnabled(false);

                    // Buy property
                    GameManager.getInstance().buyProperty(player, property);

                    // Log event
                    Context.getInstance().logEvent(new GenericEvent(player.getName() + " membeli " + property.getName()));
                }
            });
        }
    }

    public JPanel getPanel() {
        return panel;
    }
}
