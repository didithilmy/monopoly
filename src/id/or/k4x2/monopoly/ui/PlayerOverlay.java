package id.or.k4x2.monopoly.ui;

import id.or.k4x2.monopoly.entity.Player;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class PlayerOverlay extends JPanel {
    private JPanel playerIndic;
    private Map<Player.Designation, JLabel> labelMap;
    private UITile child;

    public PlayerOverlay(UITile child) {
        super();
        setLayout(new OverlayLayout(this));

        playerIndic = new JPanel(new FlowLayout(FlowLayout.LEFT, 2, 2));
        playerIndic.setOpaque(false);
        add(playerIndic);

        add(child.getPanel());

        labelMap = new HashMap<>();
        this.child = child;
    }

    /**
     * Attach player to the panel overlay
     * @param player
     */
    public final void attachPlayer(Player.Designation player) {
        JLabel label = new JLabel("  ");
        label.setPreferredSize(new Dimension(12, 12));
        label.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        label.setBackground(new Color(player.getColR(), player.getColG(), player.getColB()));
        label.setOpaque(true);
        playerIndic.add(label);
        labelMap.put(player, label);
    }

    public final void detachPlayer(Player.Designation player) {
        JLabel label = labelMap.get(player);
        if(label != null) {
            // Label exists
            playerIndic.remove(label);
            labelMap.remove(player);
        }
    }

    public final void detachAllPlayers() {
        for(Player.Designation player : labelMap.keySet()) {
            detachPlayer(player);
        }
    }

    public UITile getChild() {
        return child;
    }
}
