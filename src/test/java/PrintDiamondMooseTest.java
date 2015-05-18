import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Class to test printing the diamond the moose way:
 * <p>
 * <a href="http://claysnow.co.uk/recycling-tests-in-tdd/">Meaning of moose</a>
 *
 * @author lumiha
 * @since 18/05/15.
 */
public class PrintDiamondMooseTest {

    private final MooseDiamondGenerator mooseDiamondGenerator = new MooseDiamondGenerator();

    @Test
    public void printDiamond_forA() {
        final String result = mooseDiamondGenerator.printDiamond('A');
        assertThat(result, is("A\n"));
    }


    @Test
    public void printDiamond_forC_shouldMirrorTheTopHalfOFDiamond() {
        final String expectedDiamond = "  A\n B B\nC   C\n B B\n  A\n";
        System.out.println(expectedDiamond);
        assertThat(mooseDiamondGenerator.printDiamond('C'), is(expectedDiamond));
    }
}
