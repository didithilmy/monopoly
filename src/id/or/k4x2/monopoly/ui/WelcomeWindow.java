package id.or.k4x2.monopoly.ui;
/**
 * welcoming window
 * @author Muhammad Yanza Hattari/18217043
 */


import id.or.k4x2.monopoly.entity.Player;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class WelcomeWindow {
    private WelcomeListener listener;
    private List<Player> players;
    JFrame frame;

    private JCheckBox checkPlay1;
    private JCheckBox checkPlay2;
    private JCheckBox checkPlay3;
    private JCheckBox checkPlay4;
    private JTextField txtName1;
    private JTextField txtName2;
    private JTextField txtName3;
    private JTextField txtName4;
    private JButton btnPlay;
    private JPanel panel;

    public WelcomeWindow(WelcomeListener listener){
        super();
        this.listener = listener;
        players = new ArrayList<>();

        btnPlay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(checkPlay1.isSelected()) {
                    Player p = new Player(txtName1.getText(), Player.Designation.PLAYER_A);
                    players.add(p);
                }

                if(checkPlay2.isSelected()) {
                    Player p = new Player(txtName2.getText(), Player.Designation.PLAYER_B);
                    players.add(p);
                }

                if(checkPlay3.isSelected()) {
                    Player p = new Player(txtName3.getText(), Player.Designation.PLAYER_C);
                    players.add(p);
                }

                if(checkPlay4.isSelected()) {
                    Player p = new Player(txtName4.getText(), Player.Designation.PLAYER_D);
                    players.add(p);
                }

                if(players.size() >= 2 && players.size() <= 4) {
                    frame.dispose();
                    listener.onPlayerEntered(players);
                } else {
                    JOptionPane.showMessageDialog(null, "Minimal dua pemain dan maksimal empat pemain", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public JPanel getPanel() {
        return panel;
    }

    public void show() {
        frame = new JFrame("Engi's Monopoly");

        frame.setContentPane(getPanel());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
    }

   public interface WelcomeListener {
       public void onPlayerEntered(List<Player> players);
   }
}
