package id.or.k4x2.monopoly.entity.Spaces;

import id.or.k4x2.monopoly.entity.Cards.Card;
import id.or.k4x2.monopoly.entity.Player;
import id.or.k4x2.monopoly.entity.Space;
import id.or.k4x2.monopoly.model.Cards;
import id.or.k4x2.monopoly.model.DeckRandomizer;

/**
 * Randomize chance cards
 * @author Muhammad Yanza Hattari/18217043
 */
public class Chance extends Space {
    /**
     * On Player Landing
     * This method is called when a player lands on the Tile
     * @param player Player entity
     */
    public void onPlayerLanding(Player player) {
        DeckRandomizer<Card> cards = new DeckRandomizer<>(Cards.getChanceCards());

        Card card = cards.randomize();
        card.doAction(player);
    }

    /**
     * On Player Leaving
     * This method is called when a player is leaving off the Tile
     * @param player Player entity
     */
    public void onPlayerLeaving(Player player) {
        // TODO implement
    }
}
