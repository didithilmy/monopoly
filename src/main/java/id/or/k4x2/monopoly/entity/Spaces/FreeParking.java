package id.or.k4x2.monopoly.entity.Spaces;

import id.or.k4x2.monopoly.entity.Player;
import id.or.k4x2.monopoly.entity.Space;

public class FreeParking extends Space {

    public FreeParking(String name) {
        super(name);
    }

    /**
     * On Player Landing
     * This method is called when a player lands on the Tile
     * @param player Player entity
     */
    public void onPlayerLanding(Player player) {
        super.onPlayerLanding(player);
    }

    /**
     * On Player Leaving
     * This method is called when a player is leaving off the Tile
     * @param player Player entity
     */

}
