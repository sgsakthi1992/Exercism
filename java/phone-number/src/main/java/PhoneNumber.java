public class PhoneNumber {
    private String phoneNumber;
    private static String wrongLengthExceptionMessage = "incorrect number of digits";
    private static String moreThan11DigitsExceptionMessage = "more than 11 digits";
    private static String numberIs11DigitsButDoesNotStartWith1ExceptionMessage =
            "11 digits must start with 1";
    private static String illegalCharacterExceptionMessage =
            "letters not permitted";
    private static String illegalPunctuationExceptionMessage =
            "punctuations not permitted";
    private static String areaCodeStartsWithZeroExceptionMessage =
            "area code cannot start with zero";
    private static String areaCodeStartsWithOneExceptionMessage =
            "area code cannot start with one";
    private static String exchangeCodeStartsWithZeroExceptionMessage =
            "exchange code cannot start with zero";
    private static String exchangeCodeStartsWithOneExceptionMessage =
            "exchange code cannot start with one";

    public PhoneNumber(String phoneNumber) {
        phoneNumber = phoneNumber.replaceAll("[\\s.()+-]", "");
        if (phoneNumber.matches("1?[2-9]\\d{2}[2-9]\\d{6}")) {
            if (phoneNumber.startsWith("1") && phoneNumber.length() == 11) {
                phoneNumber = phoneNumber.substring(1);
            }
            this.phoneNumber = phoneNumber;
        } else {
            throw new IllegalArgumentException(getMessage(phoneNumber));
        }
    }

    private String getMessage(String phoneNumber) {
        if (phoneNumber.matches(".*[a-zA-Z]+.*"))
            return illegalCharacterExceptionMessage;
        if (phoneNumber.matches(".*[\\D].*"))
            return illegalPunctuationExceptionMessage;
        if (!phoneNumber.startsWith("1") && phoneNumber.length() == 11)
            return numberIs11DigitsButDoesNotStartWith1ExceptionMessage;
        if (phoneNumber.length() < 10)
            return wrongLengthExceptionMessage;
        if (phoneNumber.length() > 11)
            return moreThan11DigitsExceptionMessage;
        if (phoneNumber.matches("1?[0]\\d{9}"))
            return areaCodeStartsWithZeroExceptionMessage;
        if (phoneNumber.matches("1?[1]\\d{9}"))
            return areaCodeStartsWithOneExceptionMessage;
        if (phoneNumber.matches("1?[2-9]\\d{2}[0]\\d{6}"))
            return exchangeCodeStartsWithZeroExceptionMessage;
        if (phoneNumber.matches("1?[2-9]\\d{2}[1]\\d{6}"))
            return exchangeCodeStartsWithOneExceptionMessage;
        return "";
    }

    public String getNumber() {
        return phoneNumber;
    }
}