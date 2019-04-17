package kasperek.generator.test;

import kasperek.generator.PasswordGenerator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Tomasz Kasperek
 * @version 1.1 04/17/2019
 * @see kasperek.generator.PasswordGenerator
 * @since 1.0
 */

public class PasswordGeneratorTest {
    private static PasswordGenerator password;

    private static String generatedPassword;
    private static String generatedPassword20;
    private static String generatedPassword35;

    /**
     * The method is responsibility for clearing all data after each test.
     */

    @Before
    public void setUpBeforeTest() {
        password = new PasswordGenerator();

        generatedPassword = "";
        generatedPassword20 = "";
        generatedPassword35 = "";
    }

    /**
     * Test <code>shouldGeneratedPassword</code> checks, that the password was generated.
     */

    @Test
    public void shouldGeneratedPassword() {

        // When
        generatedPassword = callGeneratePasswordMethod(false, false, false,
                false, 10);

        // Then
        assertNotNull(generatedPassword);
        assertEquals(10, generatedPassword.length());
    }

    /**
     * Test <code>shouldGeneratedCorrectLengthOfPasswordWithOnlyCharacters</code> checks, that the password have
     * a correct length.
     */

    @Test
    public void shouldGeneratedCorrectLengthOfPasswordWithOnlyCharacters() {

        // When
        generatedPassword = callGeneratePasswordMethod(false, false,
                false, false, 15);
        generatedPassword20 = callGeneratePasswordMethod(false, false,
                true, false, 20);
        generatedPassword35 = callGeneratePasswordMethod(false, false,
                false, true, 35);

        // Then
        assertNotNull(generatedPassword);
        assertNotNull(generatedPassword20);
        assertNotNull(generatedPassword35);
        assertEquals(15, generatedPassword.length());
        assertEquals(20, generatedPassword20.length());
        assertEquals(35, generatedPassword35.length());
    }

    /**
     * Test <code>shouldGeneratedCorrectLengthOfPasswordWithContainsNumbers</code> checks, that the password have
     * a correct length and contains numbers.
     */

    @Test
    public void shouldGeneratedCorrectLengthOfPasswordWithContainsNumbers() {

        // When
        generatedPassword = callGeneratePasswordMethod(true, false,
                false, false, 10);
        generatedPassword20 = callGeneratePasswordMethod(true, false,
                true, false, 20);
        generatedPassword35 = callGeneratePasswordMethod(true, false,
                false, true, 35);

        // Then
        assertNotNull(generatedPassword);
        assertNotNull(generatedPassword20);
        assertNotNull(generatedPassword35);
        assertEquals(10, generatedPassword.length());
        assertEquals(20, generatedPassword20.length());
        assertEquals(35, generatedPassword35.length());
    }

    /**
     * Test <code>shouldGeneratedCorrectLengthOfPasswordWithContainsSpecialCharacters</code> checks, that the password
     * have a correct length and contains special characters.
     */

    @Test
    public void shouldGeneratedCorrectLengthOfPasswordWithContainsSpecialCharacters() {

        // When
        generatedPassword = callGeneratePasswordMethod(false, true,
                false, false, 10);
        generatedPassword20 = callGeneratePasswordMethod(false, true,
                true, false, 20);
        generatedPassword35 = callGeneratePasswordMethod(false, true,
                false, true, 35);

        // Then
        assertNotNull(generatedPassword);
        assertNotNull(generatedPassword20);
        assertNotNull(generatedPassword35);
        assertEquals(10, generatedPassword.length());
        assertEquals(20, generatedPassword20.length());
        assertEquals(35, generatedPassword35.length());
    }

    /**
     * Test <code>shouldGeneratedCorrectLengthOfPasswordWithContainsNumbersAndSpecialCharacters</code> checks, that
     * the password have a correct length and contains numbers and special characters.
     */

    @Test
    public void shouldGeneratedCorrectLengthOfPasswordWithContainsNumbersAndSpecialCharacters() {

        // When
        generatedPassword = callGeneratePasswordMethod(true, true,
                false, false, 10);
        generatedPassword20 = callGeneratePasswordMethod(true, true,
                true, false, 20);
        generatedPassword35 = callGeneratePasswordMethod(true, true,
                false, true, 35);

        // Then
        assertNotNull(generatedPassword);
        assertNotNull(generatedPassword20);
        assertNotNull(generatedPassword35);
        assertEquals(10, generatedPassword.length());
        assertEquals(20, generatedPassword20.length());
        assertEquals(35, generatedPassword35.length());
    }

    /**
     * Test <code>shouldHaveLowercaseLetters</code> checks, that the password have only small letters.
     */

