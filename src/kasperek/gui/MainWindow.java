package kasperek.gui;

import javax.swing.*;
import java.awt.*;

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

        windowCenter();
        initialization();

        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void windowCenter() {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
    }

    private void initialization() {
    }
}