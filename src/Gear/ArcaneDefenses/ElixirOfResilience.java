package Gear.ArcaneDefenses;

import Characters.Hero;
import Characters.Warrior;

public class ElixirOfResilience extends ArcaneDefenses {

    public ElixirOfResilience() {
        super("Elixir of Resilience", 1);
    }

    @Override
    public void interact(Hero player) {
        if (!(player instanceof Warrior)) {

            if (player.getDefensiveGear() instanceof ElixirOfResilience) {
                System.out.println("You already have the " + getName() + " equipped");
            } else if (!isEquipmentNull(player) && player.getDefensiveGear().getLevel() > this.getLevel()) {
                System.out.println("Your " + player.getDefensiveGear().getName() + " is stronger than " + this.getName());
            } else {

                player.setDefensiveGear(this);
                System.out.println("You found an Elixir of Resilience !");
                System.out.println("defense + " + this.level);
            }
        } else {
            System.out.println("You're a " + player.getType() + " .You cannot use " + this.getName());
        }
    }
    public boolean isEquipmentNull(Hero player) {
        return player.getDefensiveGear() == null;
    }
}

