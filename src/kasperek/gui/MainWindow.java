package kasperek.gui;

import javax.swing.*;
import java.awt.*;

/**
 * @author Tomasz Kasperek
 * @version 0.2 02/04/2019
 * @since 0.1
 */

public class MainWindow {
    private JFrame frame;
    private JPanel panel;

    private JCheckBox numbersCheckBox;
    private JCheckBox specialCharactersCheckBox;

    /**
     * Default constructor. It is responsibility for setter all needed parameters for window. Also it is responsibility
     * for call some methods.
     */

    public MainWindow() {
        frame = new JFrame("Password Generator");
        panel = new JPanel();

        panel.setLayout(null);
        panel.setBackground(Color.DARK_GRAY);

        frame.setSize(400, 600);
        frame.setBackground(Color.DARK_GRAY);
        frame.setResizable(false);
        frame.setContentPane(panel);

        windowCenter();
        initialization();

        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    /**
     * The method is responsibility for auto centering the window.
     */

    private void windowCenter() {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
    }

    /**
     * The method is responsibility for calling another methods needed to working the program.
     */

    private void initialization() {
        initializeNumbersCheckBox();
        initializeSpecialCharactersCheckBox();
    }

    private void initializeNumbersCheckBox() {
        numbersCheckBox = new JCheckBox("Use numbers");

        numbersCheckBox.setBounds(80, 125, 430, 20);
        numbersCheckBox.setForeground(Color.LIGHT_GRAY);
        numbersCheckBox.setVisible(true);

        panel.add(numbersCheckBox);
    }

    private void initializeSpecialCharactersCheckBox() {
        specialCharactersCheckBox = new JCheckBox("Use special characters");

        specialCharactersCheckBox.setBounds(80, 150, 430, 20);
        specialCharactersCheckBox.setForeground(Color.LIGHT_GRAY);
        specialCharactersCheckBox.setVisible(true);

        panel.add(specialCharactersCheckBox);
    }
}