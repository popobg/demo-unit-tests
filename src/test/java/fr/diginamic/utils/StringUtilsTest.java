package fr.diginamic.utils;

import org.junit.jupiter.api.Test;

import static fr.diginamic.utils.StringUtils.levenshteinDistance;
import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    // SUCCESS CASES
    @Test
    public void levenshteinDistanceTestSuccess1() {
        // ARRANGE
        String firstWord = "chat";
        String secondWord = "chats";

        // ACT
        int actual = levenshteinDistance(firstWord, secondWord);

        // ASSERT
        assertEquals(1, actual);
    }

    @Test
    public void levenshteinDistanceTestSuccess2() {
        // ARRANGE
        String firstWord = "machins";
        String secondWord = "machine";

        // ACT
        int actual = levenshteinDistance(firstWord, secondWord);

        // ASSERT
        assertEquals(1, actual);
    }

    @Test
    public void levenshteinDistanceTestSuccess3() {
        // ARRANGE
        String firstWord = "Chien";
        String secondWord = "Chine";

        // ACT
        int actual = levenshteinDistance(firstWord, secondWord);

        // ASSERT
        assertEquals(2, actual);
    }

    @Test
    public void levenshteinDistanceTestSuccess4() {
        // ARRANGE
        String firstWord = "cache-coeur";
        String secondWord = "cache-misère";

        // ACT
        int actual = levenshteinDistance(firstWord, secondWord);

        // ASSERT
        assertEquals(5, actual);
    }

    @Test
    public void levenshteinDistanceTestSuccess5() {
        // ARRANGE
        String firstWord = "cache coeur";
        String secondWord = "cache misère";

        // ACT
        int actual = levenshteinDistance(firstWord, secondWord);

        // ASSERT
        assertEquals(5, actual);
    }

    // NOT NOMINAL CASES
    @Test
    public void levenshteinDistanceTestEmptyString() {
        // ARRANGE
        String firstWord = "";
        String secondWord = "Chine";

        // ACT
        int actual = levenshteinDistance(firstWord, secondWord);

        // ASSERT
        assertEquals(-1, actual);
    }

    @Test
    public void levenshteinDistanceTestNullObject() {
        // ARRANGE
        String firstWord = null;
        String secondWord = "Chine";

        int actual;

        // ACT && ASSERT
        try {
            actual = levenshteinDistance(firstWord, secondWord);
        }
        catch (NullPointerException e) {
            assertEquals("Au moins une des chaînes est nulle.", e.getMessage());
        }
    }

    @Test
    public void levenshteinDistanceTestCaseInsensitive() {
        // ARRANGE
        String firstWord = "chien";
        String secondWord = "Chine";

        // ACT
        int actual = levenshteinDistance(firstWord, secondWord);

        // ASSERT
        assertEquals(2, actual);
    }

    @Test
    public void levenshteinDistanceTestSameWord() {
        // ARRANGE
        String firstWord = "chien";
        String secondWord = "chien";

        // ACT
        int actual = levenshteinDistance(firstWord, secondWord);

        // ASSERT
        assertEquals(0, actual);
    }
}