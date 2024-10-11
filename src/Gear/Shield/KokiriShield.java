package Gear.Shield;

import Characters.Hero;

public class KokiriShield extends Shield {

    public KokiriShield() {
        super("Kokiri Shield", 1);
    }

    @Override
    public void interact(Hero player) {

        player.setDefensiveGear(this);
        System.out.println("You found a Kokiri Shield !");
        System.out.println("defense + " + this.level);
    }

}
