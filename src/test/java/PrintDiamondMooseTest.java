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
        for(char c = 'A'; c <= character; c++){
            sequence.append(c);
        }

        return sequence.toString();
    }

    @Test
    public void printDiamond_forB_shouldGiveCharacterSequence() {
        assertThat(printDiamond('B'), is("AB"));
    }
}
