package Potion;

import Characters.Hero;

public class Water extends Potion {
    public Water() {
        super("Water", 1);
    }

    @Override
    public void interact(Hero player) {

        System.out.println("You found Water !");
        System.out.println("Restore " + this.level + " HP");
        player.setHp(player.getHp() + this.level);
        System.out.println(player.getName() + " HP: " + player.getHp());
    }
}
