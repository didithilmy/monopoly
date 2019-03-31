package id.or.k4x2.monopoly.entity.Properties;

import id.or.k4x2.monopoly.entity.Player;
import id.or.k4x2.monopoly.entity.Property;
import id.or.k4x2.monopoly.model.Context;
import id.or.k4x2.monopoly.model.ContextEvents.MoneyEvent;
import id.or.k4x2.monopoly.model.ContextEvents.PropertyUnownedEvent;
import id.or.k4x2.monopoly.model.GameManager;

/*
 * @author Zalikha Adiera Gambetta, NIM 18217027
 */

public class Railroad extends Property {

    public Railroad(String name, int basePrice) {
        super(name, basePrice);
    }

    /**
     * Get rent price
     * @return rent price
     */
    public int getRentPrice() {
        if (getOwner() == null) {
            return 0;
        } else {
            int num = getNumRailroad(getOwner());
            if (num == 1) {
                return (getBasePrice() / 8);
            } else if (num == 2) {
                return (getBasePrice() / 4);
            } else if (num == 3) {
                return (getBasePrice() / 2);
            } else if (num == 4) {
                return (getBasePrice());
            } else {
                throw new RuntimeException("Illegal railroad: " + num);
            }
        }
    }

    /**
     * On Player Landing
     * This method is called when a player lands on the Tile
     * @param player Player entity
     */
    public void onPlayerLanding(Player player) {
        super.onPlayerLanding(player);

        // cek dah ada owner atau belom, kalo belom tawarin. kalo dia mau beli kurangin duit dan set owner = player, kalo gamau return owner return null
        if (getOwner() != null) {
            if (getOwner() != player) {
                int nominal = getRentPrice();
                GameManager.getInstance().deductMoney(player, nominal);
                GameManager.getInstance().addMoney(getOwner(), nominal);

                // Log event
                Context.getInstance().logEvent(new MoneyEvent(false, nominal, player.getName() + " pays Rp " + nominal + " to " + getOwner().getName() + " in rent"));

                //GameManager.getInstance().checkBankruptcy();
            }
        } else {
            // No owner, log event
            Context.getInstance().logEvent(new PropertyUnownedEvent(this));
        }
    }

    /**
     * On Player Leaving
     * This method is called when a player is leaving off the Tile
     * @param player Player entity
     */
    public void onPlayerLeaving(Player player) {
        // TODO implement
    }

    public static int getNumRailroad(Player player) {
        int count = 0;
        for (Property property : player.getProperties()) {
            if (property instanceof Railroad) {
                count++;
            }
        }
        return count;
    }
}
