import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CharUtilityTest {

    private static final char[] lowerAlphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private static final char[] upperAlphabet = String.copyValueOf(lowerAlphabet).toUpperCase().toCharArray();

    private static final char[] numbers = "0123456789".toCharArray();

    private static final char[] allCharacters = new char[Math.abs(Character.MIN_VALUE - Character.MAX_VALUE)];

    @BeforeEach
    void setUp() {
        assertTrue(lowerAlphabet.length == 26, "The English alphabet must have 26 letters");
        assertTrue(upperAlphabet.length == 26, "The English alphabet must have 26 letters");

        assertTrue(numbers.length == 10, "0 through 9, must be 10 characters long");

        for(int i = 0, j = Character.MIN_VALUE; j < Character.MAX_VALUE; ++i, ++j) {
            allCharacters[i] = (char)j;
        }
    }

    @org.junit.jupiter.api.Test
    void allNumericCharsAreNumbers() {
        for (char c : numbers) {
            assertTrue( CharUtility.isNumber(c) );
        }
    }

    @org.junit.jupiter.api.Test
    void allLettersAreNotNumbers() {
        for(char c : upperAlphabet) {
            assertFalse( CharUtility.isNumber(c) );
        }
        for(char c : lowerAlphabet) {
            assertFalse( CharUtility.isNumber(c) );
        }
    }

    @org.junit.jupiter.api.Test
    void allEnglishAlphabeticalCharsAreLetters() {
        for(char c : upperAlphabet) {
            assertTrue( CharUtility.isEnglishLetter(c) );
        }
        for(char c : lowerAlphabet) {
            assertTrue( CharUtility.isEnglishLetter(c) );
        }
    }

    @org.junit.jupiter.api.Test
    void allEnglishLowercaseCharsAreLetters() {
        for(char c : lowerAlphabet) {
            assertTrue( CharUtility.isEnglishLetter(c) );
        }
    }

    @org.junit.jupiter.api.Test
    void allEnglishUppercaseCharsAreLetters() {
        for(char c : upperAlphabet) {
            assertTrue( CharUtility.isEnglishLetter(c) );
        }
    }

    @org.junit.jupiter.api.Test
    void allCharactersExceptNumbersAreNotNumbers() {
        ArrayList<Character> allNumericChars = new ArrayList<>();
        for(char c : numbers) {
            allNumericChars.add(c);
        }

        for(char c : allCharacters) {
            if(!allNumericChars.contains(c)) {
                assertFalse( CharUtility.isNumber(c) );
            }
        }
    }

    @org.junit.jupiter.api.Test
    void allCharactersExceptLettersAreNotLetters() {
        // Make these lists so we can use List.contains
        ArrayList<Character> lowerAlphabetList = new ArrayList<>();
        for(char c : numbers) {
            lowerAlphabetList.add(c);
        }
        ArrayList<Character> upperAlphabetList = new ArrayList<>();
        for(char c : numbers) {
            upperAlphabetList.add(c);
        }

        // Test
        for(char c : allCharacters) {
            if(!lowerAlphabetList.contains(c) && !upperAlphabetList.contains(c)) {
                assertFalse( CharUtility.isEnglishLetter(c) );
            }
        }
    }
}