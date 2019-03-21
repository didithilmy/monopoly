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

    private List<Player> players;
    private Player currentPlayer;
    private Dice dice;
    private State state;

    private Context() {
        dice = new Dice();
        state = State.NOT_STARTED;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    /**
     * StartTile a new game
     */
    public void start() {
        if(players.size() < 2) {
            throw new RuntimeException("Player size must be greater than 2");
        }

        // Set the current player to Player 1
        currentPlayer = players.get(0);

        // Set state to Started
        state = State.IN_GAME;

        // Shuffle dice
        dice.shuffle();
    }

    /**
     * Move to the next player
     */
    public void nextTurn() {
        // TODO implement
    }
}
