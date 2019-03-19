package id.or.k4x2.monopoly.entity;

public class Player extends Entity {
    public final static int INITIAL_MONEY = 200;

    private String name;
    private int money;

    public Player(String name) {
        this.name = name;
        this.money = INITIAL_MONEY;
    }
}
