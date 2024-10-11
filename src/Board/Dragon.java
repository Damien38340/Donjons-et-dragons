package Board;

import Characters.Hero;

import java.awt.*;

public class Dragon extends CaseEnemy {

    String name = "Dragon";

    public Dragon() {
        super(4, 15);
    }

    @Override
    public void interact(Hero player) {

        System.out.println("I'm a Dragon and you will burn!!\n Damage - " + attack);
        player.setHp(player.getHp() - this.attack);
        System.out.println("HP: " + player.getHp());
        if (player.getHp() <= 0) {
            System.out.println("You died.");
        } else {
            System.out.println("You hit the Dragon !\n  + " + player.getAttack());
            level -= player.getAttack();
            System.out.println("Dragon HP: " + level);
        }
    }

    @Override
    public String getName() {
        return name;
    }
}
