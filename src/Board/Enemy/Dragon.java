package Board.Enemy;

import Characters.Hero;

/**
 * Represents a Dragon, a powerful and tough enemy encountered by the player.
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
     * Defines the interaction between the Dragon and the hero.
     * The Dragon attacks the hero, reducing the hero's HP based on the Dragon's attack value and the hero's defense.
     * The hero can counter-attack, reducing the Dragon's level (HP). If the hero's HP reaches zero or below, they die.
     *
     * @param player The hero interacting with the Dragon.
     */
    @Override
    public void interact(Hero player) {
        visualizer.displayDragon();
        int defenseValue = getDefenseValue(player);
        player.setHp(player.getHp() - this.attack + defenseValue);
        String attackMessage = getAttackMessage();
        System.out.println(attackMessage);
        System.out.println(player.getName() + " HP: " + player.getHp());
        if (player.getHp() <= 0) {
            System.out.println("You died.");
        } else {
            int attackValue = getAttackValue(player);
            System.out.println("You hit the " + name + "!\n  + " + attackValue);
            level -= attackValue;
            System.out.println(name + " HP: " + level);
        }
    }


    private int getAttackValue(Hero player) {
        return isOffensiveEquipmentNull(player) ? player.getAttack() : player.getAttack() + player.getOffensiveGear().getLevel();
    }

    private int getDefenseValue(Hero player) {
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
     * Returns the name of the Dragon.
     *
     * @return The name of the Dragon.
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Returns a complementary description for the Dragon's attack message.
     *
     * @return A string with a personalized description for the Dragon's attack.
     */
    @Override
    public String getComplement() {
        return " and you will burn!!\n";
    }
}
