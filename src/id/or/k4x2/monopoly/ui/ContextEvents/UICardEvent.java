package id.or.k4x2.monopoly.ui.ContextEvents;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import java.awt.*;

public class UICardEvent {
    private JPanel panel;
    private JLabel lblCardType;
    private JLabel lblTitle;
    private JLabel lblDesc;

    public UICardEvent(boolean isChance, String title, String desc) {
        super();
        lblCardType.setText(isChance ? "KESEMPATAN" : "DANA UMUM");
        lblTitle.setText("<html>" + title + "</html>");
        lblDesc.setText("<html>" + desc + "</html>");

        panel.setBackground(
                isChance ? new Color(255,235,238) : new Color(220,237,200)
        );
    }

    public JPanel getPanel() {
        return panel;
    }
}
