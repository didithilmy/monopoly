package id.or.k4x2.monopoly.ui;

import id.or.k4x2.monopoly.entity.Tile;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public abstract class UITile {
    private Tile logicalTile;
    private static Map<Tile, UITile> map = new HashMap<>();

    public UITile(Tile tile) {
        this.logicalTile = tile;
        map.put(tile, this);
    }

    /**
     * Get UITile, given Tile
     * @param tile Tile
     * @return UITile
     */
    public static UITile getUITile(Tile tile) {
        return map.get(tile);
    }

    public Tile getLogicalTile() {
        return logicalTile;
    }

    public abstract JPanel getPanel();
}
