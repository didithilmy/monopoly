package id.or.k4x2.monopoly.ui;
/**
 * welcoming window
 * @author Muhammad Yanza Hattari/18217043
 */


import javax.swing.*;

public class WelcomeWindow {
    private JCheckBox lesgoWakgengCheckBox;
    private JCheckBox lesgoWakgengCheckBox1;
    private JCheckBox lesgoWakgengCheckBox4;
    private JCheckBox lesgoWakgengCheckBox3;
    private JTextField playerName1TextField;
    private JTextField playerName2TextField;
    private JTextField playerName3TextField;
    private JTextField playerName4TextField;
    private JButton mainkanButton;
    private JPanel panel;

    private void createUIComponents() {
        // TODO: place custom component creation code here

    }

    public WelcomeWindow(){
        super();
    }


    public JCheckBox getLesgoWakgengCheckBox() {
        return lesgoWakgengCheckBox;
    }

    public JCheckBox getLesgoWakgengCheckBox1() {
        return lesgoWakgengCheckBox1;
    }

    public JCheckBox getLesgoWakgengCheckBox4() {
        return lesgoWakgengCheckBox4;
    }

    public JCheckBox getLesgoWakgengCheckBox3() {
        return lesgoWakgengCheckBox3;
    }

    public JTextField getPlayerName1TextField() {
        return playerName1TextField;
    }

    public JTextField getPlayerName2TextField() {
        return playerName2TextField;
    }

    public JTextField getPlayerName3TextField() {
        return playerName3TextField;
    }

    public JTextField getPlayerName4TextField() {
        return playerName4TextField;
    }

    public JButton getMainkanButton() {
        return mainkanButton;
    }

    public JPanel getPanel() {
        return panel;
    }

   /* public static void main (String[] args){
        JFrame frame = new JFrame("Engi's Monopoly");

        WelcomeWindow welcomeWindow =new WelcomeWindow();
        frame.setContentPane(welcomeWindow.getPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(600, 400);
    } */


}
