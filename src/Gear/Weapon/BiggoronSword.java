package Gear.Weapon;

import Characters.Hero;
import Gear.Potion.Ale;

public class BiggoronSword extends Weapon {

    public BiggoronSword() {
        super("Biggoron's Sword", 5);
    }

    @Override
    public void interact(Hero player) {

        System.out.println("You found a Biggoron Sword !");
        System.out.println("attack + " + attack);
        player.setOffensiveGear(new BiggoronSword());
        player.setAttack(player.getAttack() + attack);
    }

}
