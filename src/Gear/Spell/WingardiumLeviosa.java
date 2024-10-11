package Gear.Spell;

import Characters.Hero;
import Characters.Warrior;

public class WingardiumLeviosa extends Spell {

    public WingardiumLeviosa() {
        super("Wingardium Leviosa", 1);
    }

    @Override
    public void interact(Hero player) {
        if (!(player instanceof Warrior)){
            if (player.getOffensiveGear() instanceof WingardiumLeviosa) {
                System.out.println("You already have the " + getName() + " equipped");
            } else if (!isEquipmentNull(player) && player.getOffensiveGear().getLevel() > this.getLevel()) {
                System.out.println("Your " + player.getOffensiveGear().getName() + " is stronger than " + this.getName());
            } else {
                player.setOffensiveGear(this);
                System.out.println("You learnt Wingardium Leviosa !");
                System.out.println("attack + " + this.level);
            }
        }
        else {
            System.out.println("You're a " + player.getType() + " .You cannot use " + this.getName());
        }
    }
    public boolean isEquipmentNull(Hero player) {
        return player.getOffensiveGear() == null;
    }
}
