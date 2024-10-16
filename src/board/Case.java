package board;

import characters.Hero;

/**
 * Represents a generic case on the game board that can be interacted with by a hero.
 * This interface defines the behavior expected from any case on the board.
 */
public interface Case {

    /**
     * Allows the hero to interact with the case.
     *
     * @param player The hero that is interacting with the case.
     */
    void interact(Hero player);

    /**
     * Gets the level of the case, which may indicate the HP of the enemy or level of the equipment or potion.
     *
     * @return The level of the case as an integer.
     */
    int getLevel();

    /**
     * Gets the name of the case, which can be used for display or identification purposes.
     *
     * @return The name of the case as a String.
     */
    String getName();
    void display();

}
