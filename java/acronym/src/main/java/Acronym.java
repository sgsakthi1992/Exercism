import java.util.stream.Collectors;
import java.util.stream.Stream;

class Acronym {

    private String phrase;

    Acronym(String phrase) {
        this.phrase = phrase;
    }

    String get() {
        return Stream.of(phrase.split("[ -]"))
                .map(s -> s.chars()
                        .filter(Character::isAlphabetic).findFirst().orElse(' '))
                .filter(Character::isAlphabetic)
                .map(Character::toString)
                .collect(Collectors.joining()).toUpperCase();
    }

}
