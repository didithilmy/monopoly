package id.or.k4x2.monopoly.entity.Cards;

import id.or.k4x2.monopoly.entity.Player;
import id.or.k4x2.monopoly.model.GameManager;

/**
 * Move to card entity
 * @author Muhammad Yanza Hattari/18217043
 */
public class MoveToCard extends Card {
    int tileIndex;

    public MoveToCard(String name, String desc, int tileIndex) {
        super(name, desc);
        this.tileIndex = tileIndex;
    }

    public int getTileIndex() {
        return tileIndex;
    }

    public void setTileIndex(int tileIndex) {
        this.tileIndex = tileIndex;
    }

    public void doAction(Player player) {
        GameManager.getInstance().movePlayer(player,tileIndex);
    }
}
