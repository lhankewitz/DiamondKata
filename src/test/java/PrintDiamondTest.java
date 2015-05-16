import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Class to test the print diamond katal.
 *
 * []ToTest: for input A print A one line
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
        final String output = printDiamond();
        assertThat(output, is("A"));
    }

    private String printDiamond() {
        return "A";
    }
}
