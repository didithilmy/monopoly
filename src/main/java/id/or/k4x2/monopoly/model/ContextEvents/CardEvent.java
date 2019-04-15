package id.or.k4x2.monopoly.model.ContextEvents;

/**
 * Chance/community chest event
 */
public class CardEvent extends ContextEvent {
    private boolean isChance;
    private String cardName;
    private String cardDescription;

    public CardEvent(boolean isChance, String cardName, String cardDescription) {
        super();
        this.isChance = isChance;
        this.cardName = cardName;
        this.cardDescription = cardDescription;
    }

    public boolean isChance() {
        return isChance;
    }

    public String getCardName() {
        return cardName;
    }

    public String getCardDescription() {
        return cardDescription;
    }

    @Override
    public String toString() {
        return "Mendapat kartu " + (isChance ? "Kesempatan" : "Dana Umum") + " " + cardName;
        //return "CardEvent: [isChance=" + (isChance ? "true" : "false") + ", cardName=" + cardName + ", cardDesc=" + cardDescription + "]";
    }
}
