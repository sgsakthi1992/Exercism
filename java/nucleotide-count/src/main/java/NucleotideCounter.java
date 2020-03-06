import java.util.*;
import java.util.stream.Collectors;

public class NucleotideCounter {
    private String dna;
    private Set<Character> dnaLetters = Set.of('A', 'C', 'G', 'T');


    public NucleotideCounter(String dna) {
        if (dna.chars().anyMatch(c -> !dnaLetters.contains((char) c)))
            throw new IllegalArgumentException();
        this.dna = dna;
    }

    public Map<Character, Integer> nucleotideCounts() {
        return dnaLetters.stream()
                .collect(Collectors
                        .toMap(e -> e, this::getCount));
    }

    private Integer getCount(Character letter) {
        return Math.toIntExact(dna.chars()
                .mapToObj(c -> (char) c)
                .filter(character -> character == letter)
                .count());
    }
}