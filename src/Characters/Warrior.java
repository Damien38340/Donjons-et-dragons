package Characters;

import java.util.Random;

/**
 * Represents a Warrior character in the game, extending the Hero class.
 * The Warrior has attributes such as health points, attack power, and
 * defense that are initialized with random values upon creation.
 */
public class Warrior extends Hero {

    /**
     * Constructs a Warrior with a specified name and type.
     * Initializes the hero's health points and attack power with random levels,
     * and sets the defense based on the equipped defensive gear if available.
     *
     * @param name The name of the Warrior
     * @param type The type or class of the Warrior
     */
    public Warrior(String name, String type) {
        super(name, type);
        this.setHp(randomLevel());
        this.setAttack(randomLevel());
        if (getDefensiveGear() != null) {
            this.setDefense(getDefensiveGear().getLevel());
        }
    }

    /**
     * Generates a random level for the Warrior's health points and attack.
     * The random level will be between 5 and 10, inclusive.
     *
     * @return A random integer representing the level of the Warrior
     */
    public int randomLevel() {
        Random random = new Random();
        return random.nextInt(5, 11); // Generates a number from 5 to 10
    }
}
