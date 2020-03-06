import java.util.stream.Stream;

class IsogramChecker {

    boolean isIsogram(String phrase) {
        long distinctCount = phrase.chars().mapToObj(c -> (char) c).map(Character::toLowerCase)
                .filter(character -> !character.equals(' ') && !character.equals('-'))
                .distinct().count();
        long count = phrase.chars().mapToObj(c -> (char) c)
                .filter(character -> !character.equals(' ') && !character.equals('-')).count();

        return distinctCount == count;
    }

}
