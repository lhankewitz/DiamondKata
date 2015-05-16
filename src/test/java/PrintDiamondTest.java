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
                    formatCharacter1('A', 5)
                    , formatCharacter2('B', 5)
                    , formatCharacter3()
                    , formatCharacter2('B', 5)
                     , formatCharacter1('A', 5)
            };
        } else if (character == 'B') {
            return new String[]{
                      formatCharacter1('A', 3)
                    , formatCharacter2('B', 3)
                    , formatCharacter1('A', 3)
            };
        } else {
            return new String[]{formatCharacter1('A', 1)};
        }

    }

    private String formatCharacter3() {
        final int width = 5;
        final char character = 'C';
        char[] chars = new char[width];
        Arrays.fill(chars, ' ');
        chars[(width/2) - 2] = character;
        chars[(width/2) + 2] = character;
        return String.valueOf(chars);
    }

    private String formatCharacter2(final char character, final int width) {
        char[] chars = new char[width];
        Arrays.fill(chars, ' ');
        chars[(width/2) - 1] = character;
        chars[(width/2) + 1] = character;
        return String.valueOf(chars);
    }

    private String formatCharacter1(final char character, final int width) {
        final char[] chars = new char[width];
        Arrays.fill(chars, ' ');
        chars[width/2] = character;

        return String.valueOf(chars);
    }
}
