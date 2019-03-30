package id.or.k4x2.monopoly.model.ContextEvents;

/**
 * Generic event
 */
public class GenericEvent extends ContextEvent {
    private String event;

    public GenericEvent(String event) {
        super();
        this.event = event;
    }

    public String getEvent() {
        return event;
    }

    @Override
    public String toString() {
        return "GenericEvent: " + event;
    }
}
