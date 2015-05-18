import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Class to test printing the diamond the moose way:
 * <p>
 * <a href="http://claysnow.co.uk/recycling-tests-in-tdd/">Meaning of moose</a>
 *
 * @author lumiha
 * @since 18/05/15.
 */
public class PrintDiamondMooseTest {

    @Test
    public void printDiamond_forA() {
        final String result = printDiamond('A');
        assertThat(result, is("A\n"));
    }

    private String printDiamond(final char endCharacter) {
        StringBuilder sequence = new StringBuilder();
        generateDiamondLines(sequence, 'A', endCharacter);

        return sequence.toString();
    }

    private void generateDiamondLines(final StringBuilder sequence, final char currentCharacter, final char endCharacter) {
        if (currentCharacter != endCharacter) {
            addDiamondLine(sequence, currentCharacter, endCharacter);

            generateDiamondLines(sequence, getNextLevelCharacter(currentCharacter), endCharacter);

            addDiamondLine(sequence, currentCharacter, endCharacter);
        } else {
            addDiamondLine(sequence, endCharacter, endCharacter);
        }
    }

    private char getNextLevelCharacter(final char levelCharacter) {
        return (char) (levelCharacter + 1);
    }

    private void addDiamondLine(final StringBuilder sequence, final char currentCharacter, final char endCharacter) {
        addIntent(sequence, currentCharacter, endCharacter);

        if (currentCharacter == 'A') {
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
        final int gapWidth = 2 * ((c - 1) - 'A') + 1;
        return String.format("%" + gapWidth + "c", ' ');
    }

    @Test
    public void printDiamond_forC_shouldMirrorTheTopHalfOFDiamond() {
        final String expectedDiamond = "  A\n B B\nC   C\n B B\n  A\n";
        System.out.println(expectedDiamond);
        assertThat(printDiamond('C'), is(expectedDiamond));
    }
}
