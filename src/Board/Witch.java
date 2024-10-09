package Board;

import Characters.Hero;

public class Witch extends CaseEnemy {
    public Witch() {
        super(2,9);
    }

    @Override
    public void fight(Hero player) {
        System.out.println("I'm a Witch and I curse you !!");
        System.out.println(" - " + attack);
        player.setHp( player.getHp() - this.attack);

    }
}
