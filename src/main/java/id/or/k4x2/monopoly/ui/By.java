package id.or.k4x2.monopoly.ui;

import javax.swing.*;

public class By {
    private JPanel panel1;
    private JPanel NamaNim;
    private JLabel Player;
    private JFrame frame;

    public By (String nama){
        Player.setText(nama);
    }

    public JPanel getPanel(){
        return panel1;
    }

    public void show() {
        frame = new JFrame("Winner");

        frame.setContentPane(getPanel());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(400, 250);
        frame.setLocationRelativeTo(null);
    }

}
