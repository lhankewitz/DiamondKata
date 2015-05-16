import org.junit.Ignore;
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
        final String[] output = printDiamond();
        assertThat(output[0], is("A"));
    }

    @Test
    @Ignore("first refactor to multi line input")
    public void printDiamond_forB() {
        final String output[] = printDiamond();
        assertThat(output[0], is("A"));
    }

    private String[] printDiamond() {
        return new String[]{"A"};
    }
}
