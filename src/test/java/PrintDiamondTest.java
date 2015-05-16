import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Class to test the print diamond katal.
 * <p/>
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
        assertThat(output[0], is("  A  "));
        assertThat(output[1], is(" B B "));
        assertThat(output[2], is("C   C"));
        assertThat(output[3], is(" B B "));
        assertThat(output[4], is("  A  "));
    }

    private String[] printDiamond(final char character) {
        if (character == 'C') {
            final int width = ('C' - 'A') * 2 + 1;
            return new String[]{
                    format(width, 0)
                    , format(width, 1)
                    , format(width, 2)
                    , format(width, 1)
                    , format(width, 0)
            };
        } else if (character == 'B') {
            final int width = ('B' - 'A') * 2 + 1;
            return new String[]{
                    format(width, 0)
                    , format(width, 1)
                    , format(width, 0)
            };
        } else {

            return new String[]{format(1, 0)};
        }

    }

    private String format(final int width, final int level) {
        char[] chars = new char[width];
        Arrays.fill(chars, ' ');
        final char levelCharacter = (char) ('A' + level);
        chars[(width / 2) - level] = levelCharacter;
        chars[(width / 2) + level] = levelCharacter;
        return String.valueOf(chars);
    }

}
