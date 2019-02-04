package kasperek.gui;

import javax.swing.*;
import java.awt.*;

/**
 * @author Tomasz Kasperek
 * @version 0.3 02/04/2019
 * @since 0.1
 */

public class MainWindow {
    private JFrame frame;
    private JPanel panel;

    private JCheckBox numbersCheckBox;
    private JCheckBox specialCharactersCheckBox;

    private JRadioButton smallLettersRadioButton;
    private JRadioButton bigLettersRadioButton;
    private JRadioButton smallAndBigLettersRadioButton;
    private ButtonGroup radioButtonLettersGroup;

    /**
     * Default constructor. It is responsibility for setter all needed parameters for window. Also it is responsibility
     * for call some methods.
     */

    public MainWindow() {
        frame = new JFrame("Password Generator");
        panel = new JPanel();
        radioButtonLettersGroup = new ButtonGroup();

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
        initializeSmallLettersRadioButton();
        initializeBigLettersRadioButton();
        initializeSmallAndBigLettersRadioButton();
    }

    /**
     * The method is responsibility for creating checkbox to choose to create the password with numbers.
     */

    private void initializeNumbersCheckBox() {
        numbersCheckBox = new JCheckBox("Use numbers");

        numbersCheckBox.setBounds(80, 125, 430, 20);
        numbersCheckBox.setForeground(Color.LIGHT_GRAY);
        numbersCheckBox.setVisible(true);

        panel.add(numbersCheckBox);
    }

    /**
     * The method is responsibility for creating checkbox to choose to create the password with special characters.
     */

    private void initializeSpecialCharactersCheckBox() {
        specialCharactersCheckBox = new JCheckBox("Use special characters");

        specialCharactersCheckBox.setBounds(80, 150, 430, 20);
        specialCharactersCheckBox.setForeground(Color.LIGHT_GRAY);
        specialCharactersCheckBox.setVisible(true);

        panel.add(specialCharactersCheckBox);
    }

    /**
     * The method is responsibility for creating radio button to choose to create the password with only small letters.
     */

    private void initializeSmallLettersRadioButton() {
        smallLettersRadioButton = new JRadioButton("Use only small letters");

        smallLettersRadioButton.setBounds(80, 175, 430, 20);
        smallLettersRadioButton.setForeground(Color.LIGHT_GRAY);
        smallLettersRadioButton.setSelected(true);
        smallLettersRadioButton.setVisible(true);

        radioButtonLettersGroup.add(smallLettersRadioButton);
        panel.add(smallLettersRadioButton);
    }

    /**
     * The method is responsibility for creating radio button to choose to create the password with only big letters.
     */

    private void initializeBigLettersRadioButton() {
        bigLettersRadioButton = new JRadioButton("Use only big letters");

        bigLettersRadioButton.setBounds(80, 200, 430, 20);
        bigLettersRadioButton.setForeground(Color.LIGHT_GRAY);
        bigLettersRadioButton.setVisible(true);

        radioButtonLettersGroup.add(bigLettersRadioButton);
        panel.add(bigLettersRadioButton);
    }

    /**
     * The method is responsibility for creating radio button to choose to create the password with small
     * and big letters.
     */

    private void initializeSmallAndBigLettersRadioButton() {
        smallAndBigLettersRadioButton = new JRadioButton("Use small and big letters");

        smallAndBigLettersRadioButton.setBounds(80, 225, 430, 20);
        smallAndBigLettersRadioButton.setForeground(Color.LIGHT_GRAY);
        smallAndBigLettersRadioButton.setVisible(true);

        radioButtonLettersGroup.add(smallAndBigLettersRadioButton);
        panel.add(smallAndBigLettersRadioButton);
    }
}