package id.or.k4x2.monopoly;

import id.or.k4x2.monopoly.entity.Player;
import id.or.k4x2.monopoly.ui.GameWindow;
import id.or.k4x2.monopoly.ui.WelcomeWindow;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        GameWindow gameWindow = new GameWindow();
        WelcomeWindow welcomeWindow = new WelcomeWindow(new WelcomeWindow.WelcomeListener() {
            @Override
            public void onPlayerEntered(List<Player> players) {
                gameWindow.show(players);
            }
        });

        welcomeWindow.show();
    }
}
