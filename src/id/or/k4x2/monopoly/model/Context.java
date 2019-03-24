package id.or.k4x2.monopoly.model;

import id.or.k4x2.monopoly.entity.Dice;
import id.or.k4x2.monopoly.entity.Player;

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
        // TODO roll the dice
        // TODO move player

        diceRolled = true;
    }

    /**
     * End the player turn
     */
    public void endTurn() {
        // TODO end turn

        int noOfPlayers = GameManager.getInstance().getPlayers().size();

        // Move to next player in array
        currentPlayerIndex++;
        if(currentPlayerIndex >= noOfPlayers) {
            currentPlayerIndex = 0;
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
