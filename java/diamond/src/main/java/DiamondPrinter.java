import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class DiamondPrinter {

    List<String> printToList(char a) {
        List<Character> characters = findCharacters(a);
        List<String> diamond = new ArrayList<>();
        int j = 0;
        for (int i = 0; i < (characters.size() * 2) - 1; i++) {
            diamond.add(getPattern(characters.get(j), j, characters.size()));
            if (characters.size() <= i + 1) {
                j--;
            } else {
                j++;
            }
        }
        return diamond;
    }

    private String getPattern(char c, int count, int size) {
        StringBuilder pattern = new StringBuilder();
        String spaces = appendSpace(count, size);
        pattern.append(spaces);
        pattern.append(c);
        if (count != 0) {
            pattern.append(appendInBetweenSpace(count, size));
            pattern.append(c);
        }
        pattern.append(spaces);
        return pattern.toString();
    }

    private String appendSpace(int count, int size) {
        return " ".repeat(Math.max(0, size - count - 1));
    }

    private String appendInBetweenSpace(int count, int size) {
        return " ".repeat(Math.max(0, count == 1 ? count : (count * 2) - 1));
    }

    private List<Character> findCharacters(char c) {
        List<Character> characters = new ArrayList<>();
        while (Character.isAlphabetic(c)) {
            characters.add(c);
            c--;
        }
        characters.sort(Comparator.naturalOrder());
        return characters;
    }

}
