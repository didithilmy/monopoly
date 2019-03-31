package id.or.k4x2.monopoly.entity.Spaces;

import id.or.k4x2.monopoly.entity.Player;
import id.or.k4x2.monopoly.entity.Space;
import id.or.k4x2.monopoly.model.Context;
import id.or.k4x2.monopoly.model.ContextEvents.GenericEvent;
import id.or.k4x2.monopoly.model.ContextEvents.MoneyEvent;
import id.or.k4x2.monopoly.model.GameManager;

public class Taxation extends Space {

    public Taxation(String name) {
        super(name);
    }

    /**
     * On Player Landing
     * This method is called when a player lands on the Tile
     * @param player Player entity
     */
    public void onPlayerLanding(Player player) {
        super.onPlayerLanding(player);

        int tax = (int) (player.getMoney()*0.1);
        GameManager.getInstance().deductMoney(player,tax);

        // Log event
        Context.getInstance().logEvent(new MoneyEvent(false, tax, player.getName() + " membayar " + getName() + " sebesar 10% dari uang yang dimiliki"));
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
