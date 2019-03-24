package id.or.k4x2.monopoly.model;

import id.or.k4x2.monopoly.entity.Player;
import id.or.k4x2.monopoly.entity.Properties.Lot;
import id.or.k4x2.monopoly.entity.Property;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Game manager class
 */
public class GameManager {
    private static GameManager instance = new GameManager();
    private List<Player> players;
    private Map<Player.Designation, Integer> positionMap;

    private GameManager() {
        positionMap = new HashMap<>();
    }

    public static GameManager getInstance() {
        return instance;
    }

    /**
     * Start game
     * @param players List of Players
     */
    public void start(List<Player> players) {
        if(players.size() < 2 || players.size() > 4) {
            throw new RuntimeException("Illegal no of players");
        }

        this.players = players;

        // Initialize positions
        positionMap.clear();
        for(Player player : players) {
            positionMap.put(player.getDesignation(), 0);
        }

        // TODO call start game
    }

    /**
     * Stop game
     */
    public void stop() {
        players = null;
        // TODO call stop game
    }

    /**
     * Move player
     * @param player Player entity
     * @param tileIndex tile index
     */
    public void movePlayer(Player player, int tileIndex) {
        assert players != null;
        // TODO implement
    }

    //TODO move player relative

    /**
     * Deduct money
     * @param player Player entity
     * @param nominal nominal to deduct
     */
    public void deductMoney(Player player, int nominal) {
        assert players != null;
        player.deductMoney(nominal);

        // TODO refresh UI
    }

    /**
     * Add money
     * @param player Player entity
     * @param nominal nominal to deduct
     */
    public void addMoney(Player player, int nominal) {
        assert players != null;
        player.addMoney(nominal);

        // TODO refresh UI
    }

    /**
     * Buy property
     * @param player Player entity
     * @param property Property entity
     */
    public void buyProperty(Player player, Property property) {
        // Make sure property is not owned
        if(property.getOwner() == null) {
            int price = property.getBasePrice();
            if (player.getMoney() >= price) {
                // Legal move
                // Deduct money
                player.deductMoney(price);

                // Set ownership
                property.setOwner(player);
            }
        }
    }

    /**
     * Construct a house
     * @param player Player entity
     * @param lot Lot entity
     */
    public void constructHouse(Player player, Lot lot) {
        // TODO implement
    }

    /**
     * Check bankruptcy
     * Iterate array of Players, remove any Player with negative money
     */
    public void checkBankruptcy() {
        // TODO implement
    }

    public List<Player> getPlayers() {
        return players;
    }
}
