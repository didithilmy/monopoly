package id.or.k4x2.monopoly.model;

/**
 * @author Zalikha Adiera Gambetta/18217027
 */

import java.util.Timer;
import java.util.TimerTask;

public class GameTimer {
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

    public void start(int seconds, TimerListener listener) {
        timer = new Timer();

        timerListener = listener;
        currtime = seconds;

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                currtime--;
                if (currtime == 0) {
                    this.cancel();
                    timerListener.onFinish();
                } else {
                    timerListener.onTick(currtime);
                }
            }
        }, 1000, 1000);

        listener.onStart(currtime);
    }

    public void stop() {
        try {
            timer.cancel();
        } catch (Exception e) {
            // Do nothing
        }
    }

    public interface TimerListener {
        public void onStart(int timeLeft);

        // check saat jalan
        public void onTick(int timeLeft);

        // check saat sudah selesai
        public void onFinish();
    }
}
