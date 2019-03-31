package id.or.k4x2.monopoly.entity.Spaces;
/**
 * if player go to jail
 * @author Muhammad Yanza Hattari/18217043
 */

import id.or.k4x2.monopoly.entity.Player;
import id.or.k4x2.monopoly.entity.Space;
import id.or.k4x2.monopoly.model.Context;
import id.or.k4x2.monopoly.model.ContextEvents.GenericEvent;
import id.or.k4x2.monopoly.model.JailManager;

public class GoToJail extends Space {

    public GoToJail() {
        super("Masuk Penjara");
    }

    /**
     * On Player Landing
     * This method is called when a player lands on the Tile
     * @param player Player entity
     */
    public void onPlayerLanding(Player player) {
        super.onPlayerLanding(player);

        JailManager.getInstance().addJail(player);

        // Log event
        Context.getInstance().logEvent(new GenericEvent(player.getName() + " masuk penjara"));
    }

    /**
     * On Player Leaving
     * This method is called when a player is leaving off the Tile
     * @param player Player entity
     */

}
