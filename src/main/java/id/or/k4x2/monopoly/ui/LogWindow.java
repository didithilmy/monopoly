package id.or.k4x2.monopoly.ui;

import javax.swing.*;
import java.util.List;

public class LogWindow {
    private JFrame frame;
    private JList logList;
    private JPanel panel;

    public LogWindow(List<String> eventLog) {
        DefaultListModel<String> model = new DefaultListModel<>();
        logList.setModel(model);

        for(String log : eventLog) {
            model.addElement(log);
        }
    }

    public JPanel getPanel() {
        return panel;
    }

    public void show() {
        frame = new JFrame("Event Log");

        frame.setContentPane(getPanel());
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
    }
}
