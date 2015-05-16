import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Class to test the print diamond katal.
 *
 * [x]ToTest: for input A print diamond
 * [X]ToTest: for input B print diamond
 * [X]ToTest: for input C print diamond
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
        assertThat(output[2], is(" A "));
    }

    @Test
    public void printDiamond_forC() {
        final String output[] = printDiamond('C');
        assertThat(output[0], is( "  A  "));
        assertThat(output[1], is( " B B "));
        assertThat(output[2], is( "C   C"));
        assertThat(output[3], is( " B B "));
        assertThat(output[4], is( "  A  "));
    }

    private String[] printDiamond(final char character) {
        if (character == 'C') {
            return new String[]{
                    format('A')
                    , " B B "
                    , "C   C"
                    , " B B "
                     , format('A')
            };
        } else if (character == 'B') {
            return new String[]{
                      " "+ 'A' +" "
                    , "B B"
                    ,  " "+ 'A' +" "
            };
        } else {
            return new String[]{String.valueOf('A')};
        }

    }

    private String format(final char character) {
        final char[] chars = new char[5];
        Arrays.fill(chars, ' ');
        chars[2] = character;

        return String.valueOf(chars);
    }
}
