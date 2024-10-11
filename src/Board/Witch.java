package Board;

import Characters.Hero;

public class Witch extends CaseEnemy {

    String name = "Witch";

    public Witch() {
        super(2, 9);
    }

    @Override
    public void interact(Hero player) {

        System.out.println("I'm a Witch and I curse you !!\n Damage - " + attack);
        player.setHp(player.getHp() - this.attack);
        System.out.println("HP: " + player.getHp());
        if (player.getHp() <= 0) {
            System.out.println("You died.");
        } else {
            System.out.println("You hit the Witch !\n  + " + player.getAttack());
            level -= player.getAttack();
            System.out.println("Witch HP: " + level);
        }
    }

    @Override
    public String getName() {
        return name;
    }
}
