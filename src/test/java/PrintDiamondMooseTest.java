import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Class to test printing the diamond the moose way:
 *
 * <a href="http://claysnow.co.uk/recycling-tests-in-tdd/">Meaning of moose</a>
 *
 * @author lumiha
 * @since 18/05/15.
 */
public class PrintDiamondMooseTest {

    @Test
    public void printDiamond_forA() {
        final String result = printDiamond('A');
        assertThat(result, is("A"));
    }

    private String printDiamond(final char character) {
        StringBuilder sequence = new StringBuilder();
        iterateOverCharacter(sequence, character);

        return sequence.toString();
    }

    private void iterateOverCharacter(final StringBuilder sequence, final char character) {
        for(char c = 'A'; c <= character; c++){
            addDiamondLine(sequence, c, character);
        }

        for(char c = (char) (character - 1); c >= 'A'; c--){
            addDiamondLine(sequence, c, character);
        }
    }

    private void addDiamondLine(final StringBuilder sequence, final char c, final char character) {
        final int intent = character - c;
        if(intent > 0) sequence.append(String.format("%"+ intent +"c", ' '));
        sequence.append(c);
        if(c != 'A') {
            sequence.append(getBlanksGap(c));
            sequence.append(c);
        }
        if(character != 'A') sequence.append("\n");
    }

    private String getBlanksGap(final char c) {
        // twice the distance strictly (c-1) between c and A plus A
        final int gapWidth = 2 * ((c-1) - 'A') + 1;
        return String.format("%" + gapWidth + "c", ' ');
    }

    @Test
    public void printDiamond_forC_shouldMirrorTheTopHalfOFDiamond() {
        final String expectedDiamond = "  A\n B B\nC   C\n B B\n  A\n";
        System.out.println(expectedDiamond);
        assertThat(printDiamond('C'), is(expectedDiamond));
    }
}
