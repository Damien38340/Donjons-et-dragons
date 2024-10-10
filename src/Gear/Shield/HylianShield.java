package Gear.Shield;

import Characters.Hero;
import Gear.Potion.Ale;

public class HylianShield extends Shield {

    public HylianShield() {
        super( "Hylian Shield", 3);
    }

    @Override
    public void interact(Hero player) {

        System.out.println("You found an Hylian Shield !");
        System.out.println("defense + " + defense);
        player.setDefensiveGear(new HylianShield());
    }
}

