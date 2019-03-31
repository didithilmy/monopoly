package id.or.k4x2.monopoly.ui.ContextEvents;

import id.or.k4x2.monopoly.entity.Player;
import id.or.k4x2.monopoly.model.Context;
import id.or.k4x2.monopoly.model.ContextEvents.GenericEvent;
import id.or.k4x2.monopoly.model.ContextEvents.MoneyEvent;
import id.or.k4x2.monopoly.model.GameManager;
import id.or.k4x2.monopoly.model.JailManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UIJailedEvent {
    private JPanel panel;
    private JButton btnPostBail;
    private JLabel lblDesc;

    public static final int BAIL_PRICE = 200;

    public UIJailedEvent() {
        super();
        lblDesc.setText("<html>" + Context.getInstance().getCurrentPlayer().getName() + " sedang mendekam di penjara. Dapatkan angka dadu ganda atau bayar tebusan.</html>");

        Player player = Context.getInstance().getCurrentPlayer();

        // Check available fund
        if(player.getMoney() < BAIL_PRICE) {
            // Insufficient fund
            btnPostBail.setEnabled(false);
        }

        btnPostBail.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (JailManager.getInstance().checkJail(player)) {
                    // Deduct money
                    GameManager.getInstance().deductMoney(player, BAIL_PRICE);
                    JailManager.getInstance().removeJail(player);

                    // Log event
                    Context.getInstance().logEvent(new MoneyEvent(false, BAIL_PRICE, player.getName() + " membayar tebusan untuk keluar dari penjara"));
                    Context.getInstance().logEvent(new GenericEvent(player.getName() + " keluar dari penjara"));
                }

                btnPostBail.setEnabled(false);
            }
        });
    }

    public JPanel getPanel() {
        return panel;
    }
}
