package kasperek.tests;

import kasperek.generator.PasswordGenerator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Tomasz Kasperek
 * @version 1.0 02/08/2019
 * @see kasperek.generator.PasswordGenerator
 * @since 1.0
 */

public class PasswordGeneratorTest {
    private static PasswordGenerator password;

    private final int length10 = 10;
    private final int length20 = 20;
    private final int length35 = 35;

    private static boolean useNumbers;
    private static boolean useSpecialCharacters;
    private static boolean useSmallLetters;
    private static boolean useBigLetters;
    private static boolean containNumbers;
    private static boolean containSpecialCharacters;
    private static boolean hasUppercase;
    private static boolean hasLowercase;

    private static String generatedPassword;
    private static final String[] specialCharacters = {"!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "_", "+", "=",
            ",", ".", "<", ">", "?", ":", ";", "'", "[", "]", "{", "}", "`", "~"};

    /**
     * The method is responsibility for clearing all data after each test.
     */

    @Before
    public void setUpBeforeTest() {
        password = new PasswordGenerator();

        useNumbers = false;
        useSpecialCharacters = false;
        useSmallLetters = false;
        useBigLetters = false;
        containNumbers = false;
        containSpecialCharacters = false;
        hasUppercase = false;
        hasLowercase = false;

        generatedPassword = "";
    }

    /**
     * Test <code>shouldGeneratedPassword</code> checks, that the password was generated.
     */

    @Test
    public void shouldGeneratedPassword() {

        // When
        generatedPassword = password.generatedPassword(useNumbers, useSpecialCharacters, useSmallLetters, useBigLetters, length20);

        // Then
        assertNotNull(generatedPassword);
        assertEquals(length20, generatedPassword.length());
    }

    /**
     * Test <code>shouldGeneratedCorrectLengthOfPasswordWithOnlyCharacters</code> checks, that the password have
     * a correct length.
     */

    @Test
    public void shouldGeneratedCorrectLengthOfPasswordWithOnlyCharacters() {

        // Given
        String generatedPassword20;
        String generatedPassword35;

        // When
        generatedPassword = password.generatedPassword(useNumbers, useSpecialCharacters, useSmallLetters, useBigLetters, length10);
        generatedPassword20 = password.generatedPassword(useNumbers, useSpecialCharacters, useSmallLetters, useBigLetters, length20);
        generatedPassword35 = password.generatedPassword(useNumbers, useSpecialCharacters, useSmallLetters, useBigLetters, length35);

        // Then
        assertNotNull(generatedPassword);
        assertNotNull(generatedPassword20);
        assertNotNull(generatedPassword35);
        assertEquals(length10, generatedPassword.length());
        assertEquals(length20, generatedPassword20.length());
        assertEquals(length35, generatedPassword35.length());
    }

    /**
     * Test <code>shouldGeneratedCorrectLengthOfPasswordWithContainsNumbers</code> checks, that the password have
     * a correct length and contains numbers.
     */

    @Test
    @SuppressWarnings("ConstantConditions")
    public void shouldGeneratedCorrectLengthOfPasswordWithContainsNumbers() {

        // Given
        String generatedPassword20;
        String generatedPassword35;
        useNumbers = true;

        // When
        generatedPassword = password.generatedPassword(useNumbers, useSpecialCharacters, useSmallLetters, useBigLetters, length10);
        generatedPassword20 = password.generatedPassword(useNumbers, useSpecialCharacters, useSmallLetters, useBigLetters, length20);
        generatedPassword35 = password.generatedPassword(useNumbers, useSpecialCharacters, useSmallLetters, useBigLetters, length35);

        // Then
        assertNotNull(generatedPassword);
        assertNotNull(generatedPassword20);
        assertNotNull(generatedPassword35);
        assertEquals(length10, generatedPassword.length());
        assertEquals(length20, generatedPassword20.length());
        assertEquals(length35, generatedPassword35.length());
    }

    /**
     * Test <code>shouldGeneratedCorrectLengthOfPasswordWithContainsSpecialCharacters</code> checks, that the password
     * have a correct length and contains special characters.
     */

    @Test
    @SuppressWarnings("ConstantConditions")
    public void shouldGeneratedCorrectLengthOfPasswordWithContainsSpecialCharacters() {

        // Given
        String generatedPassword20;
        String generatedPassword35;
        useSpecialCharacters = true;

        // When
        generatedPassword = password.generatedPassword(useNumbers, useSpecialCharacters, useSmallLetters, useBigLetters, length10);
        generatedPassword20 = password.generatedPassword(useNumbers, useSpecialCharacters, useSmallLetters, useBigLetters, length20);
        generatedPassword35 = password.generatedPassword(useNumbers, useSpecialCharacters, useSmallLetters, useBigLetters, length35);

        // Then
        assertNotNull(generatedPassword);
        assertNotNull(generatedPassword20);
        assertNotNull(generatedPassword35);
        assertEquals(length10, generatedPassword.length());
        assertEquals(length20, generatedPassword20.length());
        assertEquals(length35, generatedPassword35.length());
    }

