package id.or.k4x2.monopoly.ui.ContextEvents;

import javax.swing.*;
import java.awt.*;

public class UIMoneyEvent {
    private JPanel panel;
    private JLabel lblDesc;
    private JLabel lblNominal;
    private JLabel lblType;

    public UIMoneyEvent(boolean moneyAdded, int nominal, String desc) {
        super();
        lblType.setText(moneyAdded ? "KREDIT" : "DEBIT");
        lblType.setForeground(moneyAdded ? new Color(46,125,50) : new Color(198,40,40));
        lblNominal.setText("Rp " + nominal);
        lblDesc.setText("<html>" + desc + "</html>");
    }

    public JPanel getPanel() {
        return panel;
    }
}
