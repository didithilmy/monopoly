package id.or.k4x2.monopoly.ui;

import id.or.k4x2.monopoly.entity.Player;
import id.or.k4x2.monopoly.entity.Properties.Lot;
import id.or.k4x2.monopoly.entity.Properties.Railroad;
import id.or.k4x2.monopoly.entity.Property;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;

public class PlayerDetailsWindow {
    private JLabel lblPlayerName;
    private JLabel lblMoney;
    private JPanel panelProperty;
    private JPanel panel;
    private JFrame frame;

    public PlayerDetailsWindow(Player player) {
        BoxLayout boxLayout = new BoxLayout(panelProperty, BoxLayout.Y_AXIS);
        panelProperty.setLayout(boxLayout);

        lblPlayerName.setText(player.getName());
        lblMoney.setText("Rp" + player.getMoney());
        List<Property> properties = player.getProperties();
        for (Property property:properties) {
            if (property instanceof Lot) {
                LotPropertyPane lotPropertyPane = new LotPropertyPane((Lot) property);
                JPanel panel = lotPropertyPane.getPanel();
                panelProperty.add(panel);
            } else {
                NonLotPropertyLane railroadPropertyLane = new NonLotPropertyLane(property);
                JPanel panel = railroadPropertyLane.getPanel();
                panelProperty.add(panel);
            }
            panelProperty.add(Box.createRigidArea(new Dimension(0,8)));
        }
    }

    public void show() {
        frame = new JFrame("Property Pemain");

        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
    }
}
