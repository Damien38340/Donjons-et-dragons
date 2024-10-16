package board.enemy;

import board.Case;
import characters.Hero;

/**
 * Represents an enemy case on the board. This abstract class provides common attributes
 * and methods for enemies, including their name, attack strength, and HP.
 * Subclasses should implement the specific behavior for each type of enemy.
 */
public abstract class CaseEnemy implements Case {

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";


    /** The name of the enemy. */
    protected String name;

    /** The attack strength of the enemy. */
    protected int attack;

    /** The level of the enemy. */
    protected int level;

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
    }
    /**
     * Defines the interaction between the enemy and the hero.
     * This method calculates damage dealt to the hero and the counter-attack from the hero.
     *
     * @param player The hero interacting with the enemy.
     */
    public void interact(Hero player) {

        //Calculate player's attack and adjust enemy's HP
        int attackValue = getAttackValue(player);
        System.out.println("You hit the " + name + "!\n" + ANSI_GREEN + " + " + attackValue + ANSI_RESET);
        level -= attackValue;
        System.out.println(name + " HP: " + level);

        if (level > 0) {
            // Calculate defense and adjust player's HP
            int defenseValue = getDefenseValue(player);
            player.setHp(player.getHp() - (this.attack - defenseValue)); // Adjust based on player's defense

            // Display attack message
            enemyAttack();
            System.out.println(player.getName() + " HP: " + player.getHp() + "\n");
        }


        // Check if player is dead
        if (player.getHp() <= 0) {
            System.out.println("You died.");
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

    protected void enemyAttack(){
        System.out.println("\nThe " + getName() + getPersonalizedAttack());
        System.out.println(ANSI_RED + " - " + attack + ANSI_RESET);
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
     */
    public void enemyArrival() {
        System.out.println("\r\nI'm a " + name + getComplement() + "!!");
    }

    /**
     * Returns a complementary description that provides additional information about the enemy.
     * Subclasses must implement this method to provide specific behavior.
     *
     * @return a complementary description of the enemy.
     */
    public abstract String getComplement();

    /**
     * Returns a personalized action when the enemy attacks.
     * Subclasses must implement this method to provide specific behavior.
     *
     * @return a personalized action message.
     */
    public abstract String getPersonalizedAttack();

}
