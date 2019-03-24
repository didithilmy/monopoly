package id.or.k4x2.monopoly.entity.Cards;

import id.or.k4x2.monopoly.entity.Player;

/**
 * deduct money entity
 * @author Muhammad Yanza Hattari/18217043
 */
public class DeductMoneyCard extends Card {
    private int dedmoney;

    public DeductMoneyCard(String name, String desc,int dedmoney){
        super(name, desc);
        this.dedmoney = dedmoney;
    }

    public int getDedmoney() {
        return dedmoney;
    }

    public void setDedmoney(int dedmoney) {
        this.dedmoney = dedmoney;
    }

    public void doAction(Player player) {
        //TODO deduct money
    }
}
