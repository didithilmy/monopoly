package id.or.k4x2.monopoly.entity;

import java.util.ArrayList;
import java.util.List;

public class Player extends Entity {
    public final static int INITIAL_MONEY = 200;

    private String name;
    private int money;
    private Designation designation;
    private List<Property> properties;

    public Player(String name, Designation designation) {
        this.name = name;
        this.money = INITIAL_MONEY;
        this.designation = designation;
        this.properties = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    /**
     * Deduct money
     * @param nominal nominal
     */
    public void deductMoney(int nominal) {
        money -= nominal;
    }

    /**
     * Add money
     * @param nominal nominal
     */
    public void addMoney(int nominal) {
        money += nominal;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public Designation getDesignation() {
        return designation;
    }

    public enum Designation {
        PLAYER_A(1, 244, 67, 54),   // Red
        PLAYER_B(2, 139, 195, 74),  // Green
        PLAYER_C(3, 251, 192, 45),  // Yellow
        PLAYER_D(4, 3, 169, 244);   // Blue

        private int no, colR, colG, colB;

        Designation(int no, int colR, int colG, int colB) {
            this.no = no;
            this.colR = colR;
            this.colG = colG;
            this.colB = colB;
        }

        public int getNo() {
            return no;
        }

        public int getColR() {
            return colR;
        }

        public int getColG() {
            return colG;
        }

        public int getColB() {
            return colB;
        }
    }
}
