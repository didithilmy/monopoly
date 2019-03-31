package id.or.k4x2.monopoly.ui;

import id.or.k4x2.monopoly.entity.Player;
import id.or.k4x2.monopoly.listeners.*;
import id.or.k4x2.monopoly.model.ContextEvents.*;
import id.or.k4x2.monopoly.model.GameManager;
import id.or.k4x2.monopoly.ui.ContextEvents.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameWindow implements GameStateListener, PlayerAttributesListener, ContextListener, ContextEventListener {
    private JPanel panel;
    private JPanel playerPane;
    private JPanel boardPane;
    private JPanel dicePane;
    private JPanel eventsPane;

    private Map<Player.Designation, PlayerDetailPane> windowMap;

    public GameWindow() {
        super();
        Listeners.addGameStateListener(this);
        Listeners.addPlayerAttributesListener(this);
        Listeners.addContextListener(this);
        Listeners.addContextEventListener(this);

        windowMap = new HashMap<>();

        GridLayout layout = new GridLayout(0, 1);
        layout.setVgap(8);
        playerPane.setLayout(layout);
        playerPane.setBorder(new EmptyBorder(8, 8, 8, 8));

        BoxLayout boxLayout = new BoxLayout(eventsPane, BoxLayout.Y_AXIS);
        eventsPane.setLayout(boxLayout);
    }

    public JPanel getPanel() {
        return panel;
    }

    public JPanel getPlayerPane() {
        return playerPane;
    }

    public JPanel getBoardPane() {
        return boardPane;
    }

    public JPanel getDicePane() {
        return dicePane;
    }

    public void onGameStart() {
        // Add Player panes
        List<Player> players = GameManager.getInstance().getPlayers();
        for(Player player : players) {
            PlayerDetailPane playerDetailPane = new PlayerDetailPane();
            playerDetailPane.getPlayerName().setText(player.getName());
            playerDetailPane.getPlayerMoney().setText("Rp " + player.getMoney());

            Player.Designation designation = player.getDesignation();
            playerDetailPane.getPaneColor().setBackground(new Color(designation.getColR(), designation.getColG(), designation.getColB()));

            playerPane.add(playerDetailPane.getPanel());
            windowMap.put(player.getDesignation(), playerDetailPane);
        }
    }

    public void onGameFinished() {

    }

    /**
     * On money updated
     * @param player Player entity
     * @param oldNominal old nominal
     * @param newNominal new nominal
     */
    public void moneyUpdated(Player player, int oldNominal, int newNominal) {
        PlayerDetailPane pane = windowMap.get(player.getDesignation());
        if(pane != null) {
            pane.getPlayerMoney().setText("Rp " + newNominal);
        }
    }

    /**
     * On player bankrupted
     * @param player Player entity
     */
    public void onPlayerBankrupted(Player player) {

    }

    /**
     * On begin turn
     * @param oldPlayer Player entity
     * @param player Player entity
     */
    public void onBeginTurn(Player oldPlayer, Player player) {
        PlayerDetailPane pane = windowMap.get(player.getDesignation());

        if(pane != null) {
            if(oldPlayer != null) {
                PlayerDetailPane oldPane = windowMap.get(oldPlayer.getDesignation());
                oldPane.setPlayerTurn(false);
            }

            pane.setPlayerTurn(true);
        }

        // Clear event pane
        eventsPane.removeAll();
        eventsPane.repaint();
    }

    /**
     * On turn ended
     * @param player Player entity
     */
    public void onTurnEnded(Player player) {

    }

    /**
     * On winner declared
     * @param player Player entity
     */
    public void onWinnerDeclared(Player player) {
        // TODO set UI
    }

    /**
     * On dice rolled
     * @param player Player entity
     */
    public void onDiceRolled(Player player) {

    }

    /**
     * On context event logged
     * @param event Event entity
     */
    public void onEventLogged(ContextEvent event) {
        if(event instanceof CardEvent) {
            // CardEvent
            CardEvent cardEvent = (CardEvent) event;
            UICardEvent uiCardEvent = new UICardEvent(cardEvent.isChance(), cardEvent.getCardName(), cardEvent.getCardDescription());

            eventsPane.add(uiCardEvent.getPanel());
        } else if(event instanceof GenericEvent) {
            // GenericEvent
            GenericEvent genericEvent = (GenericEvent) event;
            UIGenericEvent uiGenericEvent = new UIGenericEvent(genericEvent.getEvent());

            eventsPane.add(uiGenericEvent.getPanel());
        } else if(event instanceof MoneyEvent) {
            // MoneyEvent
            MoneyEvent moneyEvent = (MoneyEvent) event;
            UIMoneyEvent uiMoneyEvent = new UIMoneyEvent(moneyEvent.isMoneyAdded(), moneyEvent.getNominal(), moneyEvent.getMessage());

            eventsPane.add(uiMoneyEvent.getPanel());
        } else if(event instanceof JailedEvent) {
            // JailedEvent
            UIJailedEvent uiJailedEvent = new UIJailedEvent();

            eventsPane.add(uiJailedEvent.getPanel());
        } else if(event instanceof PropertyUnownedEvent) {
            // PropertyUnownedEvent
            PropertyUnownedEvent propertyUnownedEvent = (PropertyUnownedEvent) event;
            UIPropertyUnownedEvent uiPropertyUnownedEvent = new UIPropertyUnownedEvent(propertyUnownedEvent.getProperty());

            eventsPane.add(uiPropertyUnownedEvent.getPanel());
        } else if(event instanceof GroupOwnedEvent) {
            // PropertyUnownedEvent
            GroupOwnedEvent groupOwnedEvent = (GroupOwnedEvent) event;
            UILotGroupOwned uiLotGroupOwned = new UILotGroupOwned(groupOwnedEvent.getLot());

            eventsPane.add(uiLotGroupOwned.getPanel());
        } else {
            // TODO change
            UIGenericEvent uiGenericEvent = new UIGenericEvent(event.toString());

            eventsPane.add(uiGenericEvent.getPanel());
        }

        eventsPane.add(Box.createRigidArea(new Dimension(0,8)));
        eventsPane.revalidate();
        eventsPane.repaint();
    }
}