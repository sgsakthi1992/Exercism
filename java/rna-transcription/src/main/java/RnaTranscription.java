import java.util.stream.Collectors;

class RnaTranscription {

    private static final char G = 'G';
    private static final char C = 'C';
    private static final char T = 'T';
    private static final char A = 'A';
    private static final char U = 'U';

    String transcribe(String dnaStrand) {
        return dnaStrand.chars()
                .mapToObj(c -> (char) c)
                .map(this::rnaEquivalent)
                .map(Object::toString)
                .collect(Collectors.joining());
    }

    private char rnaEquivalent(char c) {
        if (c == G)
            return C;
        else if (c == C)
            return G;
        else if (c == T)
            return A;
        else if (c == A)
            return U;
        return ' ';
    }
}
