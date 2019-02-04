package kasperek.gui;

import javax.swing.*;

public class MainWindow {
    private JFrame frame;
    private JPanel panel;

    public MainWindow() {
        frame = new JFrame("Password Generator");
        panel = new JPanel();

        panel.setLayout(null);

        frame.setSize(400, 600);
        frame.setResizable(false);
        frame.setContentPane(panel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}