package Gear.Spell;

import Characters.Hero;
import Gear.Potion.Ale;

public class WingardiumLeviosa extends Spell {

    public WingardiumLeviosa() {
        super("Wingardium Leviosa", 2);
    }

    @Override
    public void interact(Hero player) {

        System.out.println("You learnt Wingardium Leviosa !");
        System.out.println("attack + " + attack);
        player.setOffensiveGear(new WingardiumLeviosa());
        player.setAttack(player.getAttack()+attack);
    }

}
