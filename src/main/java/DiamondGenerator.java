import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public String formatRow(final char character, final char diamondCharacter) {
        StringBuilder row = new StringBuilder();
        if(character == 'C' && diamondCharacter == character){
            row.append('C');
            row.append(' ');
            row.append(' ');
            row.append(' ');
            row.append('C');
        }
        if(character == 'B' && diamondCharacter == 'C'){
            row.append(' ');
            row.append('B');
            row.append(' ');
            row.append('B');
            row.append(' ');
        }
        if(character == 'B' && diamondCharacter == character){
            row.append('B');
            row.append(' ');
            row.append('B');
        }
        if(character == 'A' && diamondCharacter == 'C'){
            row.append(' ');
            row.append(' ');
            row.append('A');
            row.append(' ');
            row.append(' ');
        }
        if(character == 'A' && diamondCharacter == 'B'){
            row.append(' ');
            row.append('A');
            row.append(' ');
        }
        if(character == 'A' && diamondCharacter == character){
            row.append('A');
        }

        return row.toString();
    }
}