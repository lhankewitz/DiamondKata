import java.util.Arrays;

public class DiamondGenerator {
    public DiamondGenerator() {
    }

    public String[] printDiamond(final char character) {
        final int distance = character - 'A';
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
}