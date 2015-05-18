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
        if(character == 'A') return "A";
        else return "AB";
    }

    @Test
    public void printDiamond_forB_shouldGiveCharacterSequence() {
        assertThat(printDiamond('B'), is("AB"));
    }
}
