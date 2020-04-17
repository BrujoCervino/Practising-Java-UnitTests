// This class exists to practise chars and testing (I know these already exist in basic Java libraries).
// Limitation: only checks English chars (without diacritics or accents)
public class CharUtility {

    public static boolean isWithinRange(final char inChar, final char lowerBoundInc, final char upperBoundInc) {
        return (inChar >= lowerBoundInc) && (inChar <= upperBoundInc);
    }

    public static boolean isNumber(final char inChar) {
        return isWithinRange(inChar, '0', '9');
    }

    // No accents/diacritics
    public static boolean isEnglishLetter(final char inChar) {
        return isWithinRange( Character.toLowerCase(inChar), 'a', 'z');
    }
}
