import java.util.stream.IntStream;

final class Hamming {

    private static final String LEFT_STRAND_EMPTY_MESSAGE = "left strand must not be empty.";
    private static final String RIGHT_STRAND_EMPTY_MESSAGE = "right strand must not be empty.";
    private static final String LEFT_AND_RIGHT_STRAND_LENGTH_MESSAGE
            = "leftStrand and rightStrand must be of equal length.";
    private final String leftStrand;
    private final String rightStrand;
    private final Integer leftStrandLength;
    private final Integer rightStrandLength;

    Hamming(String leftStrand, String rightStrand) {
        leftStrandLength = leftStrand.length();
        rightStrandLength = rightStrand.length();
        if (leftStrandLength.equals(0) && !rightStrandLength.equals(0)) {
            throw new IllegalArgumentException(LEFT_STRAND_EMPTY_MESSAGE);
        } else if (!leftStrandLength.equals(0) && rightStrandLength.equals(0)) {
            throw new IllegalArgumentException(RIGHT_STRAND_EMPTY_MESSAGE);
        } else if (!leftStrandLength.equals(rightStrandLength)) {
            throw new IllegalArgumentException(LEFT_AND_RIGHT_STRAND_LENGTH_MESSAGE);
        } else {
            this.leftStrand = leftStrand;
            this.rightStrand = rightStrand;
        }
    }

    int getHammingDistance() {
        return IntStream.range(0, leftStrandLength)
                .map(value -> leftStrand.charAt(value) == rightStrand.charAt(value) ? 0 : 1)
                .sum();
    }

}