    /**
     * Test <code>shouldGeneratedCorrectLengthOfPasswordWithContainsNumbersAndSpecialCharacters</code> checks, that
     * the password have a correct length and contains numbers and special characters.
     */

    @Test
    @SuppressWarnings("ConstantConditions")
    public void shouldGeneratedCorrectLengthOfPasswordWithContainsNumbersAndSpecialCharacters() {

        // Given
        String generatedPassword20;
        String generatedPassword35;
        useNumbers = true;
        useSpecialCharacters = true;

        // When
        generatedPassword = password.generatedPassword(useNumbers, useSpecialCharacters, useSmallLetters, useBigLetters, length10);
        generatedPassword20 = password.generatedPassword(useNumbers, useSpecialCharacters, useSmallLetters, useBigLetters, length20);
        generatedPassword35 = password.generatedPassword(useNumbers, useSpecialCharacters, useSmallLetters, useBigLetters, length35);

        // Then
        assertNotNull(generatedPassword);
        assertNotNull(generatedPassword20);
        assertNotNull(generatedPassword35);
        assertEquals(length10, generatedPassword.length());
        assertEquals(length20, generatedPassword20.length());
        assertEquals(length35, generatedPassword35.length());
    }

    /**
     * Test <code>shouldHaveSmallLetters</code> checks, that the password have only small letters.
     */

    @Test
    @SuppressWarnings("ConstantConditions")
    public void shouldHaveSmallLetters() {

        // Given
        useSmallLetters = true;

        // When
        generatedPassword = password.generatedPassword(useNumbers, useSpecialCharacters, useSmallLetters, useBigLetters, length20);
        hasUppercase = !generatedPassword.equals(generatedPassword.toLowerCase());
        hasLowercase = !generatedPassword.equals(generatedPassword.toUpperCase());

        // Then
        assertTrue(hasLowercase);
        assertFalse(hasUppercase);

    }

    /**
     * Test <code>shouldHaveBigLetters</code> checks, that the password have only big letters.
     */

    @Test
    @SuppressWarnings("ConstantConditions")
    public void shouldHaveBigLetters() {

        // Given
        useBigLetters = true;

        // When
        generatedPassword = password.generatedPassword(useNumbers, useSpecialCharacters, useSmallLetters, useBigLetters, length20);
        hasUppercase = !generatedPassword.equals(generatedPassword.toLowerCase());
        hasLowercase = !generatedPassword.equals(generatedPassword.toUpperCase());

        // Then
        assertFalse(hasLowercase);
        assertTrue(hasUppercase);
    }

    /**
     * Test <code>shouldHaveSmallAndBigLetters</code> checks, that the password have small and big letters.
     */

    @Test
    public void shouldHaveSmallAndBigLetters() {

        // Given

        // When
        generatedPassword = password.generatedPassword(useNumbers, useSpecialCharacters, useSmallLetters, useBigLetters, length20);
        hasUppercase = !generatedPassword.equals(generatedPassword.toLowerCase());
        hasLowercase = !generatedPassword.equals(generatedPassword.toUpperCase());

        // Then
        assertTrue(hasLowercase);
        assertTrue(hasUppercase);
    }

    /**
     * Test <code>shouldHaveSmallLettersAndNumbers</code> checks, that the password have only small letters
     * and contains numbers.
     */

    @Test
    @SuppressWarnings("ConstantConditions")
    public void shouldHaveSmallLettersAndNumbers() {

        // Given
        useNumbers = true;
        useSmallLetters = true;

        // When
        generatedPassword = password.generatedPassword(useNumbers, useSpecialCharacters, useSmallLetters, useBigLetters, length20);
        hasUppercase = !generatedPassword.equals(generatedPassword.toLowerCase());
        hasLowercase = !generatedPassword.equals(generatedPassword.toUpperCase());

        for (int i = 0; i < generatedPassword.length(); i++) {
            containNumbers = generatedPassword.contains(String.valueOf(i));

            if (containNumbers)
                break;
        }

        for (String specialChar : specialCharacters) {
            containSpecialCharacters = generatedPassword.contains(specialChar);

            if (containSpecialCharacters)
                break;
        }

        // Then
        assertTrue(containNumbers);
        assertTrue(hasLowercase);
        assertFalse(hasUppercase);
        assertFalse(containSpecialCharacters);
    }

    /**
     * Test <code>shouldHaveSmallLettersAndSpecialCharacters</code> checks, that the password have only small letters
     * and contains special characters.
     */

