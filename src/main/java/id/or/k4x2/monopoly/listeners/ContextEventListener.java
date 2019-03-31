package id.or.k4x2.monopoly.listeners;

import id.or.k4x2.monopoly.entity.Player;
import id.or.k4x2.monopoly.model.ContextEvents.ContextEvent;

/**
 * Context events listener interface
 */
public interface ContextEventListener {
    /**
     * On context event logged
     * @param event Event entity
     */
    public void onEventLogged(ContextEvent event);
}
