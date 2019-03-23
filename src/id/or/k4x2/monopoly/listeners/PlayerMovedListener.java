package id.or.k4x2.monopoly.listeners;

import id.or.k4x2.monopoly.entity.Player;

/**
 * Move player listener interface
 */
public interface PlayerMovedListener {
    /**
     * On player moved
     * @param player Player entity
     * @param tileIndex the index of the destination tile
     */
    public void onPlayerMoved(Player player, int tileIndex);
}
