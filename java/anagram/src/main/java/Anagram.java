import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Anagram {

    private String word;

    public Anagram(String word) {
        this.word = word;
    }

    public List<String> match(List<String> candidates) {
        return candidates.stream()
                .filter(s -> !s.equalsIgnoreCase(word))
                .filter(s -> s.length() == word.length())
                .filter(s -> sortString(s.toLowerCase()).equals(sortString(word.toLowerCase())))
                .collect(Collectors.toList());
    }

    private String sortString(String s){
        char[] characters = s.toCharArray();
        Arrays.sort(characters);
        return String.valueOf(characters);
    }

}