import java.util.stream.Collectors;

import static java.util.stream.IntStream.range;

class RaindropConverter {
    String convert(int number) {
        String result = range(1, number + 1)
                .filter(potential -> number % potential == 0)
                .boxed()
                .map(this::raindrop)
                .collect(Collectors.joining());
        return !result.equals("") ? result : Integer.toString(number);
    }

    private String raindrop(Integer factor) {
        if (factor.equals(3)) {
            return "Pling";
        } else if (factor.equals(5)) {
            return "Plang";
        } else if (factor.equals(7)) {
            return "Plong";
        }
        return "";
    }
}
