package id.or.k4x2.monopoly.entity.Cards;

import id.or.k4x2.monopoly.entity.Player;

/**
 * move static card entity
 * @author Muhammad Yanza Hattari/18217043
 */
public class MoveStaticCard extends Card {
    private int move;

    public MoveStaticCard(String name, String desc, int move){
        super(name, desc);
        this.move = move;
    }

    public void setMove(int move) {
        this.move = move;
    }

    public int getMove() {
        return move;
    }

    public void doAction(Player player) {
        //TODO move static
    }
}
