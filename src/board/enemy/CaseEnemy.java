package board.enemy;

import board.Case;
import characters.Hero;

/**
 * Represents an enemy case on the board. This abstract class provides common attributes
 * and methods for enemies, including their name, attack strength, and HP.
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
     * @param level The HP of the enemy.
     */
    protected CaseEnemy(String name, int attack, int level) {
        this.name = name;
        this.attack = attack;
        this.level = level;
        this.visualizer = new EnemyVisualizer();
    }
    /**
     * Defines the interaction between the enemy and the hero.
     * This method calculates damage dealt to the hero and the counter-attack from the hero.
     *
     * @param player The hero interacting with the enemy.
     */
    public void interact(Hero player) {

        // Calculate defense and adjust player's HP
        int defenseValue = getDefenseValue(player);
        player.setHp(player.getHp() - (this.attack - defenseValue)); // Adjust based on player's defense

        // Display attack message
        String attackMessage = getAttackMessage();
        System.out.println(attackMessage);
        System.out.println(player.getName() + " HP: " + player.getHp());

        // Check if player is dead
        if (player.getHp() <= 0) {
            System.out.println("You died.");
        } else {
            int attackValue = getAttackValue(player);
            System.out.println("You hit the " + name + "!\n  + " + attackValue);
            level -= attackValue;
            System.out.println(name + " HP: " + level);
        }
    }

    /**
     * Calculates the hero's attack value when hitting the enemy, considering offensive gear if equipped.
     *
     * @param player The hero who is attacking the enemy.
     * @return The attack value of the hero, including any bonuses from offensive gear.
     */
    protected int getAttackValue(Hero player) {
        return isOffensiveEquipmentNull(player) ? player.getAttack() : player.getAttack() + player.getOffensiveGear().getLevel();
    }

    /**
     * Calculates the hero's defense value when the enemy attacks, considering defensive gear if equipped.
     *
     * @param player The hero being attacked by the enemy.
     * @return The defense value provided by the hero's defensive gear, or 0 if none is equipped.
     */
    protected int getDefenseValue(Hero player) {
        return isDefensiveEquipmentNull(player) ? 0 : player.getDefensiveGear().getLevel();
    }

    /**
     * Checks if the hero has offensive gear equipped.
     *
     * @param player The hero whose offensive gear is being checked.
     * @return {@code true} if the hero does not have offensive gear equipped, otherwise {@code false}.
     */
    public boolean isOffensiveEquipmentNull(Hero player) {
        return player.getOffensiveGear() == null;
    }

    /**
     * Checks if the hero has defensive gear equipped.
     *
     * @param player The hero whose defensive gear is being checked.
     * @return {@code true} if the hero does not have defensive gear equipped, otherwise {@code false}.
     */
    public boolean isDefensiveEquipmentNull(Hero player) {
        return player.getDefensiveGear() == null;
    }

    /**
     * Returns the name of the enemy.
     *
     * @return the name of the enemy.
     */
    @Override
    public String getName() {
        return name;
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
    public abstract String getComplement();
}
