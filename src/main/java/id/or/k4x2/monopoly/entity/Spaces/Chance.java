package id.or.k4x2.monopoly.entity.Spaces;

import id.or.k4x2.monopoly.entity.Cards.Card;
import id.or.k4x2.monopoly.entity.Player;
import id.or.k4x2.monopoly.entity.Space;
import id.or.k4x2.monopoly.model.Cards;
import id.or.k4x2.monopoly.model.Context;
import id.or.k4x2.monopoly.model.ContextEvents.CardEvent;
import id.or.k4x2.monopoly.model.DeckRandomizer;

/**
 * Randomize chance cards
 * @author Muhammad Yanza Hattari/18217043
 */
public class Chance extends Space {

    public Chance() {
        super("Kesempatan");
    }

    /**
     * On Player Landing
     * This method is called when a player lands on the Tile
     * @param player Player entity
     */
    public void onPlayerLanding(Player player) {
        super.onPlayerLanding(player);

        DeckRandomizer<Card> cards = new DeckRandomizer<>(Cards.getChanceCards());

        Card card = cards.randomize();

        // Log event
        Context.getInstance().logEvent(new CardEvent(true, card.getName(), card.getDesc()));

        // Do action
        card.doAction(player);
    }

    /**
     * On Player Leaving
     * This method is called when a player is leaving off the Tile
     * @param player Player entity
     */

}
