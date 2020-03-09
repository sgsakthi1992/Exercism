import java.util.LinkedHashMap;
import java.util.Map;

public class RomanNumeral {
    private String romanNumeral;
    private static final Map<Integer, String> ROMAN_LETTERS = new LinkedHashMap<>() {{
        put(1000, "M");
        put(900, "CM");
        put(500, "D");
        put(400, "CD");
        put(100, "C");
        put(90, "XC");
        put(50, "L");
        put(40, "XL");
        put(10, "X");
        put(9, "IX");
        put(5, "V");
        put(4, "IV");
        put(1, "I");
    }};

    public RomanNumeral(int number) {
        StringBuilder romanNumeralBuilder = new StringBuilder();
        for (Map.Entry<Integer, String> romanLetter : ROMAN_LETTERS.entrySet()) {
            while (number >= romanLetter.getKey()) {
                romanNumeralBuilder.append(romanLetter.getValue());
                number = number - romanLetter.getKey();
            }
        }
        this.romanNumeral = romanNumeralBuilder.toString();
    }

    public String getRomanNumeral() {
        return romanNumeral;
    }
}