    @Test
    @SuppressWarnings("ConstantConditions")
    public void shouldHaveSmallLettersAndSpecialCharacters() {

        // Given
        useSpecialCharacters = true;
        useSmallLetters = true;

        // When
        generatedPassword = password.generatedPassword(useNumbers, useSpecialCharacters, useSmallLetters, useBigLetters, length20);
        hasUppercase = !generatedPassword.equals(generatedPassword.toLowerCase());
        hasLowercase = !generatedPassword.equals(generatedPassword.toUpperCase());

        for (String specialChar : specialCharacters) {
            containSpecialCharacters = generatedPassword.contains(specialChar);

            if (containSpecialCharacters)
                break;
        }

        for (int i = 0; i < generatedPassword.length(); i++) {
            containNumbers = generatedPassword.contains(String.valueOf(i));

            if (containNumbers)
                break;
        }

        // Then
        assertTrue(containSpecialCharacters);
        assertTrue(hasLowercase);
        assertFalse(hasUppercase);
        assertFalse(containNumbers);
    }

    /**
     * Test <code>shouldHaveSmallLettersAndNumbersAndSpecialCharacters</code> checks, that the password have only
     * small letters and contains numbers and special characters.
     */

    @Test
    @SuppressWarnings("ConstantConditions")
    public void shouldHaveSmallLettersAndNumbersAndSpecialCharacters() {

        // Given
        useNumbers = true;
        useSpecialCharacters = true;
        useSmallLetters = true;

        // When
        generatedPassword = password.generatedPassword(useNumbers, useSpecialCharacters, useSmallLetters, useBigLetters, length20);
        hasUppercase = !generatedPassword.equals(generatedPassword.toLowerCase());
        hasLowercase = !generatedPassword.equals(generatedPassword.toUpperCase());

        for (String specialChar : specialCharacters) {
            containSpecialCharacters = generatedPassword.contains(specialChar);

            if (containSpecialCharacters)
                break;
        }

        for (int i = 0; i < generatedPassword.length(); i++) {
            containNumbers = generatedPassword.contains(String.valueOf(i));

            if (containNumbers)
                break;
        }

        // Then
        assertTrue(containSpecialCharacters);
        assertTrue(hasLowercase);
        assertTrue(containNumbers);
        assertFalse(hasUppercase);
    }

    /**
     * Test <code>shouldHaveBigLettersAndNumbers</code> checks, that the password have only big letters and contains
     * numbers.
     */

    @Test
    @SuppressWarnings("ConstantConditions")
    public void shouldHaveBigLettersAndNumbers() {

        // Given
        useNumbers = true;
        useBigLetters = true;

        // When
        generatedPassword = password.generatedPassword(useNumbers, useSpecialCharacters, useSmallLetters, useBigLetters, length20);
        hasUppercase = !generatedPassword.equals(generatedPassword.toLowerCase());
        hasLowercase = !generatedPassword.equals(generatedPassword.toUpperCase());

        for (int i = 0; i < generatedPassword.length(); i++) {
            containNumbers = generatedPassword.contains(String.valueOf(i));

            if (containNumbers)
                break;
        }

        for (String specialChar : specialCharacters) {
            containSpecialCharacters = generatedPassword.contains(specialChar);

            if (containSpecialCharacters)
                break;
        }

        // Then
        assertTrue(containNumbers);
        assertTrue(hasUppercase);
        assertFalse(hasLowercase);
        assertFalse(containSpecialCharacters);
    }

    /**
     * Test <code>shouldHaveBigLettersAndSpecialCharacters</code> checks, that the password have only big letters
     * and contains special characters.
     */

    @Test
    @SuppressWarnings("ConstantConditions")
    public void shouldHaveBigLettersAndSpecialCharacters() {

        // Given
        useSpecialCharacters = true;
        useBigLetters = true;

        // When
        generatedPassword = password.generatedPassword(useNumbers, useSpecialCharacters, useSmallLetters, useBigLetters, length20);
        hasUppercase = !generatedPassword.equals(generatedPassword.toLowerCase());
        hasLowercase = !generatedPassword.equals(generatedPassword.toUpperCase());

        for (String specialChar : specialCharacters) {
            containSpecialCharacters = generatedPassword.contains(specialChar);

            if (containSpecialCharacters)
                break;
        }

        for (int i = 0; i < generatedPassword.length(); i++) {
            containNumbers = generatedPassword.contains(String.valueOf(i));

            if (containNumbers)
                break;
        }

        // Then
        assertTrue(containSpecialCharacters);
        assertTrue(hasUppercase);
        assertFalse(hasLowercase);
        assertFalse(containNumbers);
    }

    /**
     * Test <code>shouldHaveBigLettersAndNumbersAndSpecialCharacters</code> checks, that the password have only
     * big letters and contains numbers and special characters.
     */

