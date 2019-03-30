package id.or.k4x2.monopoly.model;

/**
 * @author Muhammad Yanza Hattari/18217043
 */

import id.or.k4x2.monopoly.entity.Dice;
import id.or.k4x2.monopoly.entity.Player;
import id.or.k4x2.monopoly.listeners.Listeners;

import java.util.ArrayList;
import java.util.List;

/**
 * Game context class
 * Holds all game-wide static classes
 *
 * @author Muhammad Aditya Hilmy, NIM 18217025
 */
public class Context {
    private static Context instance = new Context();

    public static Context getInstance() {
        return instance;
    }

    private int currentPlayerIndex = 0;
    private boolean diceRolled = false;
    private Dice dice;

    private Context() {
        dice = new Dice();
    }

    /**
     * Start game
     */
    public void start() {
        currentPlayerIndex = 0;
        diceRolled = false;
    }

    /**
     * Roll the dice
     */
    public void rollDice() {
        // Exit if dice is rolled already
        if(diceRolled) {
            return;
        }

        System.out.println("Dice is rolled");

        // Shuffle dice
        dice.shuffle();

        // check if player jailed
        boolean playerJailed = JailManager.getInstance().checkJail(getCurrentPlayer());

        if(playerJailed) {
            // If player is in jail, check if double dice
            if(dice.isDoubleDice()) {
                // Double dice, release from jail
                JailManager.getInstance().removeJail(getCurrentPlayer());
            }
            else{
                JailManager.getInstance().countTurn(getCurrentPlayer());
            }
        }

        if(!playerJailed) {
            // If player is not jailed, move is legal
            Player player = getCurrentPlayer();
            int currentPos = GameManager.getInstance().getPlayerTileIndex(player);
            int newPos = (currentPos + dice.getSum()) % Tiles.getTiles().length;

            // Move player
            GameManager.getInstance().movePlayer(player, newPos);
        }

        Listeners.invokeDiceRolled(getCurrentPlayer());

        diceRolled = true;
    }

    /**
     * End the player turn
     */
    public void endTurn() {
        List<Player> players = GameManager.getInstance().getPlayers();

        // Publish end turn
        Player oldPlayer = players.get(currentPlayerIndex);
        Listeners.invokeEndTurn(oldPlayer);

        int noOfPlayers = players.size();
        int i = 0;

        // Search for non-bankrupted player
        boolean found = false;
        while(!found && i < noOfPlayers) {
            currentPlayerIndex = (currentPlayerIndex + 1) % noOfPlayers;
            found = !players.get(currentPlayerIndex).isBankrupted();
            if(!found) {
                i++;
            }
        }

        if(i == noOfPlayers - 1) {
            // N-1 players are all bankrupt. We have a winner!
            // Publish winner
            Listeners.invokeWinnerDeclared(players.get(currentPlayerIndex));
        } else {
            // Publish begin turn
            Listeners.invokeBeginTurn(oldPlayer, players.get(currentPlayerIndex));
        }

        diceRolled = false;
    }

    /**
     * Get current player
     * @return current Player
     */
    public Player getCurrentPlayer() {
        return GameManager.getInstance().getPlayers().get(currentPlayerIndex);
    }

    public Dice getDice() {
        return dice;
    }
}
