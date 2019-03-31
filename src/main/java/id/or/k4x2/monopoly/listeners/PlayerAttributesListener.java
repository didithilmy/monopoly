package id.or.k4x2.monopoly.listeners;

import id.or.k4x2.monopoly.entity.Player;

/**
 * Player attributes listener interface
 */
public interface PlayerAttributesListener {
    /**
     * On player bankrupted
     * @param player Player entity
     */
    public void onPlayerBankrupted(Player player);

    /**
     * On money changed
     * @param player Player entity
     * @param oldNominal old nominal
     * @param newNominal new nominal
     */
    public void moneyUpdated(Player player, int oldNominal, int newNominal);
}
