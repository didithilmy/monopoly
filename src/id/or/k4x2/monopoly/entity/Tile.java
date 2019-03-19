package id.or.k4x2.monopoly.entity;

/**
 * Tile entity representation
 * A "Tile" is a land-able piece of the board
 *
 * @author Muhammad Aditya Hilmy, NIM 18217025
 */
public abstract class Tile extends Entity {
    /**
     * On Player Landing
     * This method is called when a player lands on the Tile
     * @param player Player entity
     */
    public abstract void onPlayerLanding(Player player);
}
