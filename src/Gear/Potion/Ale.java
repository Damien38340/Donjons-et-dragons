package Gear.Potion;

import Characters.Hero;

public class Ale extends Potion {
    public Ale() {
        super("Ale", 10);
    }

    @Override
    public void interact(Hero player) {

        player.setDefensiveGear(this);
        System.out.println("You found an Ale !");
        System.out.println("Restore " + this.level + " HP");
    }
}
