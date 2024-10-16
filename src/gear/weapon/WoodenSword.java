package gear.weapon;

import characters.Hero;
import characters.Warrior;

/**
 * Represents the weapon "Wooden Sword," which provides a minimal attack increase.
 * This weapon can only be equipped by Warrior characters.
 */
public class WoodenSword extends Weapon {

    /**
     * Constructs the Wooden Sword with a default name and attack power.
     * The weapon provides an attack increase of 1 when equipped.
     */
    public WoodenSword() {
        super("Wooden Sword", 1);
    }

    /**
     * Allows a hero to interact with the Wooden Sword weapon.
     * The sword can be equipped only if the hero is a Warrior.
     * If the sword is already equipped or if the hero's current offensive gear is stronger,
     * appropriate messages are displayed.
     *
     * @param player The hero interacting with the Wooden Sword.
     */
    @Override
    public void interact(Hero player) {
        if (player instanceof Warrior) { // Check if the player is a Warrior
            // Check if the player already has the Wooden Sword equipped
            if (player.getOffensiveGear() instanceof WoodenSword) {
                System.out.println("You already have the " + getName() + " equipped");
            }
            // Check if the player has offensive gear and if it is stronger than the Wooden Sword
            else if (!isEquipmentNull(player) && player.getOffensiveGear().getLevel() > this.getLevel()) {
                System.out.println("Your " + player.getOffensiveGear().getName() + " is stronger than " + this.getName());
            }
            // Equip the Wooden Sword if no conditions above are met
            else {
                player.setOffensiveGear(this);
                System.out.println("You have a Wooden Sword!");
                System.out.println("Attack + " + this.level);
            }
        } else {
            // Display a message if the player is not a Warrior
            System.out.println("You're a " + player.getType() + ". You cannot use " + this.getName());
        }
    }
}
