package Gear.Weapon;

import Characters.Hero;
import Characters.Warrior;

public class BiggoronSword extends Weapon {

    public BiggoronSword() {
        super("Biggoron's Sword", 7);
    }

    @Override
    public void interact(Hero player) {
        if (player instanceof Warrior) {
            if (player.getOffensiveGear() instanceof BiggoronSword) {
                System.out.println("You already have the " + getName() + " equipped");
            } else if (!isEquipmentNull(player) && player.getOffensiveGear().getLevel() > this.getLevel()) {
                System.out.println("Your " + player.getDefensiveGear().getName() + " is stronger than " + this.getName());
            } else {
                player.setOffensiveGear(new BiggoronSword());
                System.out.println("You found a Biggoron Sword !");
                System.out.println("attack + " + level);
            }
        }
        else {
            System.out.println("You're a " + player.getType() + ". You cannot use " + this.getName());
        }
    }
    public boolean isEquipmentNull(Hero player) {
        return player.getOffensiveGear() == null;
    }
}