    @Test
    public void shouldHaveLowercaseLetters() {

        // When
        generatedPassword = callGeneratePasswordMethod(false, false, true,
                false, 10);

        // Then
        assertTrue(isLowercaseOrUppercase(generatedPassword, true));
        assertFalse(isLowercaseOrUppercase(generatedPassword, false));

    }

    /**
     * Test <code>shouldHaveUppercaseLetters</code> checks, that the password have only big letters.
     */

    @Test
    public void shouldHaveUppercaseLetters() {

        // When
        generatedPassword = callGeneratePasswordMethod(false, false, false,
                true, 10);

        // Then
        assertFalse(isLowercaseOrUppercase(generatedPassword, true));
        assertTrue(isLowercaseOrUppercase(generatedPassword, false));
    }

    /**
     * Test <code>shouldHaveLowercaseAndUppercaseLetters</code> checks, that the password have small and big letters.
     */

    @Test
    public void shouldHaveLowercaseAndUppercaseLetters() {

        // When
        generatedPassword = callGeneratePasswordMethod(false, false, false,
                false, 10);

        // Then
        assertTrue(isLowercaseOrUppercase(generatedPassword, true));
        assertTrue(isLowercaseOrUppercase(generatedPassword, false));
    }

    /**
     * Test <code>shouldHaveLowercaseLettersAndNumbers</code> checks, that the password have only small letters
     * and contains numbers.
     */

    @Test
    public void shouldHaveLowercaseLettersAndNumbers() {

        // When
        generatedPassword = callGeneratePasswordMethod(true, false, true,
                false, 10);

        // Then
        assertTrue(isLowercaseOrUppercase(generatedPassword, true));
        assertFalse(isLowercaseOrUppercase(generatedPassword, false));
        assertTrue(containNumbers(generatedPassword));
        assertFalse(containSpecialCharacters(generatedPassword));
    }

    /**
     * Test <code>shouldHaveLowercaseLettersAndSpecialCharacters</code> checks, that the password have only small letters
     * and contains special characters.
     */

    @Test
    public void shouldHaveLowercaseLettersAndSpecialCharacters() {

        // When
        generatedPassword = callGeneratePasswordMethod(false, true, true,
                false, 10);

        // Then
        assertTrue(isLowercaseOrUppercase(generatedPassword, true));
        assertFalse(isLowercaseOrUppercase(generatedPassword, false));
        assertFalse(containNumbers(generatedPassword));
        assertTrue(containSpecialCharacters(generatedPassword));
    }

    /**
     * Test <code>shouldHaveLowercaseLettersAndNumbersAndSpecialCharacters</code> checks, that the password have only
     * small letters and contains numbers and special characters.
     */

    @Test
    public void shouldHaveLowercaseLettersAndNumbersAndSpecialCharacters() {

        // When
        generatedPassword = callGeneratePasswordMethod(true, true, true,
                false, 10);

        // Then
        assertTrue(containSpecialCharacters(generatedPassword));
        assertTrue(isLowercaseOrUppercase(generatedPassword, true));
        assertTrue(containNumbers(generatedPassword));
        assertFalse(isLowercaseOrUppercase(generatedPassword, false));
    }

    /**
     * Test <code>shouldHaveUppercaseLettersAndNumbers</code> checks, that the password have only big letters and contains
     * numbers.
     */

    @Test
    public void shouldHaveUppercaseLettersAndNumbers() {

        // When
        generatedPassword = callGeneratePasswordMethod(true, false, false,
                true, 10);

        // Then
        assertTrue(containNumbers(generatedPassword));
        assertTrue(isLowercaseOrUppercase(generatedPassword, false));
        assertFalse(isLowercaseOrUppercase(generatedPassword, true));
        assertFalse(containSpecialCharacters(generatedPassword));
    }

    /**
     * Test <code>shouldHaveUppercaseLettersAndSpecialCharacters</code> checks, that the password have only big letters
     * and contains special characters.
     */

    @Test
    public void shouldHaveUppercaseLettersAndSpecialCharacters() {

        // When
        generatedPassword = callGeneratePasswordMethod(false, true, false,
                true, 10);

        // Then
        assertTrue(containSpecialCharacters(generatedPassword));
        assertTrue(isLowercaseOrUppercase(generatedPassword, false));
        assertFalse(isLowercaseOrUppercase(generatedPassword, true));
        assertFalse(containNumbers(generatedPassword));
    }

    /**
     * Test <code>shouldHaveUppercaseLettersAndNumbersAndSpecialCharacters</code> checks, that the password have only
     * big letters and contains numbers and special characters.
     */

