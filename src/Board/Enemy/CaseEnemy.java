package Board.Enemy;

import Board.Case;
import Characters.Hero;

/**
 * Represents an enemy case on the board. This abstract class provides common attributes
 * and methods for enemies, including their name, attack strength, and level.
 * Subclasses should implement the specific behavior for each type of enemy.
 */
public abstract class CaseEnemy implements Case {

    /** The name of the enemy. */
    protected String name;

    /** The attack strength of the enemy. */
    protected int attack;

    /** The level of the enemy. */
    protected int level;

    /** A visualizer object to represent the enemy's appearance. */
    protected EnemyVisualizer visualizer;

    /**
     * Constructs a CaseEnemy with the specified name, attack, and level.
     *
     * @param name The name of the enemy.
     * @param attack The attack strength of the enemy.
     * @param level The level of the enemy.
     */
    public CaseEnemy(String name, int attack, int level) {
        this.name = name;
        this.attack = attack;
        this.level = level;
        this.visualizer = new EnemyVisualizer();
    }

    /**
     * Returns the level of the enemy.
     *
     * @return the level of the enemy.
     */
    public int getLevel() {
        return level;
    }

    /**
     * Returns a message describing the enemy's attack, including its name and damage output.
     *
     * @return a string message with the enemy's name and damage.
     */
    public String getAttackMessage() {
        return "\r\nI'm a " + name + getComplement() + "!!\n Damage - " + attack;
    }

    /**
     * Returns a complementary description that provides additional information about the enemy.
     * Subclasses must implement this method to provide specific behavior.
     *
     * @return a complementary description of the enemy.
     */
    protected abstract String getComplement();
    protected abstract int getDefenseValue(Hero player);
    protected abstract int getAttackValue(Hero player);
}
