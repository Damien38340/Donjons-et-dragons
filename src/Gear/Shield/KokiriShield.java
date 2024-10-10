package Gear.Shield;

import Characters.Hero;
import Gear.Potion.Ale;

public class KokiriShield extends Shield {

    public KokiriShield() {
        super("Kokiri Shield", 1);
    }

    @Override
    public void interact(Hero player) {

        System.out.println("You found a Kokiri Shield !");
        System.out.println("defense + " + defense);
        player.setDefensiveGear(new KokiriShield());
    }

}
