package Gear.Potion;

import Characters.Hero;

public class Water extends Potion {
    public Water() {
        super("Water", 1);
    }

    @Override
    public void interact(Hero player) {

        System.out.println("You found Water !");
        System.out.println("defense + " + defense);
        player.setDefensiveGear(new Water());
    }
}
