package kasperek.generator;

import java.util.Random;

/**
 * @author Tomasz Kasperek
 * @version 0.4 02/07/2019
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

    /**
     * The method generating the password with user preferences.
     *
     * @param useNumbers           the password will contain numbers.
     * @param useSpecialCharacters the password will contain special characters.
     * @param useSmallLetters      the password will only have lowercase letters.
     * @param useBigLetters        the password will only have uppercase letters.
     * @param length               the password length (can be from 8 to 64 characters).
     * @return the generated password.
     */

    public String generatedPassword(boolean useNumbers, boolean useSpecialCharacters, boolean useSmallLetters, boolean useBigLetters, int length) {
        StringBuilder generatedPassword = new StringBuilder();
        int number;

        for (int i = length; i > 0; i--) {
            number = random.nextInt(100);

            if (number >= 0 && number < 25 && useNumbers) {
                generatedPassword.append(generateNumber());
            } else if (number >= 25 && number < 40 && useSpecialCharacters) {
                generatedPassword.append(generateSpecialCharacter());
            } else {
                generatedPassword.append(generateLetter());
            }
        }

        if (useSmallLetters) {
            return generatedPassword.toString().toLowerCase();
        } else if (useBigLetters) {
            return generatedPassword.toString().toUpperCase();
        } else {
            return generatedPassword.toString();
        }
    }

    /**
     * The method draw lots a single character (can be from a-z to A-Z characters).
     *
     * @return the random character.
     */

    private char generateLetter() {
        return letters.charAt(random.nextInt(letters.length()));
    }

    /**
     * The method draw lots a single number (can be from 0 to 9 characters).
     *
     * @return the random number.
     */

    private char generateNumber() {
        return numbers.charAt(random.nextInt(numbers.length()));
    }

    /**
     * The method draw lots a single special character.
     *
     * @return the random special character.
     */

    private char generateSpecialCharacter() {
        return specialCharacters.charAt(random.nextInt(specialCharacters.length()));
    }
}