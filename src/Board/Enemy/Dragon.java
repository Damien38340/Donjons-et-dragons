package Board.Enemy;

import Characters.Hero;

/**
 * Represents a Dragon, a specific type of enemy encountered by the player.
 * The Dragon interacts with the hero, causing damage and receiving attacks in return.
 */
public class Dragon extends CaseEnemy {

    /**
     * Constructs a Dragon enemy with default values for name, attack, and level.
     * The Dragon has an attack strength of 4 and a level (HP) of 15.
     */
    public Dragon() {
        super("Dragon", 4, 15);
    }

    /**
     * Overrides the visualizer display.
     */
    @Override
    public void interact(Hero player) {
        visualizer.displayDragon();
        super.interact(player);
    }

    /**
     * Returns a complementary description for the Dragon's attack message.
     *
     * @return A string with a personalized description for the Dragon's attack.
     */
    @Override
    public String getComplement() {
        return " and you will burn";
    }
}
