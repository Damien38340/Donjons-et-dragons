package Gear.Shield;

import Characters.Hero;

public class HylianShield extends Shield {


    public HylianShield() {
        super( "Hylian Shield", 3);
    }

    @Override
    public void interact(Hero player) {

        player.setDefensiveGear(this);
        System.out.println("You found an Hylian Shield !");
        System.out.println("defense + " + this.level);
    }


}