    @Test
    @SuppressWarnings("ConstantConditions")
    public void shouldHaveBigLettersAndNumbersAndSpecialCharacters() {

        // Given
        useNumbers = true;
        useSpecialCharacters = true;
        useBigLetters = true;

        // When
        generatedPassword = password.generatedPassword(useNumbers, useSpecialCharacters, useSmallLetters, useBigLetters, length20);
        hasUppercase = !generatedPassword.equals(generatedPassword.toLowerCase());
        hasLowercase = !generatedPassword.equals(generatedPassword.toUpperCase());

        for (String specialChar : specialCharacters) {
            containSpecialCharacters = generatedPassword.contains(specialChar);

            if (containSpecialCharacters)
                break;
        }

        for (int i = 0; i < generatedPassword.length(); i++) {
            containNumbers = generatedPassword.contains(String.valueOf(i));

            if (containNumbers)
                break;
        }

        // Then
        assertTrue(containSpecialCharacters);
        assertTrue(hasUppercase);
        assertFalse(hasLowercase);
        assertTrue(containNumbers);
    }

    /**
     * Test <code>shouldHaveSmallAndBigLettersAndNumbers</code> checks, that the password have small and big letters
     * and contains numbers.
     */

    @Test
    @SuppressWarnings("ConstantConditions")
    public void shouldHaveSmallAndBigLettersAndNumbers() {

        // Given
        useNumbers = true;

        // When
        generatedPassword = password.generatedPassword(useNumbers, useSpecialCharacters, useSmallLetters, useBigLetters, length20);
        hasUppercase = !generatedPassword.equals(generatedPassword.toLowerCase());
        hasLowercase = !generatedPassword.equals(generatedPassword.toUpperCase());

        for (int i = 0; i < generatedPassword.length(); i++) {
            containNumbers = generatedPassword.contains(String.valueOf(i));

            if (containNumbers)
                break;
        }

        for (String specialChar : specialCharacters) {
            containSpecialCharacters = generatedPassword.contains(specialChar);

            if (containSpecialCharacters)
                break;
        }

        // Then
        assertTrue(containNumbers);
        assertTrue(hasLowercase);
        assertTrue(hasUppercase);
        assertFalse(containSpecialCharacters);
    }

    /**
     * Test <code>shouldHaveSmallAndBigLettersAndSpecialCharacters</code> checks, that the password have small and
     * big letters and contains special characters.
     */

    @Test
    @SuppressWarnings("ConstantConditions")
    public void shouldHaveSmallAndBigLettersAndSpecialCharacters() {

        // Given
        useSpecialCharacters = true;

        // When
        generatedPassword = password.generatedPassword(useNumbers, useSpecialCharacters, useSmallLetters, useBigLetters, length20);
        hasUppercase = !generatedPassword.equals(generatedPassword.toLowerCase());
        hasLowercase = !generatedPassword.equals(generatedPassword.toUpperCase());

        for (String specialChar : specialCharacters) {
            containSpecialCharacters = generatedPassword.contains(specialChar);

            if (containSpecialCharacters)
                break;
        }

        for (int i = 0; i < generatedPassword.length(); i++) {
            containNumbers = generatedPassword.contains(String.valueOf(i));

            if (containNumbers)
                break;
        }

        // Then
        assertTrue(containSpecialCharacters);
        assertTrue(hasLowercase);
        assertTrue(hasUppercase);
        assertFalse(containNumbers);
    }

    /**
     * Test <code>shouldHaveSmallAndBigLettersAndNumbersAndSpecialCharacters</code> checks, that the password have small
     * and big letters and contains numbers and special characters.
     */

    @Test
    @SuppressWarnings("ConstantConditions")
    public void shouldHaveSmallAndBigLettersAndNumbersAndSpecialCharacters() {

        // Given
        useNumbers = true;
        useSpecialCharacters = true;

        // When
        generatedPassword = password.generatedPassword(useNumbers, useSpecialCharacters, useSmallLetters, useBigLetters, length20);
        hasUppercase = !generatedPassword.equals(generatedPassword.toLowerCase());
        hasLowercase = !generatedPassword.equals(generatedPassword.toUpperCase());

        for (String specialChar : specialCharacters) {
            containSpecialCharacters = generatedPassword.contains(specialChar);

            if (containSpecialCharacters)
                break;
        }

        for (int i = 0; i < generatedPassword.length(); i++) {
            containNumbers = generatedPassword.contains(String.valueOf(i));

            if (containNumbers)
                break;
        }

        // Then
        assertTrue(containSpecialCharacters);
        assertTrue(hasLowercase);
        assertTrue(hasUppercase);
        assertTrue(containNumbers);
    }
}