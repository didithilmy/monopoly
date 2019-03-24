package id.or.k4x2.monopoly.entity.Cards;

import id.or.k4x2.monopoly.entity.Player;

/**
 * add money card entity
 * @author Muhammad Yanza Hattari/18217043
 */
public class AddMoneyCard extends Card {
    private int addmoney;

    public AddMoneyCard(String name, String desc, int addmoney){
        super(name, desc);
        this.addmoney = addmoney;
    }

    public int getAddmoney() {
        return addmoney;
    }

    public void setAddmoney(int addmoney) {
        this.addmoney = addmoney;
    }

    public void doAction(Player player) {
        //TODO add money
    }
}
