package Potion;

import Characters.Hero;

public class Ale extends Potion {
    public Ale() {
        super("Ale", 10);
    }

    @Override
    public void interact(Hero player) {

        System.out.println("You found an Ale !");
        System.out.println("Restore " + this.level + " HP");
        player.setHp(player.getHp() + this.level);
        System.out.println(player.getName() + " HP: " + player.getHp());
    }
}
