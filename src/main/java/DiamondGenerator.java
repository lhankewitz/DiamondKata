import java.util.ArrayList;
import java.util.List;

public class DiamondGenerator {

    private static final char START_CHARACTER = 'A';
    private static final int NUM_OF_EDGE_CHARACTER = 2;

    public DiamondGenerator() {
    }

    public static void main(String[] args) {
        final DiamondGenerator diamondGenerator = new DiamondGenerator();

        diamondGenerator.printDiamond('Z').forEach(System.out::println);
    }

    public List<String> printDiamond(final char maxCharacter) {

        final List<String> rows = new ArrayList<>();
        addDiamondRows(rows, START_CHARACTER, maxCharacter);

        return rows;
    }


    private void addDiamondRows(final List<String> rows, final char levelCharacter, final char maxCharacter) {

        final StringBuilder row = new StringBuilder();
        formatRow(row, levelCharacter, maxCharacter - levelCharacter);

        if (levelCharacter != maxCharacter) {
            rows.add(row.toString());
            addDiamondRows(rows, getNextLevelCharacter(levelCharacter), maxCharacter);
            rows.add(row.toString());
        } else {
            rows.add(row.toString());
        }
    }

    private char getNextLevelCharacter(final char levelCharacter) {
        return (char) (levelCharacter + 1);
    }

    public String formatRow(final StringBuilder row, final char levelCharacter, final int distanceToMaxChar) {

        if (distanceToMaxChar > 0) {
            row.append(' ');
            formatRow(row, levelCharacter, distanceToMaxChar - 1);
            row.append(' ');
        } else {
            if (levelCharacter > START_CHARACTER) {
                row.append(levelCharacter);
                row.append(getGap(levelCharacter));
                row.append(levelCharacter);
            } else  {
                row.append(levelCharacter);
            }
        }

        return row.toString();
    }

    private String getGap(final char levelCharacter) {
        final int gapWidth = getDiamondWidthAt(levelCharacter) - NUM_OF_EDGE_CHARACTER;

        return getBlanksOfLength(gapWidth);
    }

    private String getBlanksOfLength(final int length) {
        return String.format("%" + length + "c", ' ');
    }

    private int getDiamondWidthAt(final char levelCharacter) {
        // A + twice the distance to the edge character
        final int distanceToA2 = levelCharacter - START_CHARACTER;

        return 1 + (2* distanceToA2);
    }

    public int calculateDistance(final char character, final char diamondCharacter) {
        return diamondCharacter - character;
    }
}