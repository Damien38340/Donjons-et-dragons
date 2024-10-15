package characters;

import java.util.Random;

/**
 * Represents a Wizard character in the game, extending the Hero class.
 * The Wizard has attributes such as health points and attack power,
 * which are initialized with random values upon creation.
 */
public class Wizard extends Hero {

    /**
     * Constructs a Wizard with a specified name and type.
     * Initializes the hero's health points and attack power with random levels,
     * and sets the defense based on the equipped defensive gear if available.
     *
     * @param name The name of the Wizard
     * @param type The type or class of the Wizard
     */
    public Wizard(String name, String type) {
        super(name, type);
        this.setHp(randomHP());
        this.setAttack(randomAttack());
        if (getDefensiveGear() != null) {
            this.setDefense(getDefensiveGear().getLevel());
        }
    }

    /**
     * Generates a random health points value for the Wizard.
     * The random value will be between 3 and 6, inclusive.
     *
     * @return A random integer representing the health points of the Wizard
     */
    public int randomHP() {
        Random random = new Random();
        return random.nextInt(3, 7); // Generates a number from 3 to 6
    }

    /**
     * Generates a random attack value for the Wizard.
     * The random value will be between 8 and 15, inclusive.
     *
     * @return A random integer representing the attack power of the Wizard
     */
    public int randomAttack() {
        Random random = new Random();
        return random.nextInt(8, 16); // Generates a number from 8 to 15
    }
}
