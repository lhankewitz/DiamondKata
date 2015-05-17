import java.util.ArrayList;
import java.util.List;

public class DiamondGenerator {

    private static final char START_CHARACTER = 'A';

    public DiamondGenerator() {
    }

    public static void main(String[] args) {
        final DiamondGenerator diamondGenerator = new DiamondGenerator();

        diamondGenerator.printDiamond('Z').forEach(System.out::println);
    }

    public List<String> printDiamond(final char edgeCharacter) {

        final List<String> rows = new ArrayList<>();
        generateDiamondRows(rows, START_CHARACTER, edgeCharacter);

        return rows;
    }


    private void generateDiamondRows(final List<String> rows, final char levelCharacter, final char edgeCharacter) {

        final StringBuilder row = new StringBuilder();
        formatRow(row, levelCharacter, edgeCharacter - levelCharacter);

        if (levelCharacter != edgeCharacter) {
            rows.add(row.toString());
            generateDiamondRows(rows, getNextLevelCharacter(levelCharacter), edgeCharacter);
            rows.add(row.toString());
        } else {
            rows.add(row.toString());
        }
    }

    private char getNextLevelCharacter(final char levelCharacter) {
        return (char) (levelCharacter + 1);
    }

    public String formatRow(final StringBuilder row, final char levelCharacter, final int distanceToEdge) {
        final int distanceToA = levelCharacter - START_CHARACTER;

        if (distanceToEdge > 0) {
            row.append(' ');
            formatRow(row, levelCharacter, distanceToEdge - 1);
            row.append(' ');
        } else {
            if (distanceToA > 0) {
                row.append(levelCharacter);
                fillGap(row, distanceToA);
                row.append(levelCharacter);
            } else  {
                row.append(levelCharacter);
            }
        }

        return row.toString();
    }

    private void fillGap(final StringBuilder row, final int distanceToA) {
        final int diamondWidth = (distanceToA * 2) + 1;
        final int gapWidth = diamondWidth - 2;
        for (int i = 0; i < gapWidth; i++) {
            row.append(' ');
        }
    }

    public int calculateDistance(final char character, final char diamondCharacter) {
        return diamondCharacter - character;
    }
}