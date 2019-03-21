package id.or.k4x2.monopoly.entity.Properties;

import id.or.k4x2.monopoly.entity.Player;
import id.or.k4x2.monopoly.entity.Property;

public class Railroad extends Property {

    public Railroad(String name, int basePrice) {
        super(name, basePrice);
    }

    /**
     * Get rent price
     * @return rent price
     */
    public int getRentPrice() {
        // TODO implement
        return 0;
    }

    /**
     * On Player Landing
     * This method is called when a player lands on the Tile
     * @param player Player entity
     */
    public void onPlayerLanding(Player player) {
        // TODO implement
    }

    /**
     * On Player Leaving
     * This method is called when a player is leaving off the Tile
     * @param player Player entity
     */
    public void onPlayerLeaving(Player player) {
        // TODO implement
    }
}
