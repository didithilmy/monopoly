package id.or.k4x2.monopoly.model.ContextEvents;

import id.or.k4x2.monopoly.entity.Properties.Lot;

public class GroupOwnedEvent extends ContextEvent {
    private Lot lot;

    public GroupOwnedEvent(Lot lot) {
        this.lot = lot;
    }

    public Lot getLot() {
        return lot;
    }

    @Override
    public String toString() {
        return null;
    }
}
