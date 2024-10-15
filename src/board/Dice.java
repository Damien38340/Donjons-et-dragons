package board;

import java.util.Random;

/**
 * Represents dice used in the game. This class provides functionality
 * to roll a standard six-sided dice and obtain a random result between 1 and 6.
 */
public class Dice {
    private Random random;

    /**
     * Constructs Dice object and initializes the random number generator.
     */
    public Dice() {
        random = new Random();
    }

    /**
     * Rolls the dice and returns a random integer between 1 and 6, inclusive.
     *
     * @return a random integer result of the dice roll
     */
    public int roll() {
        return random.nextInt(6) + 1;
    }
}
