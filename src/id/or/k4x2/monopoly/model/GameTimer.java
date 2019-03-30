package id.or.k4x2.monopoly.model;

/**
 * @author Zalikha Adiera Gambetta/18217027
 */

import java.util.Timer;
import java.util.TimerTask;

public class GameTimer extends TimerTask{
    private static GameTimer ourInstance = new GameTimer();

    public static GameTimer getInstance() {
        return ourInstance;
    }

    private Timer timer;
    private int currtime;
    private TimerListener timerListener;

    private GameTimer() {
        timer = new Timer();
    }

    public void run() {
        currtime--;
        System.out.println(currtime);
        if (currtime == 0) {
            timer.cancel();
            System.out.println("Your turn is over.");
            // TODO KE CONTEXT
            timerListener.onFinish();
        } else {
            timerListener.onTick();
        }
    }

    public void start(int seconds, TimerListener listener) {
        timer.scheduleAtFixedRate(this,1000,1000);
        timerListener = listener;
        currtime = seconds;
    }

    public interface TimerListener {
        // check saat jalan
        public void onTick();

        // check saat sudah selesai
        public void onFinish();
    }
}
