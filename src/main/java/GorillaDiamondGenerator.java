import java.util.ArrayList;
import java.util.List;
/**
 * Result of Gorialla version of TDD for Diamond Problem.
 *
 *  * <a href="http://claysnow.co.uk/recycling-tests-in-tdd/">Meaning of gorilla</a>
 *
 * */
public class GorillaDiamondGenerator {

    private static final char START_CHARACTER = 'A';
    private static final int NUM_OF_EDGE_CHARACTER = 2;

    public static void main(String[] args) {
        final GorillaDiamondGenerator diamondGenerator = new GorillaDiamondGenerator();

        diamondGenerator.printDiamond('Z').forEach(System.out::println);
    }

    public List<String> printDiamond(final char endCharacter) {

        final List<String> rows = new ArrayList<>();
        generateDiamondLines(rows, START_CHARACTER, endCharacter);

        return rows;
    }


    private void generateDiamondLines(final List<String> rows, final char currentCharacter, final char endCharacter) {

        final StringBuilder levelRow = new StringBuilder();
        generateDiamondLine(levelRow, currentCharacter, endCharacter - currentCharacter);

        if (currentCharacter != endCharacter) {
            rows.add(levelRow.toString());
            generateDiamondLines(rows, getNextCharacter(currentCharacter), endCharacter);
            rows.add(levelRow.toString());
        } else {
            rows.add(levelRow.toString());
        }
    }

    private char getNextCharacter(final char currentCharacter) {
        return (char) (currentCharacter + 1);
    }

    /**
     * Handled intent via recursion in contrast to the moose version.
     * */
    public String generateDiamondLine(final StringBuilder row, final char currentCharacter, final int numOfLevelPaddingBlanks) {

        if (numOfLevelPaddingBlanks > 0) {
            addIndent(row, currentCharacter, numOfLevelPaddingBlanks);
        } else {
            addDiamondLineWithoutIndent(row, currentCharacter);
        }

        return row.toString();
    }

    private void addDiamondLineWithoutIndent(final StringBuilder row, final char currentCharacter) {
        if (currentCharacter == START_CHARACTER) {
            row.append(currentCharacter);
        } else {
            row.append(currentCharacter);
            row.append(getBlanksGap(currentCharacter));
            row.append(currentCharacter);
        }
    }


    private void addIndent(final StringBuilder row, final char levelCharacter, final int numOfLevelPaddingBlanks) {
        row.append(' ');
        generateDiamondLine(row, levelCharacter, numOfLevelPaddingBlanks - 1);
    }

    private String getBlanksGap(final char levelCharacter) {
        // A + twice the distance to the edge character
        final int distanceToA2 = levelCharacter - START_CHARACTER;

        final int gapWidth = 1 + (2 * distanceToA2) - NUM_OF_EDGE_CHARACTER;
        return String.format("%" + gapWidth + "c", ' ');
    }
}