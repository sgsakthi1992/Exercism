import java.util.stream.Stream;

class ArmstrongNumbers {

    boolean isArmstrongNumber(int numberToCheck) {

        int length = String.valueOf(numberToCheck).length();
        if (length == 1) {
            return true;
        } else {
			return numberToCheck == Stream.of(String.valueOf(numberToCheck).split(""))
					.map(Integer::valueOf)
					.map(number -> (Math.pow(number, length)))
					.mapToDouble(Double::doubleValue)
					.sum();
        }
    }


}
