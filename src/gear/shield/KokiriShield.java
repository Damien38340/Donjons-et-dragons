package gear.shield;

import characters.Hero;
import characters.Warrior;

/**
 * Represents the Kokiri Shield, a type of shield that enhances the defense of a Warrior hero.
 * This shield provides additional protection to heroes when equipped.
 */
public class KokiriShield extends Shield {

    /**
     * Constructs a Kokiri Shield with a default name and defense level.
     * The Kokiri Shield provides a defense increase of 1 when equipped.
     */
    public KokiriShield() {
        super("Kokiri Shield", 1);
    }

    /**
     * Allows the Warrior hero to interact with the Kokiri Shield.
     * The hero can equip the shield unless they are not a Warrior.
     * If the shield is already equipped, or if the player's current defensive gear is stronger,
     * appropriate messages are displayed.
     *
     * @param player The hero interacting with the Kokiri Shield.
     */
    @Override
    public void interact(Hero player) {
        if (player instanceof Warrior) { // Check if the player is a Warrior
            // Check if the player already has the Kokiri Shield equipped
            if (player.getDefensiveGear() instanceof KokiriShield) {
                System.out.println("You already have the " + getName() + " equipped");
            }
            // Check if the player has defensive gear and if it is stronger than the Kokiri Shield
            else if (!isEquipmentNull(player) && player.getDefensiveGear().getLevel() > this.getLevel()) {
                System.out.println("Your " + player.getDefensiveGear().getName() + " is stronger than " + this.getName());
            }
            // Equip the Kokiri Shield if no conditions above are met
            else {
                player.setDefensiveGear(this);
                System.out.println("You have a Kokiri Shield !");
                System.out.println("Defense + " + this.level);
            }
        } else {
            // Display a message if the player is not a Warrior
            System.out.println("You're a " + player.getType() + ". You cannot use " + this.getName());
        }
    }
}
