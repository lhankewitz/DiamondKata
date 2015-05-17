import org.junit.Test;

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

    private final DiamondGenerator diamondGenerator = new DiamondGenerator();

    @Test
    public void printDiamond_forA() {
        final String[] output = diamondGenerator.printDiamond('A');
        assertThat(output[0], is("A"));
    }

    @Test
    public void printDiamond_forB() {
        final String output[] = diamondGenerator.printDiamond('B');
        assertThat(output[0], is(" A "));
        assertThat(output[1], is("B B"));
        assertThat(output[2], is(" A "));
    }

    @Test
    public void printDiamond_forC() {
        final String output[] = diamondGenerator.printDiamond('C');
        assertThat(output[0], is("  A  "));
        assertThat(output[1], is(" B B "));
        assertThat(output[2], is("C   C"));
        assertThat(output[3], is(" B B "));
        assertThat(output[4], is("  A  "));
    }

    @Test
    public void printDiamond_forD() {
        final String output[] = diamondGenerator.printDiamond('D');
        assertThat(output[0], is("   A   "));
        assertThat(output[1], is("  B B  "));
        assertThat(output[2], is(" C   C "));
        assertThat(output[3], is("D     D"));
        assertThat(output[4], is(" C   C "));
        assertThat(output[5], is("  B B  "));
        assertThat(output[6], is("   A   "));
    }

    @Test
    public void formatRow_forA_resultsInA() {
        final String result = diamondGenerator.formatRow('A');
        assertThat(result, is("A"));
    }

}
