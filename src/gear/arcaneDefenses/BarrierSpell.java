package gear.arcaneDefenses;

import characters.Hero;
import characters.Warrior;

/**
 * Represents a Barrier Spell, a type of arcane defensive gear that provides protection
 * to heroes. This spell enhances the hero's defensive capabilities when equipped.
 */
public class BarrierSpell extends ArcaneDefenses {

    /**
     * Constructs a BarrierSpell with a name and defense level.
     */
    public BarrierSpell() {
        super("Barrier Spell", 3);
    }

    /**
     * Interacts with the given hero, allowing them to equip the Barrier Spell if applicable.
     * If the hero is a Warrior, they cannot use this spell. If they already have the spell equipped,
     * or if their current defensive gear is stronger, a message will be displayed.
     *
     * @param player The hero interacting with the Barrier Spell.
     */
    @Override
    public void interact(Hero player) {
        if (!(player instanceof Warrior)) { // Check if the player is not a Warrior
            // Check if the player already has the Barrier Spell equipped
            if (player.getDefensiveGear() instanceof BarrierSpell) {
                System.out.println("You already have the " + getName() + " equipped");
            }
            // Check if the player has defensive gear and if it is stronger than the Barrier Spell
            else if (!isEquipmentNull(player) && player.getDefensiveGear().getLevel() > this.getLevel()) {
                System.out.println("Your " + player.getDefensiveGear().getName() + " is stronger than " + this.getName());
            }
            // Equip the Barrier Spell if no conditions above are met
            else {
                player.setDefensiveGear(this);
                System.out.println("You found a Barrier Spell !");
                System.out.println("Defense + " + this.level);
            }
        } else {
            // Display a message if the player is a Warrior
            System.out.println("You're a " + player.getType() + ". You cannot use " + this.getName());
        }
    }
}
