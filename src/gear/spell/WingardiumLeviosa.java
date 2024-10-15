package gear.spell;

import characters.Hero;
import characters.Warrior;

/**
 * Represents the spell "Wingardium Leviosa," which increases a hero's attack power.
 * This spell can only be equipped by non-Warrior heroes.
 */
public class WingardiumLeviosa extends Spell {

    /**
     * Constructs the Wingardium Leviosa spell with a default name and attack power.
     * The spell provides an attack increase of 1 when equipped.
     */
    public WingardiumLeviosa() {
        super("Wingardium Leviosa", 1);
    }

    /**
     * Allows a hero to interact with the Wingardium Leviosa spell.
     * The spell can be equipped unless the hero is a Warrior.
     * If the spell is already equipped or if the hero's current offensive gear is stronger,
     * appropriate messages are displayed.
     *
     * @param player The hero interacting with the Wingardium Leviosa spell.
     */
    @Override
    public void interact(Hero player) {
        if (!(player instanceof Warrior)) { // Check if the player is not a Warrior
            // Check if the player already has the Wingardium Leviosa equipped
            if (player.getOffensiveGear() instanceof WingardiumLeviosa) {
                System.out.println("You already have the " + getName() + " equipped");
            }
            // Check if the player has offensive gear and if it is stronger than Wingardium Leviosa
            else if (!isEquipmentNull(player) && player.getOffensiveGear().getLevel() > this.getLevel()) {
                System.out.println("Your " + player.getOffensiveGear().getName() + " is stronger than " + this.getName());
            }
            // Equip the Wingardium Leviosa spell if no conditions above are met
            else {
                player.setOffensiveGear(this);
                System.out.println("You learnt Wingardium Leviosa !");
                System.out.println("Attack + " + this.level);
            }
        } else {
            // Display a message if the player is a Warrior
            System.out.println("You're a " + player.getType() + ". You cannot use " + this.getName());
        }
    }
}
