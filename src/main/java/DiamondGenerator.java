import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiamondGenerator {
    public DiamondGenerator() {
    }

    public static void main(String[] args) {
        final DiamondGenerator diamondGenerator = new DiamondGenerator();

        diamondGenerator.printDiamond('Z').forEach(System.out::println);
    }

    public List<String> printDiamond(final char diamondCharacter) {

        final List<String> rows = new ArrayList<>();
        generateDiamondRows(rows, 'A', diamondCharacter);

        return rows;
    }


    private void generateDiamondRows(final List<String> rows, final char levelCharacter, final char diamondCharacter) {

        final StringBuilder row = new StringBuilder();
        formatRow(row, levelCharacter, diamondCharacter - levelCharacter);

        if (levelCharacter != diamondCharacter) {
            rows.add(row.toString());
            generateDiamondRows(rows, (char) (levelCharacter + 1), diamondCharacter);
            rows.add(row.toString());
        } else {
            rows.add(row.toString());
        }
    }

    public String formatRow(final StringBuilder row, final char character, final int distanceToEdge) {
        final int distanceToA = character - 'A';


        if (distanceToEdge > 0) {
            row.append(' ');
            formatRow(row, character, distanceToEdge - 1);
            row.append(' ');
        } else {
            if (distanceToA > 0) {
                row.append(character);
                fillGap(row, distanceToA);
                row.append(character);
            } else  {
                row.append(character);
            }
        }


        return row.toString();
    }

    private void fillGap(final StringBuilder row, final int distanceToA) {
        for (int i = 1; i < (distanceToA * 2); i++) {
            row.append(' ');
        }
    }

    public int calculateDistance(final char character, final char diamondCharacter) {
        return diamondCharacter - character;
    }
}