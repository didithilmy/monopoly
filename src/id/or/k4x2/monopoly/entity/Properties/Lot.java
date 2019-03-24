package id.or.k4x2.monopoly.entity.Properties;

import id.or.k4x2.monopoly.entity.Player;
import id.or.k4x2.monopoly.entity.Property;

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
        // TODO implement
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
        // TODO implement
        if (getOwner()!=null) {
            if (getOwner()==player) {
                //TODO offer player to build house
            }
            else {
                //TODO rent price - money
                //TODO check bankrupt
            }
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
    public void onPlayerLeaving(Player player) {
        // TODO implement
    }

    /**
     * Construct a house
     * @throws LotException if a house can't be constructed
     */
    public void constructHouse() throws LotException {
        // TODO implement
        if (getNoGroupOwned(getOwner(),this.group)==group.getNo()) {
            int price = (int) (getBasePrice()*HOUSE_PRICE_FACTOR);
            if (noOfHouses<4) {
                if (getOwner().getMoney() < price) {
                    throw new LotException(LotException.Error.INSUFFICIENT_FUND);
                } else {
                    //TODO charge player's money with price
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
