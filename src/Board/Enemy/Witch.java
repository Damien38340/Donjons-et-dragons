package Board.Enemy;

import Characters.Hero;

/**
 * Represents a Witch, a mystical enemy that the player can encounter.
 * The Witch interacts with the hero, causing damage and receiving attacks in return.
 */
public class Witch extends CaseEnemy {

    /**
     * Constructs a Witch enemy with default values for name, attack, and level.
     * The Witch has an attack strength of 2 and a level (HP) of 9.
     */
    public Witch() {
        super("Witch", 2, 9);
    }

    /**
     * Defines the interaction between the Witch and the hero.
     * The Witch attacks the hero, reducing the hero's HP based on the Witch's attack value and the hero's defense.
     * The hero can counter-attack, reducing the Witch's level (HP). If the hero's HP reaches zero or below, they die.
     *
     * @param player The hero interacting with the Witch.
     */
    @Override
    public void interact(Hero player) {
        visualizer.displayWitch();
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

    private int getAttackValue(Hero player) {
        return isOffensiveEquipmentNull(player) ? player.getAttack() : player.getAttack() + player.getOffensiveGear().getLevel();
    }

    private int getDefenseValue(Hero player) {
        return isDefensiveEquipmentNull(player) ? 0 : player.getDefensiveGear().getLevel();
}

    /**
     * Returns the name of the Witch.
     *
     * @return The name of the Witch.
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Returns a personalized description for the Witch's attack message.
     * This message is used to add flavor to the interaction between the Witch and the hero.
     *
     * @return A string with a personalized description for the Witch's attack.
     */
    @Override
    public String getComplement() {
        return " and I curse you!!";
    }
}

