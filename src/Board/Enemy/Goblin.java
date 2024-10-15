package Board.Enemy;

import Characters.Hero;

/**
 * Represents a Goblin, a weak but aggressive enemy that the player can encounter.
 * The Goblin interacts with the hero, causing damage and receiving attacks in return.
 */
public class Goblin extends CaseEnemy {

    /**
     * Constructs a Goblin enemy with default values for name, attack, and level.
     * The Goblin has an attack strength of 1 and a level (HP) of 6.
     */
    public Goblin() {
        super("Goblin", 1, 6);
    }

    /**
     * Defines the interaction between the Goblin and the hero.
     * The Goblin attacks the hero, reducing the hero's HP based on the Goblin's attack value and the hero's defense.
     * The hero can counter-attack, reducing the Goblin's level (HP). If the hero's HP reaches zero or below, they die.
     *
     * @param player The hero interacting with the Goblin.
     */
    @Override
    public void interact(Hero player) {
        visualizer.displayGoblin();
    super.interact(player);
    }

    /**
     * Returns a personalized description for the Goblin's attack message.
     * This message is used to add flavor to the interaction between the Goblin and the hero.
     *
     * @return A string with a personalized description for the Goblin's attack.
     */
    @Override
    public String getComplement() {
        return " and I'll rip you apart";
    }
}
