package id.or.k4x2.monopoly.entity.Cards;

import id.or.k4x2.monopoly.entity.Player;
import id.or.k4x2.monopoly.model.Context;
import id.or.k4x2.monopoly.model.ContextEvents.MoneyEvent;
import id.or.k4x2.monopoly.model.GameManager;

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
        GameManager.getInstance().deductMoney(player,dedmoney);

        // Log event
        Context.getInstance().logEvent(new MoneyEvent(false, dedmoney, player.getName() + " mengeluarkan Rp " + dedmoney));
    }
}
