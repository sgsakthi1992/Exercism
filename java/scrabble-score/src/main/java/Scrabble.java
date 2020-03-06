class Scrabble {

    private static final String LETTERS_VALUE_1 = "AEIOULNRST";
    private static final String LETTERS_VALUE_2 = "DG";
    private static final String LETTERS_VALUE_3 = "BCMP";
    private static final String LETTERS_VALUE_4 = "FHVWY ";
    private static final String LETTERS_VALUE_5 = "K";
    private static final String LETTERS_VALUE_8 = "JX";
    private static final String LETTERS_VALUE_10 = "QZ";

    private int score;

    Scrabble(String word) {
        this.score = calculateScore(word);
    }

    int getScore() {
        return score;
    }

    int calculateScore(String word) {
        return word.toUpperCase().chars()
                .map(this::getLetterScore)
                .sum();
    }

    int getLetterScore(int c) {
        String s = Character.toString((char) c);
        if (LETTERS_VALUE_1.contains(s)) {
            return 1;
        } else if (LETTERS_VALUE_2.contains(s)) {
            return 2;
        } else if (LETTERS_VALUE_3.contains(s)) {
            return 3;
        } else if (LETTERS_VALUE_4.contains(s)) {
            return 4;
        } else if (LETTERS_VALUE_5.contains(s)) {
            return 5;
        } else if (LETTERS_VALUE_8.contains(s)) {
            return 8;
        } else if (LETTERS_VALUE_10.contains(s)) {
            return 10;
        }
        return 0;
    }

}
