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
            final int intent = character - c;
            if(intent > 0) sequence.append(String.format("%"+ intent +"c", ' '));
            sequence.append(c);
            if(c != 'A') sequence.append(c);
            if(character != 'A') sequence.append("\n");
        }
    }

    @Test
    public void printDiamond_forB_shouldIndentAllButTheDefiningCharacter() {
        assertThat(printDiamond('C'), is("  A\n BB\nCC\n"));
    }
}
