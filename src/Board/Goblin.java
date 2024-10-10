package Board;

import Characters.Hero;

public class Goblin extends CaseEnemy {
    public Goblin() {
        super(1,6);
    }

    @Override
    public void fight(Hero player){
        System.out.println("I'm a Goblin !!");
        System.out.println("Damage - " + attack);
        System.out.println("HP: " + player.getHp());

    }

}
