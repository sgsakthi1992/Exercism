public class Bob {

    public String hey(String s) {
        if (s.isEmpty()) {
            return "Fine. Be that way!";
        } else if (s.chars().filter(Character::isLetter).allMatch(Character::isUpperCase)) {
            if (isQuestion(s)) {
                return "Calm down, I know what I'm doing!";
            }
            return "Whoa, chill out!";
        } else if (isQuestion(s)) {
            return "Sure.";
        }
        return "Whatever.";
    }

    private Boolean isQuestion(String s) {
        return s.endsWith("?");
    }
}