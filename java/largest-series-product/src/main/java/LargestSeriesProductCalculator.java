import java.util.stream.IntStream;

class LargestSeriesProductCalculator {
    private String inputNumber;

    LargestSeriesProductCalculator(String inputNumber) {
        if (inputNumber.matches(".*[a-zA-Z]+.*"))
            throw new IllegalArgumentException("String to search may only contain digits.");
        this.inputNumber = inputNumber;
    }

    long calculateLargestProductForSeriesLength(int numberOfDigits) {
        if (numberOfDigits < 0)
            throw new IllegalArgumentException("Series length must be non-negative.");
        if (inputNumber.length() < numberOfDigits)
            throw new IllegalArgumentException("Series length must be less than or" +
                    " equal to the length of the string to search.");

        return IntStream.range(0, inputNumber.length() - numberOfDigits + 1)
                .mapToLong(index->calculateProduct(index, numberOfDigits)).max().getAsLong();
    }

    private long calculateProduct(int index, int numberOfDigits) {
        return inputNumber.substring(index, index + numberOfDigits)
                .chars()
                .map(Character::getNumericValue)
                .reduce(1, (a, b) -> a * b);
    }
}
