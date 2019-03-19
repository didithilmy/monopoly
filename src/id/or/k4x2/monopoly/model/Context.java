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

    private Context() {
        players = new ArrayList<>();
        dice = new Dice();
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void start() {
        if(players.size() < 2) {
            throw new RuntimeException("Player size must be greater than 2");
        }

        // Set the current player to Player 1
        currentPlayer = players.get(0);
        dice.shuffle();
    }
}
