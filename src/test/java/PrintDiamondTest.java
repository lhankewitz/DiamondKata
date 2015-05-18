import org.junit.Test;

import java.util.List;

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

    private final GorillaDiamondGenerator diamondGenerator = new GorillaDiamondGenerator();

    @Test
    public void printDiamond_forA() {
        final List<String> output = diamondGenerator.printDiamond('A');
        assertThat(output.get(0), is("A"));
    }

    @Test
    public void printDiamond_forB() {
        final List<String> output = diamondGenerator.printDiamond('B');
        assertThat(output.get(0), is(" A "));
        assertThat(output.get(1), is("B B"));
        assertThat(output.get(2), is(" A "));
    }

    @Test
    public void printDiamond_forC() {
        final List<String> output = diamondGenerator.printDiamond('C');
        assertThat(output.get(0), is("  A  "));
        assertThat(output.get(1), is(" B B "));
        assertThat(output.get(2), is("C   C"));
        assertThat(output.get(3), is(" B B "));
        assertThat(output.get(4), is("  A  "));
    }

    @Test
    public void printDiamond_forD() {
        final List<String> output = diamondGenerator.printDiamond('D');
        assertThat(output.get(0), is("   A   "));
        assertThat(output.get(1), is("  B B  "));
        assertThat(output.get(2), is(" C   C "));
        assertThat(output.get(3), is("D     D"));
        assertThat(output.get(4), is(" C   C "));
        assertThat(output.get(5), is("  B B  "));
        assertThat(output.get(6), is("   A   "));
    }

    @Test
    public void formatRow_forA_resultsInA() {
        final String result = diamondGenerator.formatLevelRow(new StringBuilder(), 'A', diamondGenerator.calculateDistance('A', 'A'));
        assertThat(result, is("A"));
    }

    @Test
    public void formatRow_forB_resultsInBRow() {
        final String result = diamondGenerator.formatLevelRow(new StringBuilder(), 'B', diamondGenerator.calculateDistance('B', 'B'));
        assertThat(result, is("B B"));
    }

    @Test
    public void formatRow_forAWhenDiamondForB_resultsInARowWithBlanks() {
        final String result = diamondGenerator.formatLevelRow(new StringBuilder(), 'A', diamondGenerator.calculateDistance('A', 'B'));
        assertThat(result, is(" A "));
    }

    @Test
    public void formatRow_forBWhenDiamondForC_resultsInBRowWithBlanks() {
        final String result = diamondGenerator.formatLevelRow(new StringBuilder(), 'B', diamondGenerator.calculateDistance('B', 'C'));
        assertThat(result, is(" B B "));
    }

    @Test
    public void formatRow_forAWhenDiamondForC_resultsInARowWithBlanks() {
        final String result = diamondGenerator.formatLevelRow(new StringBuilder(), 'A', diamondGenerator.calculateDistance('A', 'C'));
        assertThat(result, is("  A  "));
    }
    @Test
    public void formatRow_forCWhenDiamondForC_resultsInCRowWithBlanks() {
        final String result = diamondGenerator.formatLevelRow(new StringBuilder(), 'C', diamondGenerator.calculateDistance('C', 'C'));
        assertThat(result, is("C   C"));
    }

    @Test
    public void formatRow_forDAndDiamondForD_resultsIn_D_RowWithBlanks() {
        final String result = diamondGenerator.formatLevelRow(new StringBuilder(), 'D', diamondGenerator.calculateDistance('D', 'D'));
        assertThat(result, is("D     D"));
    }

    @Test
    public void formatRow_forCAndDiamondForD_resultsIn_C_RowWithBlanks() {
        final String result = diamondGenerator.formatLevelRow(new StringBuilder(), 'C', diamondGenerator.calculateDistance('C', 'D'));
        assertThat(result, is(" C   C "));
    }

}
