package Gear.Weapon;

import Characters.Hero;

public class BiggoronSword extends Weapon {

    public BiggoronSword() {
        super("Biggoron's Sword", 5);
    }

    @Override
    public void interact(Hero player) {

        player.setOffensiveGear(new BiggoronSword());
        player.setAttack(player.getAttack() + level);
        System.out.println("You found a Biggoron Sword !");
        System.out.println("attack + " + level);

    }

}
