import java.util.Map;

class ResistorColor {
    Map<String, Integer> resistorColors = Map.of("black", 0,
            "brown", 1,
            "red", 2,
            "orange", 3,
            "yellow", 4,
            "green", 5,
            "blue", 6,
            "violet", 7,
            "grey", 8,
            "white", 9);

    int colorCode(String color) {
        return resistorColors.get(color);
    }

    String[] colors() {
        return resistorColors.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .toArray(String[]::new);
    }
}
