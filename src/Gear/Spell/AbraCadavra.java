package Gear.Spell;

import Characters.Hero;

public class AbraCadavra extends Spell{

    public AbraCadavra(){
        super("Abra cadavra", 1);
    }

    @Override
    public void interact(Hero player) {

        System.out.println("You learnt Abra Cadavra !");
        System.out.println("attack + " + attack);
        player.setOffensiveGear(new WingardiumLeviosa());
        player.setAttack(player.getAttack()+attack);
    }

}
