package id.or.k4x2.monopoly.model.ContextEvents;

/**
 * Money mutation event
 */
public class MoneyEvent extends ContextEvent {
    private boolean moneyAdded;
    private int nominal;
    private String message;

    public MoneyEvent(boolean moneyAdded, int nominal, String message) {
        super();
        this.moneyAdded = moneyAdded;
        this.nominal = nominal;
        this.message = message;
    }

    public boolean isMoneyAdded() {
        return moneyAdded;
    }

    public int getNominal() {
        return nominal;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "MoneyEvent: [moneyAdded=" + (moneyAdded ? "true" : "false") + ", nominal=" + nominal + ", message=" + message + "]";
    }
}
