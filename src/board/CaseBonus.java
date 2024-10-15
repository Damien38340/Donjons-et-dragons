package board;

import characters.Hero;

/**
 * Represents a bonus case on the game board that provides special advantages
 * or benefits to the hero. This is an abstract class that implements the
 * {@link Case} interface and serves as a base for specific types of bonus cases.
 */
public abstract class CaseBonus implements Case {

    /** The name of the bonus case. */
    String name;

    /** The level of the bonus case, which may influence its effectiveness. */
    int level;

    /**
     * Constructs a CaseBonus with the specified name and level.
     *
     * @param name  The name of the bonus case.
     * @param level The level of the bonus case, indicating its strength or value.
     */
    protected CaseBonus(String name, int level) {
        this.name = name;
        this.level = level;
    }
    /**
     * Interacts with the specified hero. Since this case is a bonus, it
     * notifies the player the specific bonus
     *
     * @param player the hero interacting with the bonus case
     */
    @Override
    public void interact(Hero player) {
        // Implementation will be provided in subclasses.
    }
}
