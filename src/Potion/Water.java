package Potion;

import Characters.Hero;

/**
 * The Water class represents a type of potion that restores a small amount of health to a hero.
 */
public class Water extends Potion {

    /**
     * Constructs a Water potion, which restores 1 HP.
     */
    public Water() {
        super("Water", 1);
    }

    /**
     * Interacts with the specified hero, restoring health.
     *
     * @param player the hero to interact with
     */
    @Override
    public void interact(Hero player) {
        System.out.println("You found Water!");
        System.out.println("Restore " + this.level + " HP");
        player.setHp(player.getHp() + this.level);
        System.out.println(player.getName() + " HP: " + player.getHp());
    }
}
