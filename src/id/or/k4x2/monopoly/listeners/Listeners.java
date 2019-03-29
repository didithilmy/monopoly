package id.or.k4x2.monopoly.listeners;

import id.or.k4x2.monopoly.entity.Player;

import java.util.HashSet;
import java.util.Set;

/**
 * Listeners static class
 */
public class Listeners {
    private static Set<GameStateListener> gameStateListeners = new HashSet<>();
    private static Set<PlayerMovedListener> playerMovedListeners = new HashSet<>();
    private static Set<PlayerAttributesListener> playerAttributesListeners = new HashSet<>();
    private static Set<ContextListener> contextListeners = new HashSet<>();

    public static void clear() {
        gameStateListeners.clear();
        playerMovedListeners.clear();
        playerAttributesListeners.clear();
        contextListeners.clear();
    }

    public static void addGameStateListener(GameStateListener listener) {
        gameStateListeners.add(listener);
    }

    public static void removeGameStateListener(GameStateListener listener) {
        gameStateListeners.remove(listener);
    }

    public static void addPlayerMoveListener(PlayerMovedListener listener) {
        playerMovedListeners.add(listener);
    }

    public static void removePlayerMoveListener(PlayerMovedListener listener) {
        playerMovedListeners.remove(listener);
    }

    public static void addPlayerAttributesListener(PlayerAttributesListener listener) {
        playerAttributesListeners.add(listener);
    }

    public static void removePlayerAttributesListener(PlayerAttributesListener listener) {
        playerAttributesListeners.remove(listener);
    }

    public static void addContextListener(ContextListener listener) {
        contextListeners.add(listener);
    }

    public static void removeContextListener(ContextListener listener) {
        contextListeners.remove(listener);
    }

    public static void invokeStartGame() {
        for(GameStateListener listener : gameStateListeners) {
            listener.onGameStart();
        }
    }

    public static void invokeFinishGame() {
        for(GameStateListener listener : gameStateListeners) {
            listener.onGameFinished();
        }
    }

    public static void invokePlayerMoved(Player player, int tileIndex) {
        for(PlayerMovedListener listener : playerMovedListeners) {
            listener.onPlayerMoved(player, tileIndex);
        }
    }

    public static void invokePlayerBankrupted(Player player) {
        for(PlayerAttributesListener listener : playerAttributesListeners) {
            listener.onPlayerBankrupted(player);
        }
    }

    public static void invokeMoneyUpdated(Player player, int oldNominal, int newNominal) {
        for(PlayerAttributesListener listener : playerAttributesListeners) {
            listener.moneyUpdated(player, oldNominal, newNominal);
        }
    }

    public static void invokeBeginTurn(Player player) {
        for(ContextListener listener : contextListeners) {
            listener.onBeginTurn(player);
        }
    }

    public static void invokeEndTurn(Player player) {
        for(ContextListener listener : contextListeners) {
            listener.onTurnEnded(player);
        }
    }

    public static void invokeWinnerDeclared(Player player) {
        for(ContextListener listener : contextListeners) {
            listener.onWinnerDeclared(player);
        }
    }
}
