package potion;

import characters.Hero;

/**
 * The Ale class represents a potion that restores health to the player.
 */
public class Ale extends Potion {

    /**
     * Constructs an Ale potion with a specified name and healing level.
     */
    public Ale() {
        super("Ale", 10);
    }

    /**
     * Interacts with the specified hero, restoring health points when consumed.
     *
     * @param player the hero consuming the Ale potion
     */
    @Override
    public void interact(Hero player) {
        System.out.println("Restore " + this.level + " HP");
        player.setHp(player.getHp() + this.level);
        System.out.println(player.getName() + " HP: " + player.getHp());
    }
}
