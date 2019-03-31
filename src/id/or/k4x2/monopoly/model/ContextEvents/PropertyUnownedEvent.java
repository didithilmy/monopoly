package id.or.k4x2.monopoly.model.ContextEvents;

import id.or.k4x2.monopoly.entity.Property;

public class PropertyUnownedEvent extends ContextEvent {
    private Property property;

    public PropertyUnownedEvent(Property property) {
        this.property = property;
    }

    public Property getProperty() {
        return property;
    }
}
