package kasperek.generator;

import java.util.Random;

/**
 * @author Tomasz Kasperek
 * @version 1.1 02/08/2019
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
        specialCharacters = "!@#$%^&*()_+=,.<>?:;'[]{}`~";
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

        for (int i = length; i > 0; i--) {
            generatedPassword.append(generateLetter());
        }

        if (useNumbers && useSpecialCharacters)
            generatedPassword.replace(0, length + 1, addNumbersAndSpecialCharactersToPassword(generatedPassword, length));
        else if (useNumbers)
            generatedPassword.replace(0, length + 1, addNumbersToPassword(generatedPassword, length));
        else if (useSpecialCharacters)
            generatedPassword.replace(0, length + 1, addSpecialCharactersToPassword(generatedPassword, length));

        if (useSmallLetters)
            generatedPassword.replace(0, length + 1, generatedPassword.toString().toLowerCase());
        else if (useBigLetters)
            generatedPassword.replace(0, length + 1, generatedPassword.toString().toUpperCase());

        return generatedPassword.toString();
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

    /**
     * The method add to password some numbers (if the user want to have numbers in password).
     *
     * @param password the generated password.
     * @param length   the password length.
     * @return the password with numbers.
     */

    private String addNumbersToPassword(StringBuilder password, int length) {
        int minValue = 1;
        int range = length - minValue + 1;
        int x;

        for (int i = 1; i < length / 2; i++) {
            x = (int)(Math.random() * range) + minValue;
            password.replace(x, x + 1, String.valueOf(generateNumber()));
        }

        return password.toString();
    }

    /**
     * The method add to password some special characters (if the user want to have special characters in password).
     *
     * @param password the generated password.
     * @param length   the password length.
     * @return the password with special characters.
     */

    private String addSpecialCharactersToPassword(StringBuilder password, int length) {
        int minValue = 1;
        int range = length - minValue + 1;
        int x;

        for (int i = 1; i < length / 2; i++) {
            x = (int)(Math.random() * range) + minValue;
            password.replace(x, x + 1, String.valueOf(generateSpecialCharacter()));
        }

        return password.toString();
    }

    /**
     * The method add to password some numbers and special characters
     * (if the user want to have numbers and special characters in password).
     *
     * @param password the generated password.
     * @param length   the password length.
     * @return the password with numbers and special characters.
     */

    private String addNumbersAndSpecialCharactersToPassword(StringBuilder password, int length) {
        int minValue = 1;
        int range = length - minValue + 1;
        int x;
        int y;

        for (int i = 0; i < length / 2; i++) {
            y = (int)(Math.random() * range) + minValue;
            x = (int)(Math.random() * range) + minValue;

            while (x == y)
                x = (int)(Math.random() * range) + minValue;

            password.replace(x, x + 1, String.valueOf(generateNumber()));
            password.replace(y, y + 1, String.valueOf(generateSpecialCharacter()));
        }

        return password.toString();
    }
}