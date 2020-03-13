import java.util.Random;
import java.util.stream.IntStream;

class DnDCharacter {
    private Random random = new Random();
    private int strength = ability();
    private int dexterity = ability();
    private int constitution = ability();
    private int intelligence = ability();
    private int wisdom = ability();
    private int charisma = ability();

    int ability() {
        return IntStream
                .range(0, 4)
                .map(i -> rollDice())
                .sorted()
                .skip(1)
                .sum();
    }

    int modifier(int input) {
        return Math.floorDiv(input - 10, 2);
    }

    private int rollDice() {
        return random.nextInt(6) + 1;
    }

    int getStrength() {
        return strength;
    }

    int getDexterity() {
        return dexterity;
    }

    int getConstitution() {
        return constitution;
    }

    int getIntelligence() {
        return intelligence;
    }

    int getWisdom() {
        return wisdom;
    }

    int getCharisma() {
        return charisma;
    }

    int getHitpoints() {
        return 10 + modifier(constitution);
    }

}
