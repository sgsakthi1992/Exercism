import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Allergies {
    private int score;

    public Allergies(int score) {
        this.score = score;
    }

    public boolean isAllergicTo(Allergen allergen) {
        System.out.println("allergen.getScore() & score = " + (allergen.getScore() & score));
        return (allergen.getScore() & score) != 0;
    }

    public List<Allergen> getList() {
        return Arrays.stream(Allergen.values())
                .filter(this::isAllergicTo)
                .collect(Collectors.toList());
    }
}