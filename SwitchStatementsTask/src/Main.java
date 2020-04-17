public class Main {

    // Create a new switch statement using char instead of int
    // create a new char variable
    // create a new switch statement testing for
    // A, B, C, D or E
    // display a message if any of these are found and then break
    // Add a default which displays a message saying not found
    public static void main(String[] args) {
        char myChar = 'a';

        printCharIsBetweenAD(myChar);
        printCharIsBetweenAD('b');
        printCharIsBetweenAD('c');
        printCharIsBetweenAD('e');
        printCharIsBetweenAD('Z');

        System.out.println( CharUtility.isWithinRange('d', 'a', 'z') );
        System.out.println( CharUtility.isNumber('7') );
        System.out.println( CharUtility.isNumber('a') );
        System.out.println( CharUtility.isNumber('9') );
        System.out.println( CharUtility.isNumber('1') );
        System.out.println( CharUtility.isNumber('0') );
        System.out.println( CharUtility.isEnglishLetter('A') );
    }

    // Task solution:
    public static void printCharIsBetweenAD(final char inChar) {
        switch(Character.toUpperCase(inChar)) {
            case 'A': case 'B': case 'C': case 'D': case 'E':
                System.out.printf("Found char: %c!%n", inChar);
                break;
            default:
                System.out.printf("Desired char not found. Result was %c.%n", inChar);
                break;
        }
    }
}
