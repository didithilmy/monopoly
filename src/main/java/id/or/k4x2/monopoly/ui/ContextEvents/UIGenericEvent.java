package id.or.k4x2.monopoly.ui.ContextEvents;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import java.awt.*;

public class UIGenericEvent {
    private JPanel panel;
    private JLabel lblEvent;

    public UIGenericEvent(String event) {
        super();
        lblEvent.setText("<html>" + event + "</html>");
    }

    public JPanel getPanel() {
        return panel;
    }
}
