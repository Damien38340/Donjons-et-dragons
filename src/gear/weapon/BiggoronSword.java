package gear.weapon;

import characters.Hero;
import characters.Warrior;

/**
 * Represents the weapon "Biggoron's Sword," which increases a hero's attack power.
 * This weapon can only be equipped by Warrior characters.
 */
public class BiggoronSword extends Weapon {

    /**
     * Constructs the Biggoron Sword with a default name and attack power.
     * The weapon provides an attack increase of 7 when equipped.
     */
    public BiggoronSword() {
        super("Biggoron's Sword", 7);
    }

    /**
     * Allows a hero to interact with the Biggoron Sword weapon.
     * The sword can be equipped only if the hero is a Warrior.
     * If the sword is already equipped or if the hero's current offensive gear is stronger,
     * appropriate messages are displayed.
     *
     * @param player The hero interacting with the Biggoron Sword.
     */
    @Override
    public void interact(Hero player) {
        if (player instanceof Warrior) { // Check if the player is a Warrior
            // Check if the player already has the Biggoron Sword equipped
            if (player.getOffensiveGear() instanceof BiggoronSword) {
                System.out.println("You already have the " + getName() + " equipped");
            }
            // Check if the player has offensive gear and if it is stronger than Biggoron Sword
            else if (!isEquipmentNull(player) && player.getOffensiveGear().getLevel() > this.getLevel()) {
                System.out.println("Your " + player.getDefensiveGear().getName() + " is stronger than " + this.getName());
            }
            // Equip the Biggoron Sword if no conditions above are met
            else {
                player.setOffensiveGear(new BiggoronSword());
                System.out.println("You have a Biggoron Sword !");
                System.out.println("Attack + " + level);
            }
        } else {
            // Display a message if the player is not a Warrior
            System.out.println("You're a " + player.getType() + ". You cannot use " + this.getName());
        }
    }
}