    @Test
    public void shouldHaveUppercaseLettersAndNumbersAndSpecialCharacters() {

        // When
        generatedPassword = callGeneratePasswordMethod(true, true, false,
                true, 10);

        // Then
        assertTrue(containSpecialCharacters(generatedPassword));
        assertTrue(isLowercaseOrUppercase(generatedPassword, false));
        assertTrue(containNumbers(generatedPassword));
        assertFalse(isLowercaseOrUppercase(generatedPassword, true));
    }

    /**
     * Test <code>shouldHaveLowercaseAndUppercaseLettersAndNumbers</code> checks, that the password have small and big letters
     * and contains numbers.
     */

    @Test
    public void shouldHaveLowercaseAndUppercaseLettersAndNumbers() {

        // When
        generatedPassword = callGeneratePasswordMethod(true, false, false,
                false, 10);

        // Then
        assertTrue(containNumbers(generatedPassword));
        assertTrue(isLowercaseOrUppercase(generatedPassword, true));
        assertTrue(isLowercaseOrUppercase(generatedPassword, false));
        assertFalse(containSpecialCharacters(generatedPassword));
    }

    /**
     * Test <code>shouldHaveLowercaseAndUppercaseLettersAndSpecialCharacters</code> checks, that the password have small and
     * big letters and contains special characters.
     */

    @Test
    public void shouldHaveLowercaseAndUppercaseLettersAndSpecialCharacters() {

        // When
        generatedPassword = callGeneratePasswordMethod(false, true, false,
                false, 10);

        // Then
        assertTrue(containSpecialCharacters(generatedPassword));
        assertTrue(isLowercaseOrUppercase(generatedPassword, true));
        assertTrue(isLowercaseOrUppercase(generatedPassword, false));
        assertFalse(containNumbers(generatedPassword));
    }

    /**
     * Test <code>shouldHaveLowercaseAndUppercaseLettersAndNumbersAndSpecialCharacters</code> checks, that the password have small
     * and big letters and contains numbers and special characters.
     */

    @Test
    public void shouldHaveLowercaseAndUppercaseLettersAndNumbersAndSpecialCharacters() {

        // When
        generatedPassword = callGeneratePasswordMethod(true, true, false,
                false, 10);

        // Then
        assertTrue(containSpecialCharacters(generatedPassword));
        assertTrue(isLowercaseOrUppercase(generatedPassword, true));
        assertTrue(isLowercaseOrUppercase(generatedPassword, false));
        assertTrue(containNumbers(generatedPassword));
    }

    /**
     * The method that calls the code generating method.
     * The method was created in order to minimize the repetition of the code.
     *
     * @param useNumbers           the password will contain numbers.
     * @param useSpecialCharacters the password will contain special characters.
     * @param useSmallLetters      the password will contain lowercase letters.
     * @param useBigLetters        the password will contain uppercase letters.
     * @param length               the password length.
     * @return the generated password.
     */

    private String callGeneratePasswordMethod(boolean useNumbers, boolean useSpecialCharacters, boolean useSmallLetters,
                                              boolean useBigLetters, int length) {
        return password.generatedPassword(useNumbers, useSpecialCharacters, useSmallLetters, useBigLetters, length);
    }

    /**
     * The method checks that the password contains special characters.
     * The method was created in order to minimize the repetition of the code.
     *
     * @param text the password to check.
     * @return is the password contain special characters.
     */

    private boolean containSpecialCharacters(String text) {
        final String[] specialCharactersList = {"!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "_", "+", "=",
                ",", ".", "<", ">", "?", ":", ";", "'", "[", "]", "{", "}", "`", "~"};

        boolean containSpecialCharacters = false;

        for (String specialChar : specialCharactersList) {
            containSpecialCharacters = text.contains(specialChar);

            if (containSpecialCharacters)
                break;
        }

        return containSpecialCharacters;
    }

    /**
     * The method checks that the password contains numbers.
     * The method was created in order to minimize the repetition of the code.
     *
     * @param text the password to check.
     * @return is the password contain numbers.
     */

    private boolean containNumbers(String text) {
        boolean containNumbers = false;

        for (int i = 0; i < text.length(); i++) {
            containNumbers = text.contains(String.valueOf(i));

            if (containNumbers)
                break;
        }

        return containNumbers;
    }

    /**
     * The method checks that the password contains lowercase or uppercase letters.
     * The method was created in order to minimize the repetition of the code.
     *
     * @param text      the password to check.
     * @param lowercase is the password should have lowercase letters.
     * @return is the password contain lowercase or uppercase letters.
     */

    private boolean isLowercaseOrUppercase(String text, boolean lowercase) {
        boolean goodCaseSize;

        if (lowercase)
            goodCaseSize = !text.equals(text.toUpperCase());
        else
            goodCaseSize = !text.equals(text.toLowerCase());

        return goodCaseSize;
    }
}