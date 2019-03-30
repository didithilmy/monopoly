package id.or.k4x2.monopoly.entity;

import id.or.k4x2.monopoly.model.Context;
import id.or.k4x2.monopoly.model.ContextEvents.GenericEvent;

/**
 * Tile entity representation
 * A "Tile" is a land-able piece of the board
 *
 * @author Muhammad Aditya Hilmy, NIM 18217025
 */
public abstract class Tile extends Entity {
    private String name;

    public Tile(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * On Player Landing
     * This method is called when a player lands on the Tile
     * @param player Player entity
     */
    public void onPlayerLanding(Player player) {
        // Log event
        Context.getInstance().logEvent(new GenericEvent(player.getName() + " mendarat pada " + getName()));
    }

    /**
     * On Player Leaving
     * This method is called when a player is leaving off the Tile
     * @param player Player entity
     */
    public void onPlayerLeaving(Player player) {

    }
}
