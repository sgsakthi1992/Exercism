public class PangramChecker {

    public boolean isPangram(String input) {
        return 26 == input.toLowerCase()
                .chars()
                .filter(item -> item >= 'a' && item <= 'z')
                .distinct().count();
    }

}
