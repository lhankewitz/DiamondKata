import java.util.ArrayList;
import java.util.List;

public class GorillaDiamondGenerator {

    private static final char START_CHARACTER = 'A';
    private static final int NUM_OF_EDGE_CHARACTER = 2;

    public GorillaDiamondGenerator() {
    }

    public static void main(String[] args) {
        final GorillaDiamondGenerator diamondGenerator = new GorillaDiamondGenerator();

        diamondGenerator.printDiamond('Z').forEach(System.out::println);
    }

    public List<String> printDiamond(final char maxCharacter) {

        final List<String> rows = new ArrayList<>();
        generateDiamondLines(rows, START_CHARACTER, maxCharacter);

        return rows;
    }


    private void generateDiamondLines(final List<String> rows, final char levelCharacter, final char maxCharacter) {

        final StringBuilder levelRow = new StringBuilder();
        formatLevelRow(levelRow, levelCharacter, maxCharacter - levelCharacter);

        if (levelCharacter != maxCharacter) {
            rows.add(levelRow.toString());
            generateDiamondLines(rows, getNextLevelCharacter(levelCharacter), maxCharacter);
            rows.add(levelRow.toString());
        } else {
            rows.add(levelRow.toString());
        }
    }

    private char getNextLevelCharacter(final char levelCharacter) {
        return (char) (levelCharacter + 1);
    }

    public String formatLevelRow(final StringBuilder row, final char levelCharacter, final int numOfLevelPaddingBlanks) {

        if (numOfLevelPaddingBlanks > 0) {
            fillLevelPaddingBlanks(row, numOfLevelPaddingBlanks, levelCharacter);
        } else {
            addDiamondForLevel(row, levelCharacter);
        }

        return row.toString();
    }

    private void fillLevelPaddingBlanks(final StringBuilder row, final int numBlanksToWidth, final char levelCharacter) {
        row.append(' ');
        formatLevelRow(row, levelCharacter, numBlanksToWidth - 1);
    }

    private void addDiamondForLevel(final StringBuilder row, final char levelCharacter) {
        if (levelCharacter == START_CHARACTER) {
            row.append(levelCharacter);
        } else {
            row.append(levelCharacter);
            row.append(getBlanksGap(levelCharacter));
            row.append(levelCharacter);
        }
    }

    private String getBlanksGap(final char levelCharacter) {
        // A + twice the distance to the edge character
        final int distanceToA2 = levelCharacter - START_CHARACTER;

        final int gapWidth = 1 + (2 * distanceToA2) - NUM_OF_EDGE_CHARACTER;
        return String.format("%" + gapWidth + "c", ' ');
    }
}