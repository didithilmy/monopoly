package id.or.k4x2.monopoly.entity.Properties;

import id.or.k4x2.monopoly.entity.Player;
import id.or.k4x2.monopoly.entity.Property;

public class Lot extends Property {
    private Group group;
    private int noOfHouses = 0;

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
        return 0;
    }

    /**
     * On Player Landing
     * This method is called when a player lands on the Tile
     * @param player Player entity
     */
    public void onPlayerLanding(Player player) {
        // TODO implement
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
    }

    /**
     * Lot group enumeration
     */
    public enum Group {
        BROWN, LIGHT_BLUE, PURPLE, ORANGE, RED, YELLOW, GREEN, BLUE;
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
