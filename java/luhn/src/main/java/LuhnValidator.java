import java.util.stream.IntStream;

class LuhnValidator {

    boolean isValid(String candidate) {
        String numbers = new StringBuilder(
                candidate.replaceAll(" ", ""))
                .reverse()
                .toString();

        if (!numbers.chars().allMatch(Character::isDigit))
            return false;

        return numbers.length() > 1 && getSum(numbers) % 10 == 0;
    }

    private int getSum(String numbers) {
        return IntStream
                .range(0, numbers.length())
                .map(i -> (i % 2 + 1) * (numbers.charAt(i) - '0'))
                .map(i -> i > 9 ? i - 9 : i)
                .sum();
    }

}
