package id.or.k4x2.monopoly.entity.Properties;

import id.or.k4x2.monopoly.entity.Player;
import id.or.k4x2.monopoly.entity.Property;
import id.or.k4x2.monopoly.model.Context;
import id.or.k4x2.monopoly.model.ContextEvents.GroupOwnedEvent;
import id.or.k4x2.monopoly.model.ContextEvents.MoneyEvent;
import id.or.k4x2.monopoly.model.ContextEvents.PropertyUnownedEvent;
import id.or.k4x2.monopoly.model.GameManager;

/**
 * Lot entity
 * @author Muhammad Yanza Hattari/18217043
 */
public class Lot extends Property {
    private Group group;
    private int noOfHouses = 0;
    public final static float HOUSE_PRICE_FACTOR = 0.5f;

    public Lot(String name, int basePrice, Group group) {
        super(name, basePrice);

        this.group = group;
    }

    /**
     * Get rent price, based on the no of houses
     * @return rent price
     */
    public int getRentPrice() {
        if (getOwner()!=null) {
            if (noOfHouses == 0) {
                if (getNoGroupOwned(getOwner(), this.group)==group.getNo()) {
                    return (getBasePrice() / 4);
                } else {
                    return (getBasePrice() / 8);
                }
            } else if (noOfHouses == 1) {
                return (getBasePrice() / 2);
            } else if (noOfHouses == 2) {
                return (getBasePrice());
            } else if (noOfHouses == 3) {
                return (getBasePrice() * 2);
            } else if (noOfHouses == 4) {
                return (getRentPrice() * 4);
            }
            else {
                throw new RuntimeException("Illegal noOfHouses");
            }
        }
        else {return 0;}
    }

    /**
     * On Player Landing
     * This method is called when a player lands on the Tile
     * @param player Player entity
     */
    public void onPlayerLanding(Player player) {
        super.onPlayerLanding(player);

        if (getOwner()!=null) {
            if (getOwner() == player) {
                // Check if player owns the group
                if(getNoGroupOwned(getOwner(), this.group)==group.getNo()) {
                    // Log event
                    Context.getInstance().logEvent(new GroupOwnedEvent(this));
                }
            } else {
                int nominal = getRentPrice();
                GameManager.getInstance().deductMoney(player, nominal);
                GameManager.getInstance().addMoney(getOwner(),nominal);

                // Log event
                Context.getInstance().logEvent(new MoneyEvent(false, nominal, player.getName() + " membayar Rp " + nominal + " kepada " + getOwner().getName() + " untuk biaya sewa"));

                //GameManager.getInstance().checkBankruptcy();
            }
        } else {
            // No owner, log event
            Context.getInstance().logEvent(new PropertyUnownedEvent(this));
        }
    }

    public static int getNoGroupOwned(Player player,Group group) {
        int a = 0;
        for (Property property: player.getProperties()) {
            if (property instanceof Lot) {
                Lot lot = (Lot) property;
                if (lot.group== group) {
                    a++;
                }
            }
        }
        return (a);
    }

    /**
     * On Player Leaving
     * This method is called when a player is leaving off the Tile
     * @param player Player entity
     */

    /**
     * Construct a house
     * @throws LotException if a house can't be constructed
     */
    public void constructHouse() throws LotException {
        if (getNoGroupOwned(getOwner(),this.group)==group.getNo()) {
            int price = (int) (getBasePrice()*HOUSE_PRICE_FACTOR);
            if (noOfHouses<4) {
                if (getOwner().getMoney() < price) {
                    throw new LotException(LotException.Error.INSUFFICIENT_FUND);
                } else {
                    GameManager.getInstance().deductMoney(getOwner(),price);
                    noOfHouses++;
                }
            }
            else {
                throw new LotException(LotException.Error.MAX_HOUSES);
            }
        }
        else {
            throw new LotException(LotException.Error.GROUP_NOT_OWNED);
        }
    }

    public int getNoOfHouses() {
        return noOfHouses;
    }

    public void setNoOfHouses(int noOfHouses) {
        this.noOfHouses = noOfHouses;
    }

    /**
     * Lot group enumeration
     */
    public enum Group {
        BROWN(2), LIGHT_BLUE(3), PURPLE(3), ORANGE(3), RED(3), YELLOW(3), GREEN(3), BLUE(2);

        private int no;

        Group(int no) {
            this.no = no;
        }

        public int getNo() {
            return no;
        }
    }

    /**
     * Lot exception
     */
    public static class LotException extends Exception {
        private Error error;

        public LotException(Error error) {
            this.error = error;
        }

        public Error getError() {
            return error;
        }

        public enum Error {
            GROUP_NOT_OWNED, INSUFFICIENT_FUND, MAX_HOUSES
        }
    }
}
