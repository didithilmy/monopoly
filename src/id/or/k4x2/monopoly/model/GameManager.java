package id.or.k4x2.monopoly.model;

import id.or.k4x2.monopoly.entity.Player;
import id.or.k4x2.monopoly.entity.Properties.Lot;
import id.or.k4x2.monopoly.entity.Property;
import id.or.k4x2.monopoly.entity.Tile;
import id.or.k4x2.monopoly.listeners.GameStateListener;
import id.or.k4x2.monopoly.listeners.Listeners;
import id.or.k4x2.monopoly.listeners.PlayerMovedListener;
import id.or.k4x2.monopoly.model.ContextEvents.MoneyEvent;

import java.util.ArrayList;
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

        // Call start game
        Listeners.invokeStartGame();
    }

    /**
     * Stop game
     */
    public void stop() {
        players = null;

        // Call stop game
        Listeners.invokeFinishGame();
    }

    /**
     * Move player
     * @param player Player entity
     * @param tileIndex destination tile index
     */
    public void movePlayer(Player player, int tileIndex) {
        movePlayer(player, tileIndex, true);
    }

    /**
     * Move player
     * @param player Player entity
     * @param tileIndex destination tile index
     * @param checkPassGo if true, GameManager will check if the player moves pass Go. If it is, reward money.
     */
    public void movePlayer(Player player, int tileIndex, boolean checkPassGo) {
        assert players != null;
        assert players.contains(player);

        Tile destinationTile = Tiles.getTile(tileIndex);

        assert destinationTile != null;

        // Get current tile
        int currentPos = positionMap.get(player.getDesignation());
        Tile currentTile = Tiles.getTile(currentPos);

        assert currentTile != null;

        // Call on player leaving
        currentTile.onPlayerLeaving(player);

        // Check if pass go
        if(checkPassGo) {
            if(tileIndex < currentPos) {
                // If destination tile is less than current position, it passes through Go.
                // Reward money
                addMoney(player, 200);  // TODO don't hardcode

                // Log event
                Context.getInstance().logEvent(new MoneyEvent(true, 200, player.getName() + " mendapat Rp 200 karena melewati Mulai"));
            }
        }

        System.out.println("Player moved to " + tileIndex);

        // Update positions map
        positionMap.put(player.getDesignation(), tileIndex);

        // Call on player moved
        Listeners.invokePlayerMoved(player, tileIndex);

        // Call on player landing on destination tile
        destinationTile.onPlayerLanding(player);
    }

    /**
     * Move player relative to current position
     * @param player Player entity
     * @param relativeTiles relative tiles (negative for go back, positive for go forward)
     */
    public void movePlayerRelative(Player player, int relativeTiles) {
        int currentPos = positionMap.get(player.getDesignation());
        int nextPos = currentPos + relativeTiles;

        int noOfTiles = Tiles.getTiles().length;
        if(nextPos >= noOfTiles) {
            nextPos = nextPos % noOfTiles;
        } else if(nextPos < 0) {
            nextPos += noOfTiles;
        }

        movePlayer(player, nextPos, false);
    }

    /**
     * Deduct money
     * @param player Player entity
     * @param nominal nominal to deduct
     */
    public void deductMoney(Player player, int nominal) {
        assert players != null;

        int oldNominal = player.getMoney();

        player.deductMoney(nominal);

        int newNominal = player.getMoney();

        // Refresh UI
        Listeners.invokeMoneyUpdated(player, oldNominal, newNominal);
    }

    /**
     * Add money
     * @param player Player entity
     * @param nominal nominal to deduct
     */
    public void addMoney(Player player, int nominal) {
        assert players != null;

        int oldNominal = player.getMoney();

        player.addMoney(nominal);

        int newNominal = player.getMoney();

        // Refresh UI
        Listeners.invokeMoneyUpdated(player, oldNominal, newNominal);
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
                deductMoney(player, price);

                // Set ownership
                property.setOwner(player);

                // Add property to player
                player.getProperties().add(property);
            }
        }
    }

    /**
     * Construct a house
     * @param player Player entity
     * @param lot Lot entity
     */
    public void constructHouse(Player player, Lot lot) throws Lot.LotException {
        // Check if the player is the lot owner
        if(player == lot.getOwner()) {
            lot.constructHouse();
        }
    }

    /**
     * Check bankruptcy
     * Iterate array of Players, flag any Player with negative money
     */
    public void checkBankruptcy() {
        for(Player player : players) {
            if(player.getMoney() < 0) {
                player.setBankrupted(true);

                // Refresh UI
                Listeners.invokePlayerBankrupted(player);
            }
        }
    }

    public List<Player> getPlayers() {
        return players;
    }

    public int getPlayerTileIndex(Player player) {
        return positionMap.get(player.getDesignation());
    }
}
