package id.or.k4x2.monopoly.entity.Properties;

import id.or.k4x2.monopoly.entity.Player;
import id.or.k4x2.monopoly.entity.Property;
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
                return(1/8 * getBasePrice());
            }else if (getNumUtility(getOwner())==2){ 
                return(1/2 * getBasePrice()); 
             }else {
                return(getBasePrice()); 
            }
        } 
    }

    /**
     * On Player Landing
     * This method is called when a player lands on the Tile
     * @param player Player entity
     */
    public void onPlayerLanding(Player player) {
        if (getOwner()!= null){ 
            if (getOwner()!=player){
                GameManager.getInstance().deductMoney(player,getRentPrice());
                GameManager.getInstance().checkBankruptcy();
            }
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