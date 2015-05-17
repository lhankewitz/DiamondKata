import java.util.Arrays;

public class DiamondGenerator {
    public DiamondGenerator() {
    }

    public String[] printDiamond(final char character) {
        final int distance = calculateDistance('A', character);
        final int width = distance * 2 + 1;
        final String[] rows = new String[width];
        formatRows(rows, distance, 0);

        return rows;
    }

    public void formatRows(final String[] rows, final int distance, final int level) {
        final String levelFormat = format(rows.length, level);

        if (level < distance) {
            rows[level] = levelFormat;
            formatRows(rows, distance, level + 1);
            rows[(rows.length - 1) - level] = levelFormat;
        } else {
            rows[level] = levelFormat;
        }
    }

    public String format(final int width, final int level) {
        char[] chars = new char[width];
        Arrays.fill(chars, ' ');
        final char levelCharacter = (char) ('A' + level);

        final int leftPosition = (width / 2) - level;
        chars[(leftPosition)] = levelCharacter;

        final int rightPosition = (width / 2) + level;
        chars[(rightPosition)] = levelCharacter;
        return String.valueOf(chars);
    }


    public static void main(String[] args) {
        final DiamondGenerator diamondGenerator = new DiamondGenerator();

        Arrays.asList(diamondGenerator.printDiamond('Z')).forEach(System.out::println);
    }

    public String formatRow(final char character, final int distanceToEdge, final StringBuilder row) {
        final int distanceToA = character - 'A';
        if (distanceToA == 3 && distanceToEdge == 0) {
            row.append(character);
            fillGap(row, distanceToA);
            row.append(character);
        }
        if (distanceToA == 2 && distanceToEdge == 0) {
            row.append(character);
            fillGap(row, distanceToA);
            row.append(character);
        }
        if (distanceToA == 1 && distanceToEdge == 0) {
            row.append(character);
            fillGap(row, distanceToA);
            row.append(character);
        }
        if (distanceToA == 1 && distanceToEdge == 1) {
            row.append(' ');
            formatRow(character, distanceToEdge - 1, row);
            row.append(' ');
        }

        if (distanceToA == 0 && distanceToEdge > 0) {
            row.append(' ');
            formatRow(character, distanceToEdge - 1, row);
            row.append(' ');
        }

        if (distanceToA == 0 && distanceToEdge == 0) {
            row.append(character);
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