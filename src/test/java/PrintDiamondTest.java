import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Class to test the print diamond katal.
 *
 * [x]ToTest: for input A print A one line
 * []ToTest: for input B print
 * ' A '
 * 'B B'
 * ' A '
 *
 * @author lumiha
 * @since 16/05/15.
 */
public class PrintDiamondTest {

    @Test
    public void printDiamond_forA() {
        final String[] output = printDiamond('A');
        assertThat(output[0], is("A"));
    }

    @Test
    public void printDiamond_forB() {
        final String output[] = printDiamond('B');
        assertThat(output[0], is(" A "));
        assertThat(output[1], is("B B"));
    }

    private String[] printDiamond(final char character) {
        if(character == 'B'){
            return new String[]{
                    " A ", "B B"
            };
        }
        return new String[]{String.valueOf(character)};
    }
}
