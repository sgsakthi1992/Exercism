import java.util.Objects;
import java.util.stream.Collectors;

class IsbnVerifier {
    private int from = 10;

    boolean isValid(String stringToVerify) {
        int sum = 0;

        String formattedString = stringToVerify.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> Character.isDigit(c) || c.equals('X'))
                .map(Objects::toString)
                .collect(Collectors.joining());

        if (formattedString.length() != 10) {
            return false;
        }

        for (int i = 0; i < 10; i++) {
            char c = formattedString.charAt(i);
            sum += c == 'X'
                    ? 10
                    : Character.getNumericValue(formattedString.charAt(i)) * from--;
        }

        return Math.floorMod(sum, 11) == 0;
    }

}
