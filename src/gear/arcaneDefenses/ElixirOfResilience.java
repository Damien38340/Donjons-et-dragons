package gear.arcaneDefenses;

import characters.Hero;
import characters.Warrior;

/**
 * Represents an Elixir of Resilience, a type of arcane defensive gear that enhances a hero's defense.
 * This elixir can be equipped by heroes that are not Warriors, providing them with additional protection.
 */
public class ElixirOfResilience extends ArcaneDefenses {

    /**
     * Constructs an Elixir of Resilience with a default name and defense level.
     * The Elixir provides a defense increase of 1 when equipped.
     */
    public ElixirOfResilience() {
        super("Elixir of Resilience", 1);
    }

    /**
     * Allows the hero to interact with the Elixir of Resilience.
     * The hero can equip the elixir unless they are a Warrior.
     * If the elixir is already equipped, or if the player's current defensive gear is stronger,
     * appropriate messages are displayed.
     *
     * @param player The hero interacting with the Elixir of Resilience.
     */
    @Override
    public void interact(Hero player) {
        if (!(player instanceof Warrior)) { // Check if the player is not a Warrior

            // Check if the player already has the Elixir equipped
            if (player.getDefensiveGear() instanceof ElixirOfResilience) {
                System.out.println("You already have the " + getName() + " equipped");
            }
            // Check if the player has defensive gear and if it is stronger than the Elixir
            else if (!isEquipmentNull(player) && player.getDefensiveGear().getLevel() > this.getLevel()) {
                System.out.println("Your " + player.getDefensiveGear().getName() + " is stronger than " + this.getName());
            }
            // Equip the Elixir if no conditions above are met
            else {
                player.setDefensiveGear(this);
                System.out.println("You have an Elixir of Resilience !");
                System.out.println("Defense + " + this.level);
            }
        } else {
            // Display a message if the player is a Warrior
            System.out.println("You're a " + player.getType() + ". You cannot use " + this.getName());
        }
    }
}
