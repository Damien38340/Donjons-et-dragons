package Gear.Spell;

import Characters.Hero;

public class AbraCadavra extends Spell{

    public AbraCadavra(){
        super("Abra cadavra", 1);
    }

    @Override
    public void interact(Hero player) {

        player.setOffensiveGear(this);
        player.setAttack(player.getAttack()+ this.level);
        System.out.println("You learnt Abra Cadavra !");
        System.out.println("attack + " + this.level);

    }

}
