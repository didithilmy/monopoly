package id.or.k4x2.monopoly.entity.Cards;

import id.or.k4x2.monopoly.entity.Player;
/**
 * card entity
 * @author Muhammad Yanza Hattari/18217043
 */
public abstract class Card {
    private String name;
    private String desc;

    public Card(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public abstract void doAction(Player player);
}
