import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PigLatinTranslator {
    private final String SUFFIX = "ay";
    private final List<String> VOWELS = List.of("a", "e", "i", "o", "u", "y");
    private final List<String> CONSONANT_DIGRAPHS = List.of("qu", "th");
    private final List<String> VOWEL_DIGRAPHS = List.of("xr", "yt");
    private final List<String> CONSONANT_LETTERS = List.of("y");

    public String translate(String words) {
        return Stream.of(words.split(" "))
                .map(this::translateWord)
                .collect(Collectors.joining(" "));
    }

    private String translateWord(String word) {
        if (startsWithAConsonantDigraph(word)) {
            return translateWord(rotate(word, 2));
        }
        if (startsWithAVowelTreatedAsAConsonant(word)) {
            return translateWord(rotate(word, 1));
        }
        if (startsWithAVowel(word) || startsWithAVowelDigraph(word)) {
            return word.concat(SUFFIX);
        }
        return translateWord(rotate(word, 1));
    }

    private String rotate(String word, int count) {
        return word.substring(count).concat(word.substring(0, count));
    }

    private boolean startsWithAVowelTreatedAsAConsonant(String word) {
        return CONSONANT_LETTERS.contains(word.substring(0, 1)) && isNextLetterVowel(word);
    }

    private boolean startsWithAConsonantDigraph(String word) {
        return CONSONANT_DIGRAPHS.contains(word.substring(0, 2));
    }

    private boolean startsWithAVowelDigraph(String word) {
        return VOWEL_DIGRAPHS.contains(word.substring(0, 2));
    }

    private boolean startsWithAVowel(String word) {
        return VOWELS.contains(word.substring(0, 1));
    }

    private boolean isNextLetterVowel(String word) {
        return VOWELS.contains(word.substring(1, 2));
    }
}