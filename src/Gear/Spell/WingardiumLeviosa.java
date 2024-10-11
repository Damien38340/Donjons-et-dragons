package Gear.Spell;

import Characters.Hero;

public class WingardiumLeviosa extends Spell {

    public WingardiumLeviosa() {
        super("Wingardium Leviosa", 2);
    }

    @Override
    public void interact(Hero player) {

        player.setOffensiveGear(this);
        player.setAttack(player.getAttack()+ this.level);
        System.out.println("You learnt Wingardium Leviosa !");
        System.out.println("attack + " + this.level);
    }

}
