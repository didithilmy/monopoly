package id.or.k4x2.monopoly.entity;

public class Dice {
    private int die1, die2;

    public Dice() {
        shuffle();
    }

    public int getDie1() {
        return die1;
    }

    public int getDie2() {
        return die2;
    }

    public int getSum() {
        return die1 + die2;
    }

    public boolean isDoubleDice() {
        return die1 == die2;
    }

    public void shuffle() {
        die1 = 	(int)(Math.random() * ((6 - 1) + 1)) + 1;
        die2 = 	(int)(Math.random() * ((6 - 1) + 1)) + 1;
    }
}
