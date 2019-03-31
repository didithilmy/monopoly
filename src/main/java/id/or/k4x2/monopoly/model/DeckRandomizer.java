package id.or.k4x2.monopoly.model;

import java.util.Random;
/**
 * Randomize deck of something
 * @author Muhammad Yanza Hattari/18217043
 */


public class DeckRandomizer<K> {
    private K[] key;

    public DeckRandomizer(K[] key){
        this.key=key;
    }

    public void setKey(K[] key) {
        this.key = key;
    }

    public K randomize() {
        Random rand = new Random();
        int n = rand.nextInt(key.length-1);
        return key[n];
    }


}
