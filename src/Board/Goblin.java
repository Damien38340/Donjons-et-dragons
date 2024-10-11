package Board;

import Characters.Hero;

public class Goblin extends CaseEnemy {

    String name = "Goblin";

    public Goblin() {
        super(1, 6);
    }

    @Override
    public void interact(Hero player) {

        System.out.println("I'm a Goblin !!\n Damage - " + attack);
        player.setHp(player.getHp() - this.attack);
        System.out.println("HP: " + player.getHp());
        if (player.getHp() <= 0) {
            System.out.println("You died.");
        } else {
            System.out.println("You hit the Goblin !\n + " + player.getAttack());
            level -= player.getAttack();
            System.out.println("Goblin HP: " + level);
        }
    }

    @Override
    public String getName() {
        return name;
    }


}
