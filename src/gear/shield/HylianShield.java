package gear.shield;

import characters.Hero;
import characters.Warrior;

/**
 * Represents the Hylian Shield, a type of shield that enhances the defense of a Warrior hero.
 * This shield provides additional protection to heroes when equipped.
 */
public class HylianShield extends Shield {

    /**
     * Constructs a Hylian Shield with a default name and defense level.
     * The Hylian Shield provides a defense increase of 3 when equipped.
     */
    public HylianShield() {
        super("Hylian Shield", 3);
    }

    /**
     * Allows the Warrior hero to interact with the Hylian Shield.
     * The hero can equip the shield unless they are not a Warrior.
     * If the shield is already equipped, or if the player's current defensive gear is stronger,
     * appropriate messages are displayed.
     *
     * @param player The hero interacting with the Hylian Shield.
     */
    @Override
    public void interact(Hero player) {
        if (player instanceof Warrior) { // Check if the player is a Warrior
            // Check if the player already has the Hylian Shield equipped
            if (player.getDefensiveGear() instanceof HylianShield) {
                System.out.println("You already have the " + getName() + " equipped");
            }
            // Check if the player has defensive gear and if it is stronger than the Hylian Shield
            else if (!isEquipmentNull(player) && player.getDefensiveGear().getLevel() > this.getLevel()) {
                System.out.println("Your " + player.getDefensiveGear().getName() + " is stronger than " + this.getName());
            }
            // Equip the Hylian Shield if no conditions above are met
            else {
                player.setDefensiveGear(this);
                System.out.println("You have an Hylian Shield !");
                System.out.println("Defense + " + this.level);
            }
        } else {
            // Display a message if the player is not a Warrior
            System.out.println("You're a " + player.getType() + ". You cannot use " + this.getName());
        }
    }
}
