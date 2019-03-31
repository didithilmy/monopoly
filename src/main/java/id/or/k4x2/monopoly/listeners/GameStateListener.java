package id.or.k4x2.monopoly.listeners;

/**
 * Game state listener interface
 */
public interface GameStateListener {
    /**
     * Called when the game is starting
     * Used to notify modules to initiate for a new game session, e.g. clearing Player hash maps
     */
    public void onGameStart();

    /**
     * Called when the game is finished
     * Used to notify modules to clean up game-related objects
     */
    public void onGameFinished();
}
