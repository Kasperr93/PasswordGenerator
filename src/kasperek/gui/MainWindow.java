package kasperek.gui;

import kasperek.generator.PasswordGenerator;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @author Tomasz Kasperek
 * @version 1.2 02/08/2019
 * @see kasperek.generator.PasswordGenerator
 * @since 0.1
 */

public class MainWindow {
    private JFrame frame;
    private JPanel panel;

    private final int ELEMENT_HEIGHT = 20;
    private final int ELEMENT_WIDTH = 430;
    private final int ELEMENT_X_POSITION = 100;

    private JLabel titleLabel;
    private JLabel passwordLengthLabel;
    private JLabel lengthLabel;

    private JCheckBox numbersCheckBox;
    private JCheckBox specialCharactersCheckBox;

    private JRadioButton smallLettersRadioButton;
    private JRadioButton bigLettersRadioButton;
    private JRadioButton smallAndBigLettersRadioButton;
    private ButtonGroup radioButtonLettersGroup;

    private JSlider passwordLengthSlider;
    private JTextField generatedPasswordTextField;

    private PasswordGenerator passwordGenerator;

    /**
     * Default constructor. It is responsibility for setter all needed parameters for window. Also it is responsibility
     * for call some methods.
     */

    public MainWindow() {
        frame = new JFrame("Password Generator");
        panel = new JPanel();
        radioButtonLettersGroup = new ButtonGroup();
        passwordGenerator = new PasswordGenerator();

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
     * The method is responsibility for the auto centering the window.
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
        initializeTitleLabel();
        initializeNumbersCheckBox();
        initializeSpecialCharactersCheckBox();
        initializeSmallLettersRadioButton();
        initializeBigLettersRadioButton();
        initializeSmallAndBigLettersRadioButton();
        initializePasswordLengthSlider();
        initializeGeneratedPasswordTextField();
        initializeGenerateButton();
        changeWindowTheme();
    }

    /**
     * The method shows the title label.
     */

    private void initializeTitleLabel() {
        titleLabel = new JLabel("Make your strong password!");
        titleLabel.setBounds(45, 30, ELEMENT_WIDTH, 40);
        titleLabel.setForeground(Color.LIGHT_GRAY);
        titleLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
        titleLabel.setVisible(true);

        panel.add(titleLabel);
    }

    /**
     * The method is responsibility for creating the checkbox to choose to create the password with numbers.
     */

    private void initializeNumbersCheckBox() {
        numbersCheckBox = new JCheckBox("Use numbers");

        numbersCheckBox.setBounds(ELEMENT_X_POSITION, 100, ELEMENT_WIDTH, ELEMENT_HEIGHT);
        numbersCheckBox.setForeground(Color.LIGHT_GRAY);
        numbersCheckBox.setVisible(true);

        panel.add(numbersCheckBox);
    }

    /**
     * The method is responsibility for creating the checkbox to choose to create the password with special characters.
     */

    private void initializeSpecialCharactersCheckBox() {
        specialCharactersCheckBox = new JCheckBox("Use special characters");

        specialCharactersCheckBox.setBounds(ELEMENT_X_POSITION, 125, ELEMENT_WIDTH, ELEMENT_HEIGHT);
        specialCharactersCheckBox.setForeground(Color.LIGHT_GRAY);
        specialCharactersCheckBox.setVisible(true);

        panel.add(specialCharactersCheckBox);
    }

    /**
     * The method is responsibility for creating the radio button to choose to create the password with only small letters.
     */

    private void initializeSmallLettersRadioButton() {
        smallLettersRadioButton = new JRadioButton("Use only small letters");

        smallLettersRadioButton.setBounds(ELEMENT_X_POSITION, 150, ELEMENT_WIDTH, ELEMENT_HEIGHT);
        smallLettersRadioButton.setForeground(Color.LIGHT_GRAY);
        smallLettersRadioButton.setSelected(true);
        smallLettersRadioButton.setVisible(true);

        radioButtonLettersGroup.add(smallLettersRadioButton);
        panel.add(smallLettersRadioButton);
    }

    /**
     * The method is responsibility for creating the radio button to choose to create the password with only big letters.
     */

    private void initializeBigLettersRadioButton() {
        bigLettersRadioButton = new JRadioButton("Use only big letters");

        bigLettersRadioButton.setBounds(ELEMENT_X_POSITION, 175, ELEMENT_WIDTH, ELEMENT_HEIGHT);
        bigLettersRadioButton.setForeground(Color.LIGHT_GRAY);
        bigLettersRadioButton.setVisible(true);

        radioButtonLettersGroup.add(bigLettersRadioButton);
        panel.add(bigLettersRadioButton);
    }

    /**
     * The method is responsibility for creating the radio button to choose to create the password with small
     * and big letters.
     */

    private void initializeSmallAndBigLettersRadioButton() {
        smallAndBigLettersRadioButton = new JRadioButton("Use small and big letters");

        smallAndBigLettersRadioButton.setBounds(ELEMENT_X_POSITION, 200, ELEMENT_WIDTH, ELEMENT_HEIGHT);
        smallAndBigLettersRadioButton.setForeground(Color.LIGHT_GRAY);
        smallAndBigLettersRadioButton.setVisible(true);

        radioButtonLettersGroup.add(smallAndBigLettersRadioButton);
        panel.add(smallAndBigLettersRadioButton);
    }

