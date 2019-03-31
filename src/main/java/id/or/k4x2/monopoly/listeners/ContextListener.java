package id.or.k4x2.monopoly.listeners;

import id.or.k4x2.monopoly.entity.Player;

/**
 * Context events listener interface
 */
public interface ContextListener {
    /**
     * On begin turn
     * @param previousPlayer Player entity
     * @param player Player entity
     */
    public void onBeginTurn(Player previousPlayer, Player player);

    /**
     * On turn ended
     * @param player Player entity
     */
    public void onTurnEnded(Player player);

    /**
     * On winner declared
     * @param player Player entity
     */
    public void onWinnerDeclared(Player player);

    /**
     * On dice rolled
     * @param player Player entity
     */
    public void onDiceRolled(Player player);
}
