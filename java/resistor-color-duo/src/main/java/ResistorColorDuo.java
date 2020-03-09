import java.util.Map;

class ResistorColorDuo {
    private Map<String, Integer> resistorColors = Map.of("black", 0,
            "brown", 1,
            "red", 2,
            "orange", 3,
            "yellow", 4,
            "green", 5,
            "blue", 6,
            "violet", 7,
            "grey", 8,
            "white", 9);

    int value(String[] colors) {
        if (colors.length == 1)
            return resistorColors.get(colors[0]);
        else
            return resistorColors.get(colors[0]) * 10 + resistorColors.get(colors[1]);
    }
}
