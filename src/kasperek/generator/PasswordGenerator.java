package kasperek.generator;

import java.util.Random;

/**
 * @author Tomasz Kasperek
 * @version 0.2 02/05/2019
 * @see kasperek.gui.MainWindow
 * @since 0.1
 */

public class PasswordGenerator {
    private String letters;
    private String specialCharacters;
    private String numbers;
    private Random random;

    /**
     * Default constructor. It is responsibility for setter all needed parameters for generator. Also it is responsibility
     * for call some methods.
     */

    public PasswordGenerator() {
        random = new Random();

        letters = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
        specialCharacters = "!@#$%^&*()_-+=,.<>?:;'\"[]{}`~";
        numbers = "0123456789";
    }

    private char generateLetter() {
        return letters.charAt(random.nextInt(letters.length()));
    }

    private char generateNumber() {
        return numbers.charAt(random.nextInt(numbers.length()));
    }

    private char generateSpecialCharacter() {
        return specialCharacters.charAt(random.nextInt(specialCharacters.length()));
    }
}