    /**
     * The method is responsibility for password length via slider.
     */

    private void initializePasswordLengthSlider() {
        passwordLengthSlider = new JSlider(8, 64, 16);
        passwordLengthLabel = new JLabel("Password length");
        lengthLabel = new JLabel(String.valueOf(passwordLengthSlider.getValue()));

        passwordLengthSlider.setBounds(10, 285, 360, ELEMENT_HEIGHT);
        passwordLengthSlider.setPaintTicks(true);
        passwordLengthSlider.setPaintLabels(true);
        passwordLengthSlider.setMinorTickSpacing(8);
        passwordLengthSlider.addChangeListener(e -> lengthLabel.setText(String.valueOf(passwordLengthSlider.getValue())));
        passwordLengthSlider.setVisible(true);

        passwordLengthLabel.setBounds(20, 255, ELEMENT_WIDTH, ELEMENT_HEIGHT);
        passwordLengthLabel.setForeground(Color.LIGHT_GRAY);
        passwordLengthLabel.setVisible(true);

        lengthLabel.setBounds(370, 280, 20, ELEMENT_HEIGHT);
        lengthLabel.setForeground(Color.LIGHT_GRAY);
        lengthLabel.setVisible(true);

        panel.add(passwordLengthSlider);
        panel.add(passwordLengthLabel);
        panel.add(lengthLabel);
    }

    /**
     * The method shows the text field with the generated password. After the click in text field, the password will
     * be copied to clipboard.
     */

    private void initializeGeneratedPasswordTextField() {
        generatedPasswordTextField = new JTextField();

        generatedPasswordTextField.setBounds(10, 360, 380, ELEMENT_HEIGHT);
        generatedPasswordTextField.setBackground(Color.LIGHT_GRAY);
        generatedPasswordTextField.setForeground(Color.DARK_GRAY);
        generatedPasswordTextField.setEditable(false);
        generatedPasswordTextField.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                StringSelection stringSelection = new StringSelection(generatedPasswordTextField.getText());
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

                clipboard.setContents(stringSelection, null);
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        generatedPasswordTextField.setVisible(true);

        panel.add(generatedPasswordTextField);
    }

    /**
     * The method shows the button to generate a password.
     */

    private void initializeGenerateButton() {
        JButton generateButton = new JButton("Generate password");

        generateButton.setBounds(100, 395, 200, 35);
        generateButton.setForeground(Color.DARK_GRAY);
        generateButton.addActionListener(e -> {
            String password = passwordGenerator.generatedPassword(numbersCheckBox.isSelected(),
                    specialCharactersCheckBox.isSelected(), smallLettersRadioButton.isSelected(),
                    bigLettersRadioButton.isSelected(), passwordLengthSlider.getValue());

            generatedPasswordTextField.setText(password);
        });
        generateButton.setVisible(true);

        panel.add(generateButton);
    }

    /**
     * The method responsibility for the change theme color.
     */

    private void changeWindowTheme() {
        JToggleButton toggleButton = new JToggleButton("Change to light theme");

        ItemListener itemListener = itemEvent -> {
            int state = itemEvent.getStateChange();

            if (state == ItemEvent.SELECTED) {
                toggleButton.setText("Change to dark theme");
                frame.setBackground(Color.LIGHT_GRAY);
                panel.setBackground(Color.LIGHT_GRAY);
                titleLabel.setForeground(Color.DARK_GRAY);
                numbersCheckBox.setForeground(Color.DARK_GRAY);
                specialCharactersCheckBox.setForeground(Color.DARK_GRAY);
                smallLettersRadioButton.setForeground(Color.DARK_GRAY);
                bigLettersRadioButton.setForeground(Color.DARK_GRAY);
                smallAndBigLettersRadioButton.setForeground(Color.DARK_GRAY);
                passwordLengthLabel.setForeground(Color.DARK_GRAY);
                lengthLabel.setForeground(Color.DARK_GRAY);
                generatedPasswordTextField.setBackground(Color.GRAY);
                generatedPasswordTextField.setForeground(Color.LIGHT_GRAY);
            } else {
                toggleButton.setText("Change to light theme");
                frame.setBackground(Color.DARK_GRAY);
                panel.setBackground(Color.DARK_GRAY);
                titleLabel.setForeground(Color.LIGHT_GRAY);
                numbersCheckBox.setForeground(Color.LIGHT_GRAY);
                specialCharactersCheckBox.setForeground(Color.LIGHT_GRAY);
                smallLettersRadioButton.setForeground(Color.LIGHT_GRAY);
                bigLettersRadioButton.setForeground(Color.LIGHT_GRAY);
                smallAndBigLettersRadioButton.setForeground(Color.LIGHT_GRAY);
                passwordLengthLabel.setForeground(Color.LIGHT_GRAY);
                lengthLabel.setForeground(Color.LIGHT_GRAY);
                generatedPasswordTextField.setBackground(Color.LIGHT_GRAY);
                generatedPasswordTextField.setForeground(Color.DARK_GRAY);
            }
        };

        toggleButton.setBounds(10, 550, 200, 20);
        toggleButton.addItemListener(itemListener);
        toggleButton.setVisible(true);

        panel.add(toggleButton);
    }
}