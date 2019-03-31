package id.or.k4x2.monopoly.entity.Properties;

import id.or.k4x2.monopoly.entity.Player;
import id.or.k4x2.monopoly.entity.Property;
import id.or.k4x2.monopoly.model.Context;
import id.or.k4x2.monopoly.model.ContextEvents.MoneyEvent;
import id.or.k4x2.monopoly.model.ContextEvents.PropertyUnownedEvent;
import id.or.k4x2.monopoly.model.GameManager;
/**
 * @author Claudia Renata, 18217048
 * @author Muhammad Yanza Hattari/18217043
*/

public class Utility extends Property {

    public Utility(String name, int basePrice) {
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
           if (getNumUtility(getOwner())==1){
                return getBasePrice() / 8;
            }else if (getNumUtility(getOwner())==2){ 
                return getBasePrice() / 2;
             }else {
                return getBasePrice();
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

        if (getOwner()!= null){ 
            if (getOwner()!=player){
                int nominal = getRentPrice();

                GameManager.getInstance().deductMoney(player, nominal);
                GameManager.getInstance().addMoney(getOwner(), nominal);

                // Log event
                Context.getInstance().logEvent(new MoneyEvent(false, nominal, player.getName() + " membayar Rp " + nominal + " ke " + getOwner().getName() + " untuk biaya sewa"));

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
    
    public static int getNumUtility(Player player){
        int count=0; 
        for (Property property: player.getProperties()){
            if (property instanceof Utility ){
                count++; 
            }
        }
        return count; 
    }
}