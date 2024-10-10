package Gear.Potion;

import Characters.Hero;

public class Ale extends Potion {
    public Ale() {
        super("Ale", 3);
    }

    @Override
    public void interact(Hero player) {

        System.out.println("You found an Ale !");
        System.out.println("defense + " + defense);
        player.setDefensiveGear(new Ale());
    }
}
