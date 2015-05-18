

/**
 * Result of Moose version of TDD for Diamond Problem.
 *
 *  * <a href="http://claysnow.co.uk/recycling-tests-in-tdd/">Meaning of moose</a>
 *
 * */
public class MooseDiamondGenerator {

    private static final char START_CHARACTER = 'A';


    public static void main(String[] args) {
        final MooseDiamondGenerator diamondGenerator = new MooseDiamondGenerator();

        System.out.println(diamondGenerator.printDiamond('Z'));
    }

    public String printDiamond(final char endCharacter) {

        StringBuilder sequence = new StringBuilder();
        generateDiamondLines(sequence, START_CHARACTER, endCharacter);

        return sequence.toString();
    }

    private void generateDiamondLines(final StringBuilder sequence, final char currentCharacter, final char endCharacter) {
        if (currentCharacter != endCharacter) {
            addDiamondLine(sequence, currentCharacter, endCharacter);

            generateDiamondLines(sequence, getNextCharacter(currentCharacter), endCharacter);

            addDiamondLine(sequence, currentCharacter, endCharacter);
        } else {
            addDiamondLine(sequence, endCharacter, endCharacter);
        }
    }

    private char getNextCharacter(final char currentCharacter) {
        return (char) (currentCharacter + 1);
    }

    // adds newline in contrast to the gorilla version
    private void addDiamondLine(final StringBuilder sequence, final char currentCharacter, final char endCharacter) {
        addIntent(sequence, currentCharacter, endCharacter);

        if (currentCharacter == START_CHARACTER) {
            sequence.append(currentCharacter);
        } else {
            sequence.append(currentCharacter);
            sequence.append(getBlanksGap(currentCharacter));
            sequence.append(currentCharacter);
        }

        sequence.append("\n");
    }

    private void addIntent(final StringBuilder sequence, final char currentCharacter, final char endCharacter) {
        final int intent = endCharacter - currentCharacter;

        if (intent > 0) sequence.append(String.format("%" + intent + "c", ' '));
    }

    private String getBlanksGap(final char c) {
        // twice the distance strictly (c-1) between c and A plus A
        final int gapWidth = 2 * ((c - 1) - START_CHARACTER) + 1;
        return String.format("%" + gapWidth + "c", ' ');
    }
}